package com.vtxlab.projectol.backend_oscar.payload.request.user;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTestCaseRequest {

  //@NotBlank
  private Long eventId;
  //@NotBlank
  private Long userId;
  //@NotBlank
  private Long questionId;
  //@NotBlank
  private Long testcaseid;
  //@NotBlank
  private OffsetDateTime runstartTimeutc;
  //@NotBlank  
  private OffsetDateTime  runendTimeutc;

  //@NotBlank  
  private OffsetDateTime  runtimeutc;

  //@NotBlank  
  private LocalDateTime  runstartTime;    
  //@NotBlank  
  private LocalDateTime runendTime;
  //@NotBlank  
  private String testcasefilepath;
  //@NotBlank  
  private String fileName;    
  //@NotBlank
  private String testcasepassstatus;      

  //@NotBlank
  private String status;

  
  private LocalDateTime createdDate;

  
  private Integer createdBy;

  
  private LocalDateTime updatedDate;

  
  private Integer updatedBy;


}