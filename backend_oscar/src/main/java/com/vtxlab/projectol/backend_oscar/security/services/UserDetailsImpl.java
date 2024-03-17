package com.vtxlab.projectol.backend_oscar.security.services;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtxlab.projectol.backend_oscar.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String firstName;

  private String lastName;

  private String userName;

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
  private Integer py_experience;

  @JsonIgnore
  private Integer jv_experience;

  @JsonIgnore
  private Integer js_experience;

  @JsonIgnore
  private Integer cs_experience;

  @JsonIgnore
  private Integer sa_experience;

  @JsonIgnore
  private LocalDateTime createdDate;

  @JsonIgnore
  private Integer createdBy;

  @JsonIgnore
  private LocalDateTime updatedDate;

  @JsonIgnore
  private Integer updatedBy;

  @JsonIgnore
  private String status;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long id, String firstName, String lastName,
      String mobile, String email, String userName, String password,
      String company, String title, Integer py_experience,
      Integer jv_experience, Integer js_experience, Integer cs_experience,
      Integer sa_experience, String status, LocalDateTime createdate,
      Integer createby, LocalDateTime updatedate, Integer updateby,
      Collection<? extends GrantedAuthority> authorities) {
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
    this.cs_experience = cs_experience;
    this.sa_experience = sa_experience;
    this.status = status;
    this.createdDate = createdDate;
    this.createdBy = createdBy;
    this.updatedDate = updatedDate;
    this.updatedBy = updatedBy;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(user.getId(), //
        user.getFirstName(), //
        user.getLastName(), //
        user.getMobile(), //
        user.getEmail(), //
        user.getUserName(), //
        user.getPassword(), //
        user.getCompany(), //
        user.getTitle(), //
        user.getPyExperience(), //
        user.getJvExperience(), //
        user.getJsExperience(), //
        user.getCsExperience(), //
        user.getSaExperience(), //
        user.getStatus(), //
        user.getCreatedDate(), //
        user.getCreatedBy(), //
        user.getUpdatedDate(), //
        user.getUpdatedBy(), //
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return userName;
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
