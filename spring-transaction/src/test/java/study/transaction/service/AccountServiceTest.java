package study.transaction.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import study.transaction.dto.AccountTransferDTO;
import study.transaction.dto.CreateAccountDTO;
import study.transaction.entity.Account;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	private final String name1 = "LEEHS";
	private final String name2 = "SPRING";

	private CreateAccountDTO createDTO1;
	private CreateAccountDTO createDTO2;
	private AccountTransferDTO transferDTO;

	@BeforeAll
	public void init() {
		createDTO1 = CreateAccountDTO.builder()
				.name(name1)
				.balance(10000L)
				.build();

		createDTO2 = CreateAccountDTO.builder()
				.name(name2)
				.balance(10000L)
				.build();

		transferDTO = AccountTransferDTO.builder()
				.senderName(name1)
				.receiverName(name2)
				.transferAmount(5000L)
				.build();

		accountService.createAccount(createDTO1);
		accountService.createAccount(createDTO2);
	}


	@Test
	public void transferV1Test() {
		accountService.transferProcessV1(transferDTO);
	}

	@Test
	public void transferV2Test() {
		accountService.transferProcessV2(transferDTO);
	}

	@ParameterizedTest
	@ValueSource(booleans = {true, false}) // true: 트랜잭션 O, false: 트랜잭션 X
	public void dirtyCheckingTestWithTransactional(boolean useTransactional) {
		// given
		Long amount = 3000L;
		String name = useTransactional ? name2 : name1;

		// when
		if (useTransactional) {
			accountService.increaseBalanceV1(name, amount);
		} else {
			accountService.increaseBalanceV2(name, amount);
		}

		// then
		Account findAccount = accountService.findAccountByName(name);
		Assertions.assertThat(findAccount.getBalance()).isEqualTo(13000);
	}
}