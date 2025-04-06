package cloud.study.dto;

import lombok.Builder;

@Builder
public record UserInfo(
    String email,
    String name
) {

}
