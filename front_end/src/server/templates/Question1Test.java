public class Question1Test {
  public static void main(String[] args) {
    Question1 question1 = new Question1();
    double tax1 =
        question1.computeTax(new int[][] {{3, 50}, {7, 10}, {12, 25}}, 10);
    System.out.println(tax1 == 2.65000);
    double tax2 =
        question1.computeTax(new int[][] {{3, 50}, {7, 10}, {12, 25}}, 12);
    System.out.println(tax2 == 3.25000);
    double tax3 =
        question1.computeTax(new int[][] {{1, 0}, {4, 25}, {5, 50}}, 2);
    System.out.println(tax3 == 0.25000);
    double tax4 = question1.computeTax(new int[][] {{2, 50}}, 0);
    System.out.println(tax4 == 0.00000);
    double tax5 =
        question1.computeTax(new int[][] {{2, 50}, {3, 99}, {4, 99}}, 3);
    System.out.println(tax5 == 1.99000);
    double tax6 = question1.computeTax(new int[][] {{1, 0}}, 0);
    System.out.println(tax6 == 0.00000);
    double tax7 = question1.computeTax(
        new int[][] {{1, 5}, {10, 10}, {100, 20}, {1000, 30}}, 1000);
    System.out.println(tax7 == 288.95000);
    double tax8 = question1.computeTax(new int[][] {{100, 2}}, 99);
    System.out.println(tax8 == 1.98000);

    int[][] brackets = new int[100][2];
    for (int i = 0; i < 99; i++) {
      brackets[i] = new int[] {(i + 1) * 10, i + 1};
    }
    brackets[99][0] = 1000;
    brackets[99][1] = 1;

    double tax9 = question1.computeTax(brackets, 500);
    System.out.println(tax9 == 127.50000);

  }
}
