// package com.vtxlab.projectol.server_test_cases;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTimeout;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.ArgumentMatchers.contains;
// import java.time.Duration;
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;
// import com.vtxlab.projectol.server_test_cases.temp.Question1;

// public class Question2Test {
//   private static String artifactId = System.getProperty("projectArtifactId");
//   private static int q2Score = 0;
//   private static int q2TCPassed = 0;
//   private static int q2Bonus = 0;
//   private static boolean q2Runtimelevel1 = false;
//   private Question2 question2;

//   @BeforeAll
//   void init() {
//     question2 = new Question2();
//   }

//   @AfterAll
//   void score() {
//     System.out.println(
//         "ID: " + artifactId + ", Question 2 Test Cases Passed=" + q2TCPassed);
//     if (q2TCPassed == 5) {
//       q2Score = 4;
//       if (q2Runtimelevel1)
//         q2Bonus = 2;
//     }
//     // Question 1: 3 + 1
//     // Question 2: 4 + 2
//     // Question 3: 5 + max. 4
//     totalScore = q1Score + q1Bonus;// + q2Score + q2Bonus + q3Score + q3Bonus;

//     System.out.println("ID: " + artifactId + ", Q1 Basic Score=" + q1Score);
//     System.out
//         .println("ID: " + artifactId + ", Q1 Performance Bonus=" + q1Bonus);
//     System.out.println("ID: " + artifactId + ", Q2 Basic Score=" + q2Score);
//     System.out
//         .println("ID: " + artifactId + ", Q2 Performance Bonus=" + q2Bonus);
//     System.out.println("ID: " + System.getProperty("projectArtifactId")
//         + ", Total Score=" + totalScore);
//   }

//   /**
//    * Functional Testing for Question 2.
//    */
//   @Test
//   void question2Case1() {
//     List<Integer> integers = question2.duplicateCounts(new int[] {1, 1, 3, 2},
//         new int[] {2, 3}, new int[] {3});
//     assertThat(integers, containsInAnyOrder(2, 3));
//     assertThat(integers, not(contains(Integer.valueOf(1))));
//     assertThat(integers, hasSize(2));
//     q2TCPassed++;
//   }

//   @Test
//   void question2Case2() {
//     List<Integer> integers = question2.duplicateCounts(new int[] {3, 1},
//         new int[] {2, 3}, new int[] {1, 2});
//     assertThat(integers, containsInAnyOrder(1, 2, 3));
//     assertThat(integers, not(contains(Integer.valueOf(1))));
//     assertThat(integers, hasSize(3));
//     q2TCPassed++;
//   }

//   @Test
//   void question2Case3() {
//     List<Integer> integers = question2.duplicateCounts(new int[] {1, 2, 2},
//         new int[] {4, 3, 3}, new int[] {5});
//     assertThat(integers, is(empty()));
//     assertThat(integers, hasSize(0));
//     q2TCPassed++;
//   }

//   @Test
//   void question2Case4() {
//     List<Integer> integers = question2.duplicateCounts(
//         new int[] {1, 2, 100, 100, 100, 2, 3, 4, 5, 6, 7, 65, 8, 9, 11, 12, 13,
//             14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 100, 100, 100, 100,
//             100, 100, 100, 100, 100},
//         new int[] {4, 3, 3, 99, 100, 1, 2, 3, 4, 5, 6, 7, 65, 8, 9, 11, 12, 13,
//             14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25},
//         new int[] {5, 6, 7, 8, 4, 34, 55, 66, 77, 88, 99, 100});

//     assertThat(integers, is(not(empty())));
//     assertThat(integers, hasSize(27));
//     q2TCPassed++;
//   }

//   @Test
//   void question2Case5() {
//     int[] nums1 = new int[100];
//     int[] nums2 = new int[100];
//     int[] nums3 = new int[100];

//     for (int i = 0; i < 100; i++) {
//       nums1[i] = i + 1;
//     }
//     int j = 0;
//     for (int i = 100; i > 0; i--) {
//       nums2[j++] = i;
//     }
//     Arrays.fill(nums3, 100);

//     List<Integer> integers = question2.duplicateCounts(nums1, nums2, nums3);
//     assertTrue(!integers.isEmpty());
//     assertEquals(100, integers.size());
//     q2TCPassed++;
//   }

//   @Test
//   void testTimeComplexity_q2_Level1() {
//     // Mac Pro Max 32GB ram, 60 ms
//     // Mac Air 16GB, 67 ms
//     // Mac Pro,
//     // Window i5,
//     List<Integer> integers = question2.duplicateCounts(
//         new int[] {1, 2, 100, 100, 100, 2, 3, 4, 5, 6, 7, 65, 8, 9, 11, 12, 13,
//             14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 100, 100, 100, 100,
//             100, 100, 100, 100, 100},
//         new int[] {4, 3, 3, 99, 100, 1, 2, 3, 4, 5, 6, 7, 65, 8, 9, 11, 12, 13,
//             14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25},
//         new int[] {5, 6, 7, 8, 4, 34, 55, 66, 77, 88, 99, 100});
//     assertThat(integers, is(not(empty())));
//     assertThat(integers, hasSize(27));

//     assertTimeout(Duration.ofMillis(300), () -> {
//       for (int i = 0; i < 100_000; i++) {
//         question2.duplicateCounts(
//             new int[] {1, 2, 100, 100, 100, 2, 3, 4, 5, 6, 7, 65, 8, 9, 11, 12,
//                 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 100, 100,
//                 100, 100, 100, 100, 100, 100, 100},
//             new int[] {4, 3, 3, 99, 100, 1, 2, 3, 4, 5, 6, 7, 65, 8, 9, 11, 12,
//                 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25},
//             new int[] {5, 6, 7, 8, 4, 34, 55, 66, 77, 88, 99, 100});
//       }
//     });
//     q2Runtimelevel1 = true;
//   }

// }
