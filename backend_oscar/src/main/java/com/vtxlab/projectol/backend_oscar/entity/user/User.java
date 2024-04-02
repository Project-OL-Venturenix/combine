package com.vtxlab.projectol.backend_oscar.entity.user;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "users",
    uniqueConstraints = {@UniqueConstraint(columnNames = "userName"),
        @UniqueConstraint(columnNames = "email")})
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @JsonProperty("py_experience")
  private Integer pyExperience;

  @JsonProperty("jv_experience")
  private Integer jvExperience;

  @JsonProperty("js_experience")
  private Integer jsExperience;

  @JsonProperty("cs_experience")
  private Integer csExperience;

  @JsonProperty("sa_experience")
  private Integer saExperience;

  @NotBlank
  @Size(max = 20)
  private String status;

  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(// name = "user_roles",
      // joinColumns = @JoinColumn(name = "user_id"),
      // inverseJoinColumns = @JoinColumn(name = "role_id"))
      joinColumns = @JoinColumn(name = "user_id"))
  private Set<Role> roles = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Event> events = new HashSet<>();

}