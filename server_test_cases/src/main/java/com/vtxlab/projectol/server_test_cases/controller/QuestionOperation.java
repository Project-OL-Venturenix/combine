package com.vtxlab.projectol.server_test_cases.controller;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.projectol.server_test_cases.entity.CodeData;

public interface QuestionOperation {
  @PostMapping("/receive")
  ResponseEntity<String> receiveCode(@RequestBody CodeData codeData)
      throws IOException;

  @GetMapping("/readTxtFile")
  String readTxtFile();

}
