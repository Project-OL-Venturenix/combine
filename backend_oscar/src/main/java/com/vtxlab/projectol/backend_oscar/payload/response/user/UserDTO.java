package com.vtxlab.projectol.backend_oscar.payload.response.user;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vtxlab.projectol.backend_oscar.entity.user.Role;
import com.vtxlab.projectol.backend_oscar.payload.response.event.EventDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private Long id;
  private String firstName;
  private String lastName;
  private String mobile;
  private String email;
  private String userName;
  private String password;
  private String company;
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
  private String status;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;
  private Role roles;
  private EventDTO events;
}
