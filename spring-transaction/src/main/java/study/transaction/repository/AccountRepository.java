package study.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.transaction.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findAccountByName(String name);
}
