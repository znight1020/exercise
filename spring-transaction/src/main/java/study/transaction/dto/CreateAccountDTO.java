package study.transaction.dto;

import lombok.Builder;
import study.transaction.entity.Account;

@Builder
public record CreateAccountDTO(
		String name,
		Long balance
) {
	public Account to() {
		return Account.builder()
				.name(this.name)
				.balance(this.balance)
				.build();
	}
}
