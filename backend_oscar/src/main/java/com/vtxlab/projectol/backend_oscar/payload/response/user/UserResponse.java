package com.vtxlab.projectol.backend_oscar.payload.response.user;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.vtxlab.projectol.backend_oscar.entity.user.Role;
public class UserResponse {
  private String token;
  private String type = "Bearer";
  private Long id; 
  private String firstName;
  private String lastName;
  private String mobile;
  private String email;
  private String userName;
  private String password;
  private String company;
  private String title;
  private Integer py_experience;
  private Integer jv_experience;
  private Integer js_experience;
  private Integer cs_experience;
  private Integer sa_experience;
  private String status;
  private Set<Role> roles = new HashSet<>();
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;
  
  
  public UserResponse(String accessToken, Long id, String firstName, String lastName, String mobile, String email, String userName, String password, String company, String title, Integer py_experience, Integer jv_experience, Integer js_experience, Integer cs_experience, Integer sa_experience, String status, LocalDateTime createdDate, Integer createdBy, LocalDateTime updatedDate, Integer updatedBy) {
    this.token = accessToken;
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.mobile = mobile;
    this.email = email;
    this.userName = userName;
    this.password = password;
    this.company = company;
    this.title = title;
    this.py_experience = py_experience;
    this.jv_experience = jv_experience;
    this.js_experience = js_experience;
    this.cs_experience = js_experience;
    this.sa_experience = sa_experience;
    this.status = status;
    this.createdDate = createdDate;
    this.createdBy = createdBy;
    this.updatedDate = updatedDate;
    this.updatedBy = updatedBy;


  
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

   public String getFirstname() {
    return firstName;
  }

  public void setFirstname(String firstName) {
    this.firstName = firstName;
  }

  public String getLastname() {
    return lastName;
  }

  public void setLastname(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return userName;
  }

  public void setUsername(String userName) {
    this.userName = userName;
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

public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

   public Integer getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Integer updatedBy) {
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getupdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(LocalDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
