package com.venturenix.cmc.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.venturenix.cmc.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String firstname;

  private String lastname;

  private String username;

  private String email;

  @JsonIgnore
  private String password;

  @JsonIgnore
  private String mobile;

  @JsonIgnore
  private String company;

  @JsonIgnore
  private String title;

  @JsonIgnore
  private Long py_experience;

  @JsonIgnore
  private Long jv_experience;

  @JsonIgnore
  private Long js_experience;

  @JsonIgnore
  private Long cs_experience;

  @JsonIgnore
  private Long sa_experience;

  @JsonIgnore
  private LocalDateTime createddate;

  @JsonIgnore
  private Long createdby;

  @JsonIgnore
  private LocalDateTime updateddate;

  @JsonIgnore
  private Long updatedby; 

  @JsonIgnore
  private String status;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long id, String firstname, String lastname, String mobile, String email, String username, String password, String company, String title, Long py_experience, Long jv_experience, Long js_experience, Long cs_experience, Long sa_experience, String status, LocalDateTime createdate, Long createby, LocalDateTime updatedate, Long updateby, Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.username = username;
    this.password = password;
    this.company = company;
    this.title = title;
    this.py_experience = py_experience;
    this.jv_experience = jv_experience;
    this.js_experience = js_experience;
    this.cs_experience = cs_experience;
    this.sa_experience = sa_experience;
    this.status = status;
    this.createddate = createddate;
    this.createdby = createdby;
    this.updateddate = updateddate;
    this.updatedby = updatedby;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(), 
        user.getFirstname(), 
        user.getLastname(), 
        user.getMobile(), 
        user.getEmail(),
        user.getUsername(), 
        user.getPassword(), 
        user.getCompany(), 
        user.getTitle(), 
        user.getPy_experience(), 
        user.getJv_experience(), 
        user.getJs_experience(), 
        user.getCs_experience(), 
        user.getSa_experience(), 
        user.getStatus(), 
        user.getCreateddate(), 
        user.getCreatedby(), 
        user.getUpdateddate(), 
        user.getUpdatedby(), 
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }  


  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  
  
  public String getMobile() {
    return mobile;
  }

  
  public String getCompany() {
    return company;
  }

  
  
  public String getTitle() {
    return title;
  }

  
  public Long getPy_experience() {
    return py_experience;
  }

  
  
  public Long getJv_experience() {
    return jv_experience;
  }

  
  public Long getJs_experience() {
    return js_experience;
  }

  
  
  public Long getCs_experience() {
    return cs_experience;
  }

  
  public Long getSa_experience() {
    return sa_experience;
  }

public Long getCreatedby() {
    return createdby;
  }



  public LocalDateTime getCreateddate() {
    return createddate;
  }


   public Long getUpdatedby() {
    return updatedby;
  }



  public LocalDateTime getUpdateddate() {
    return updateddate;
  }



  public String getStatus() {
    return status;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
