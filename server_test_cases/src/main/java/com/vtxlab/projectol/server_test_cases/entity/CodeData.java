package com.vtxlab.projectol.server_test_cases.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeData implements Serializable{
  private String filename;
  private String extension;
  private String code;
}
