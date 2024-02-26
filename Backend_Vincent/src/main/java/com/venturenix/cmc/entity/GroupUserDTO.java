package com.venturenix.cmc.entity;

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
  Long groupId;
  List<Long> userId;
}
