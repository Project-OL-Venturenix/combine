package com.venturenix.cmc.payload.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GroupuserQuestionDTO {
  String questionId;
  String userId;
}
