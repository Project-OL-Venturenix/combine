package com.venturenix.cmc.payload.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GroupUserDTO {
  Long id;
  Long groupId;
  Long userId;
}
