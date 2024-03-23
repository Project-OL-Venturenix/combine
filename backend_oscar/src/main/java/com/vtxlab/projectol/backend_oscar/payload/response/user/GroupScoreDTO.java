package com.vtxlab.projectol.backend_oscar.payload.response.user;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import com.vtxlab.projectol.backend_oscar.payload.response.group.GroupUserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupScoreDTO {
  private int eventId;
  private Set<GroupResult> result;

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class GroupResult {
    private GroupUserDTO groupUserDTO;
    private Map<String, Integer> score;
    private Map<String, Integer> passingTestCaseNumber;
    private Map<String, LocalDateTime> submitTime;
    private Map<String, String> runtime;
  }

}
