package com.vtxlab.projectol.backend_oscar.payload.response.group;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GroupuserQuestionDTO {
  String questionId;
  String userId;
}
