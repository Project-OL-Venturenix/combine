package com.vtxlab.projectol.server_test_cases.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class FileUtil {
  public static void writeFile(String filename, String content) {
    if (content == null) {
      log.error("Content is null. Unable to write to file.");
      return;
    }
    Path path = Paths.get(filename);
    try {
      log.info("Writing content to file: {}", filename);
      Files.write(path, content.getBytes());
      log.info("Content written to file: {}", filename);
    } catch (IOException e) {
      e.printStackTrace(); // Handle or log the exception as needed
      log.error("Error writing to file: {}", filename, e);
    }
  }

  public static String readTxtFile(String filePath) throws IOException {
    return new String(Files.readAllBytes(Paths.get(filePath)));
  }
}
