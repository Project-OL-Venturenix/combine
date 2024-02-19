package com.vtxlab.projectol.server_test_cases.controller.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.projectol.server_test_cases.controller.FileUtil;
import com.vtxlab.projectol.server_test_cases.controller.MavenTestRunner;
import com.vtxlab.projectol.server_test_cases.controller.QuestionOperation;
import com.vtxlab.projectol.server_test_cases.entity.CodeData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;


@Slf4j
@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController implements QuestionOperation {

  public static List<String> coding = new ArrayList();

  @Override
  public ResponseEntity<String> receiveCode(@RequestBody CodeData codeData)
      throws IOException {
    log.info("controller : " + codeData);
    // Generate the .java file dynamically
    generateJavaFile(codeData.getCode(),
        "src/main/java/com/vtxlab/projectol/server_test_cases/temp/Question1.java");
    cerateJsonFile(codeData.getCode(),
        "src/main/java/com/vtxlab/projectol/server_test_cases/temp/Question1.json");
    // FileUtil.writeFile(filename + ".java", code);

    coding.add("save " + codeData.getCode());

    // Trigger the test
    runTest();
    return ResponseEntity.ok("Code received and processed successfully");
  }

  private void cerateJsonFile(String code, String fileName) {
    FileUtil.writeFile(fileName, code);
  }

  @Override
  public String readTxtFile() {
    String filePath =
        "target/surefire-reports/com.vtxlab.projectol.server_test_cases.Question1Test-output.txt"; // Replace with the actual path to your file
    try {
      String fileContents = FileUtil.readTxtFile(filePath);
      System.out.println("File Contents:");
      return fileContents;
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
      e.printStackTrace();
      return e.getMessage();
    }
  }



  private String runTest() {
    try {
      MavenTestRunner.runMavenTestFile("Question1Test.java");
      return "Test executed successfully";
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return "Error executing test";
    }
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
