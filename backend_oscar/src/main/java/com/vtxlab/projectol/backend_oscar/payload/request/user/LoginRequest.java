package com.vtxlab.projectol.backend_oscar.payload.request.user;

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
