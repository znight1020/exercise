package study.transaction.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import lombok.RequiredArgsConstructor;
import study.transaction.dto.AccountTransferDTO;
import study.transaction.dto.CreateAccountDTO;
import study.transaction.entity.Account;
import study.transaction.repository.AccountRepository;

@RequiredArgsConstructor
@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final PlatformTransactionManager transactionManager;

	@Transactional
	public Account createAccount(CreateAccountDTO dto) {
		Account account = dto.to();
		return accountRepository.save(account);
	}

	@Transactional
	public void transferProcessV1(AccountTransferDTO req) {
		Account senderAcc = accountRepository.findAccountByName(req.senderName());
		Account receiverAcc = accountRepository.findAccountByName(req.receiverName());

		checkBalance(senderAcc.getBalance(), req.transferAmount());

		senderAcc.decreaseBalance(req.transferAmount());
		receiverAcc.increaseBalance(req.transferAmount());
	}

	public void transferProcessV2(AccountTransferDTO req) {
		// 트랜잭션 정의
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED); // 기본 전파 방식
		def.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT); // 기본 격리 수준

		// 트랜잭션 시작
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			Account senderAcc = accountRepository.findAccountByName(req.senderName());
			Account receiverAcc = accountRepository.findAccountByName(req.receiverName());

			checkBalance(senderAcc.getBalance(), req.transferAmount());

			senderAcc.decreaseBalance(req.transferAmount());
			receiverAcc.increaseBalance(req.transferAmount());

			// 트랜잭션 커밋, 상태 변경
			transactionManager.commit(status);
		} catch (Exception e) {
			// 예외 발생 시 롤백, 상태 변경
			transactionManager.rollback(status);
			throw e; // 예외를 다시 던져서 호출자에게 전달
		}
	}


	private static void checkBalance(Long balance, Long transferAmount) {
		if(balance < transferAmount) {
			throw new RuntimeException("잔액 부족");
		}
	}

	@Transactional
	public void increaseBalanceV1(String name, Long amount) {
		Account account = accountRepository.findAccountByName(name);
		account.increaseBalance(amount);
	}

	public void increaseBalanceV2(String name, Long amount) {
		Account account = accountRepository.findAccountByName(name);
		account.increaseBalance(amount);
	}

	public Account findAccountByName(String name) {
		return accountRepository.findAccountByName(name);
	}

}
