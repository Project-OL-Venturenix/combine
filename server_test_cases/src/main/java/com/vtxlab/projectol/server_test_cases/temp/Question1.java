package com.vtxlab.projectol.server_test_cases.temp;
public class Question1 {

    public double computeTax(int[][] brackets, int income) {
        double tax = 0;
        int prev = 0;
        for (int[] bracket : brackets) {
            if (income > bracket[0]) {
                tax = tax + (double) (bracket[0] - prev) * bracket[1] / 100;
            } else {
                tax = tax + (double) (income - prev) * bracket[1] / 100;
                break;
            }
            prev = bracket[0];
        }
        return tax;
    }

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        
        int[][] brackets = {{3, 50}, {7, 10}, {12, 25}};
        int income = 10;
        double tax1 = question1.computeTax(brackets, income);
        System.out.println("Test Case 1 Result: " + tax1);

        brackets = new int[][] {{3, 50}, {7, 10}, {12, 25}};
        income = 12;
        double tax2 = question1.computeTax(brackets, income);
        System.out.println("Test Case 2 Result: " + tax2);

        brackets = new int[][] {{1, 0}, {4, 25}, {5, 50}};
        income = 2;
        double tax3 = question1.computeTax(brackets, income);
        System.out.println("Test Case 3 Result: " + tax3);

        brackets = new int[][] {{2, 50}};
        income = 0;
        double tax4 = question1.computeTax(brackets, income);
        System.out.println("Test Case 4 Result: " + tax4);

        brackets = new int[][] {{2, 50}, {3, 99}, {4, 99}};
        income = 3;
        double tax5 = question1.computeTax(brackets, income);
        System.out.println("Test Case 5 Result: " + tax5);

        brackets = new int[][] {{1, 0}};
        income = 0;
        double tax6 = question1.computeTax(brackets, income);
        System.out.println("Test Case 6 Result: " + tax6);

        brackets = new int[][] {{1, 5}, {10, 10}, {100, 20}, {1000, 30}};
        income = 1000;
        double tax7 = question1.computeTax(brackets, income);
        System.out.println("Test Case 7 Result: " + tax7);

        brackets = new int[][] {{100, 2}};
        income = 99;
        double tax8 = question1.computeTax(brackets, income);
        System.out.println("Test Case 8 Result: " + tax8);

        brackets = new int[100][2];
        for (int i = 0; i < 99; i++) {
            brackets[i] = new int[] {(i + 1) * 10, i + 1};
        }
        brackets[99][0] = 1000;
        brackets[99][1] = 1;
        income = 500;
        double tax9 = question1.computeTax(brackets, income);
        System.out.println("Test Case 9 Result: " + tax9);

        long startTime = System.nanoTime();
        double tax10 = question1.computeTax(
                new int[][] {{1, 5}, {10, 10}, {100, 20}, {1000, 30}}, 1000);
        long endTime = System.nanoTime();
        System.out.println("Test Case 10 Result: " + tax10);
        long duration = (endTime - startTime) / 1000000; // Milliseconds
        System.out.println("Time taken for Test Case 10: " + duration + " milliseconds");
    }
}
