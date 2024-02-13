package com.vtxlab.projectol.server_test_cases.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MavenTestRunner {
  public static void runMavenTestFile(String testFileName)
      throws IOException, InterruptedException {
    // Command to run 'mvn test' for a specific test file
    String[] command = {"mvn", "test", "-Dtest=" + testFileName};

    // Create ProcessBuilder
    ProcessBuilder processBuilder = new ProcessBuilder(command);

    // Start the process
    Process process = processBuilder.start();

    // Read output from the process
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(process.getInputStream()));

    String line;
    while ((line = reader.readLine()) != null) {
      // Print output to console
      System.out.println(line);
    }

    // Wait for the process to complete
    int exitCode = process.waitFor();

    // Print exit code
    System.out.println("Maven command executed with exit code " + exitCode);
  }
}
