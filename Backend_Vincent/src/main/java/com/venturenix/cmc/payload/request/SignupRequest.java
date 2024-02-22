package com.venturenix.cmc.payload.request;

import java.util.Set;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import jakarta.validation.constraints.*;

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String firstname;

  @NotBlank
  @Size(min = 3, max = 20)
  private String lastname;


  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

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

  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby; 


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getPy_experience() {
    return py_experience;
  }

  public void setPy_experience(Integer py_experience) {
    this.py_experience = py_experience;
  }

  public Integer getJv_experience() {
    return jv_experience;
  }

  public void setJv_experience(Integer jv_experience) {
    this.jv_experience = jv_experience;
  }
  
  public Integer getJs_experience() {
    return js_experience;
  }

  public void setJs_experience(Integer js_experience) {
    this.js_experience = js_experience;
  }
  
  public Integer getCs_experience() {
    return cs_experience;
  }

  public void setCs_experience(Integer cs_experience) {
    this.cs_experience = cs_experience;
  }
  
  public Integer getSa_experience() {
    return sa_experience;
  }

  public void setSa_experience(Integer sa_experience) {
    this.sa_experience = sa_experience;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }  

public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public LocalDateTime getCreateddate() {
    return createddate;
  }

  public void setCreateddate(LocalDateTime createddate) {
    this.createddate = createddate;
  }

   public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }

  public LocalDateTime getUpdateddate() {
    return updateddate;
  }

  public void setUpdateddate(LocalDateTime updateddate) {
    this.updateddate = updateddate;
  }


  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }
}
