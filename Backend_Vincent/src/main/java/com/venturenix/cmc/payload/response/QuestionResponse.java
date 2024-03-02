package com.venturenix.cmc.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionResponse {
  private final String TYE = "Bearer";

  private String token;

  @JsonProperty("id")
  private Long questionId;
  private String classDeclaration;
  private String code;
  private String mainMethod;

  private Integer createdby;


  private LocalDateTime updateddate;


  private Integer updatedby;
}
