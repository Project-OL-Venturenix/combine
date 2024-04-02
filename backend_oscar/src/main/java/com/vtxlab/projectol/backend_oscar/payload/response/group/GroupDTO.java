package com.vtxlab.projectol.backend_oscar.payload.response.group;

import java.time.LocalDateTime;
import java.util.Set;
import com.vtxlab.projectol.backend_oscar.payload.response.event.EventDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDTO {
  private Long groupsId;

  private String name;
  private String status;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;

  private Set<EventDTO> events;

  private Set<UserDTO> users;

}
