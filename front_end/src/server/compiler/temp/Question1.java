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
}