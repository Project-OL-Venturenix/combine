package com.vtxlab.projectol.backend_oscar.payload.request.user;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.vtxlab.projectol.backend_oscar.entity.user.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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