package study.transaction.dto;

import lombok.Builder;

@Builder
public record AccountTransferDTO(
		String senderName,
		String receiverName,
		Long transferAmount
) {
}
