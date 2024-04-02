package com.vtxlab.projectol.backend_oscar.payload.request.user;

import java.util.Set;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String firstName;

  @NotBlank
  @Size(min = 2, max = 20)
  private String lastName;


  @NotBlank
  @Size(min = 3, max = 20)
  private String userName;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  @NotBlank
  @Size(min = 6, max = 40)
  private String mobile;

  @NotBlank
  @Size(min = 1, max = 40)
  private String company;

  @NotBlank
  @Size(min = 1, max = 40)
  private String title;


  private Integer py_experience;


  private Integer jv_experience;


  private Integer js_experience;


  private Integer cs_experience;


  private Integer sa_experience;

  @NotBlank
  @Size(min = 1, max = 20)
  private String status;

  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;

  // public Set<String> getRole() {
  // return this.role;
  // }

  // public void setRole(Set<String> role) {
  // this.role = role;
  // }
}
