public class Question1Main {
  public static void main(String[] args) {
    int counter = 0;
    Question1 question1 = new Question1();

    int[][] brackets = {{3, 50}, {7, 10}, {12, 25}};
    int income = 10;
    double tax1 = question1.computeTax(brackets, income);
    if (tax1 == 2.65000) {
      counter++;
    }
    brackets = new int[][] {{3, 50}, {7, 10}, {12, 25}};
    income = 12;
    double tax2 = question1.computeTax(brackets, income);
    if (tax2 == 3.15000) {
      counter++;
    }
    brackets = new int[][] {{1, 0}, {4, 25}, {5, 50}};
    income = 2;
    double tax3 = question1.computeTax(brackets, income);
    if (tax3 == 0.25000) {
      counter++;
    }
    brackets = new int[][] {{2, 50}};
    income = 0;
    double tax4 = question1.computeTax(brackets, income);
    if (tax4 == 0.00000) {
      counter++;
    }
    brackets = new int[][] {{2, 50}, {3, 99}, {4, 99}};
    income = 3;
    double tax5 = question1.computeTax(brackets, income);
    if (tax5 == 1.99000) {
      counter++;
    }
    brackets = new int[][] {{1, 0}};
    income = 0;
    double tax6 = question1.computeTax(brackets, income);
    if (tax6 == 0.00000) {
      counter++;
    }
    brackets = new int[][] {{1, 5}, {10, 10}, {100, 20}, {1000, 30}};
    income = 1000;
    double tax7 = question1.computeTax(brackets, income);
    if (tax7 == 288.95000) {
      counter++;
    }
    brackets = new int[][] {{100, 2}};
    income = 99;
    double tax8 = question1.computeTax(brackets, income);
    if (tax8 == 1.98000) {
      counter++;
    }
    brackets = new int[100][2];
    for (int i = 0; i < 99; i++) {
      brackets[i] = new int[] {(i + 1) * 10, i + 1};
    }
    brackets[99][0] = 1000;
    brackets[99][1] = 1;
    income = 500;
    double tax9 = question1.computeTax(brackets, income);
    if (tax9 == 127.50000) {
      counter++;
    }
    long startTime = System.nanoTime();
    double tax10 = question1.computeTax(
        new int[][] {{1, 5}, {10, 10}, {100, 20}, {1000, 30}}, 1000);
    if (tax10 == 288.95000) {
      counter++;
    }
    long endTime = System.nanoTime();
    System.out.println("Test Case Result: " + counter + " / " + 10);
    long duration = (endTime - startTime) / 1000000; // Milliseconds
    System.out
        .println("Time taken for Test Case 10: " + duration + " milliseconds");
  }

}
