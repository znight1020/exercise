package study.transaction.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long balance;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public void decreaseBalance(Long price) {
		this.balance -= price;
	}

	public void increaseBalance(Long price) {
		this.balance += price;
	}
}
