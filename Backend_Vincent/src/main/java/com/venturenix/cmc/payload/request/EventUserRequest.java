package com.venturenix.cmc.payload.request;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventUserRequest {


  //@NotBlank
  private Long userId;

  //@NotBlank
  private Long eventId;

  //@NotBlank
  private String status;

  
  private LocalDateTime createdDate;

  
  private Integer createdBy;

  
  private LocalDateTime updatedDate;

  
  private Integer updatedBy;
}