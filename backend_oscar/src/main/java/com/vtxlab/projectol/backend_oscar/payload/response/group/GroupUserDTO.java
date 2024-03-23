package com.vtxlab.projectol.backend_oscar.payload.response.group;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GroupUserDTO {
  Long groupId;
  Map<Long, String> users;
}
