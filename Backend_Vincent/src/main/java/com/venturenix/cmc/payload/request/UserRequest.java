package com.venturenix.cmc.payload.request;

import java.util.HashSet;
import java.util.Set;
import com.venturenix.cmc.entity.user.Role;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;

@Getter
@Setter
@Builder
public class UserRequest {

 private Long id;

  @NotBlank
  @Size(max = 20)
  private String firstName;

  @NotBlank
  @Size(max = 20)
  private String lastName;

  @NotBlank
  @Size(max = 120)
  private String mobile;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 20)
  private String userName;

  @NotBlank
  @Size(max = 120)
  private String password;

  @NotBlank
  @Size(max = 120)
  private String company;

  @NotBlank
  @Size(max = 120)
  private String title;

  
  private Integer py_experience;

  
  private Integer jv_experience;

  
  private Integer js_experience;

  
  private Integer cs_experience;

  
  private Integer sa_experience;

  @NotBlank
  @Size(max = 20)
  private String status;

  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy; 


  private Set<Role> roles = new HashSet<>();

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}