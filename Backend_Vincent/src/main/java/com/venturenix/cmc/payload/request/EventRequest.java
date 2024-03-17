package com.venturenix.cmc.payload.request;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class EventRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String status;

  private LocalDateTime createdDate;
  
  private Integer createdBy;
  
  private LocalDateTime updatedDate;

  private Integer updatedBy;

}