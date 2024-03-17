package com.venturenix.cmc.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	@NotBlank
  private String userName;

	@NotBlank
	private String password;

}
