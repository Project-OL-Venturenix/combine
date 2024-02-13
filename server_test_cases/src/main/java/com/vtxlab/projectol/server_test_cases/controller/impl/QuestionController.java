package com.vtxlab.projectol.server_test_cases.controller.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.projectol.server_test_cases.controller.FileUtil;
import com.vtxlab.projectol.server_test_cases.controller.MavenTestRunner;
import com.vtxlab.projectol.server_test_cases.controller.QuestionOperation;
import com.vtxlab.projectol.server_test_cases.entity.CodeData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController implements QuestionOperation {

  public static List<String> coding = new ArrayList();

  @PostMapping("/receive")
  public ResponseEntity<String> receiveCode(@RequestBody CodeData codeData)
      throws IOException {
    log.info("controller : " + codeData);
    String code = codeData.getCode();
    String filename = "example"; // Replace with your desired filename

    // Generate the .java file dynamically
    generateJavaFile(codeData.getCode(),
        "src/main/java/com/vtxlab/projectol/server_test_cases/temp/Question1.java");
    // FileUtil.writeFile(filename + ".java", code);

    coding.add("save " + codeData.getCode());

    // Trigger the test
    runTest();

    return ResponseEntity.ok("Code received and processed successfully");
  }

 // @GetMapping("/runTest")
  public String runTest() {
    try {
      MavenTestRunner.runMavenTestFile("Question1Test.java");
      return "Test executed successfully";
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return "Error executing test";
    }
  }

  @GetMapping("/get")
  public String getMethodName() {
    return coding.get(0);
  }


  private void generateJavaFile(String code, String fileName)
      throws IOException {
    // Prepend the package declaration to the code
    String packageDeclaration =
        "package com.vtxlab.projectol.server_test_cases.temp;\n";
    String codeWithPackage = packageDeclaration + code;

    // Define the file path and name
    String filePath = fileName;

    // Write the code to the file
    FileUtil.writeFile(filePath, codeWithPackage);
  }
}
