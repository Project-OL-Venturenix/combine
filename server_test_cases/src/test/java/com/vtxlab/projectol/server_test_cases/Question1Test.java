package com.vtxlab.projectol.server_test_cases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import com.vtxlab.projectol.server_test_cases.temp.Question1;

/**
 * Copyright 2024 Venturenix LAB (vincent.lau) All Rights Reserved.
 * 
 * @author vincent.lau
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Question1Test {

    private static String artifactId = System.getProperty("projectArtifactId");
    private static int totalScore = 0;

    private static int q1Score = 0;
    private static int q1TCPassed = 0;

    private static int q1Bonus = 0;
    private static boolean q1Runtimelevel1 = false;

    private Question1 question1;

    @BeforeAll
    void init() {
        question1 = new Question1();
    }
    @AfterAll
    void score() {
        System.out.println("ID: " + artifactId
                + ", Question 1 Test Cases Passed=" + q1TCPassed);

        if (q1TCPassed == 9) {
            q1Score = 3;
            if (q1Runtimelevel1)
                q1Bonus = 1;
        }
        totalScore = q1Score + q1Bonus;// + q2Score + q2Bonus + q3Score + q3Bonus;

        System.out.println("ID: " + artifactId + ", Q1 Basic Score=" + q1Score);
        System.out.println(
                "ID: " + artifactId + ", Q1 Performance Bonus=" + q1Bonus);
        System.out.println("ID: " + System.getProperty("projectArtifactId")
                + ", Total Score=" + totalScore);
    }

    /**
     * Functional Testing for Question 1.
     */
    @Test
    void question1Case1() {
        double tax = question1 //dynamic
                .computeTax(new int[][] {{3, 50}, {7, 10}, {12, 25}}   ,   10);
        assertThat(tax, is(2.65000));
        q1TCPassed++;
        
    }

    // user : code text -> compile file -> text case result X10
    // system :
    //
    @Test
    void question1Case2() {
        double tax = question1
                .computeTax(new int[][] {{3, 50}, {7, 10}, {12, 25}}, 12);
        assertThat(tax, is(3.15000));
        q1TCPassed++;
    }

    @Test
    void question1Case3() {
        double tax =
                question1.computeTax(new int[][] {{1, 0}, {4, 25}, {5, 50}}, 2);
        assertThat(tax, is(0.25000));
        q1TCPassed++;
    }

    @Test
    void question1Case4() {
        double tax = question1.computeTax(new int[][] {{2, 50}}, 0);
        assertThat(tax, is(0.00000));
        q1TCPassed++;
    }

    @Test
    void question1Case5() {
        double tax = question1
                .computeTax(new int[][] {{2, 50}, {3, 99}, {4, 99}}, 3);
        assertThat(tax, is(1.99000));
        q1TCPassed++;
    }

    @Test
    void question1Case6() {
        double tax = question1.computeTax(new int[][] {{1, 0}}, 0);
        assertThat(tax, is(0.00000));
        q1TCPassed++;
    }

    @Test
    void question1Case7() {
        double tax = question1.computeTax(
                new int[][] {{1, 5}, {10, 10}, {100, 20}, {1000, 30}}, 1000);
        assertThat(tax, is(288.95000));
        q1TCPassed++;
    }

    @Test
    void question1Case8() {
        double tax = question1.computeTax(new int[][] {{100, 2}}, 99);
        assertThat(tax, is(1.98000));
        q1TCPassed++;
    }

    @Test
    void question1Case9() {
        int[][] brackets = new int[100][2];
        for (int i = 0; i < 99; i++) {
            brackets[i] = new int[] {(i + 1) * 10, i + 1};
        }
        brackets[99][0] = 1000;
        brackets[99][1] = 1;

        double tax = question1.computeTax(brackets, 500);
        assertThat(tax, is(127.5));
        q1TCPassed++;
    }

    @Test
    void testTimeComplexity_q1_Level1() {
        // Mac Pro Max 32GB ram, ms
        // Mac Air 16GB, ms
        // Mac Pro,
        // Window i5,
        assertThat(question1.computeTax(
                new int[][] {{1, 5}, {10, 10}, {100, 20}, {1000, 30}}, 1000),
                is(288.95000));

        assertTimeout(Duration.ofMillis(100), () -> {
            for (int i = 0; i < 100_000; i++) {
                question1.computeTax(
                        new int[][] {{1, 5}, {10, 10}, {100, 20}, {1000, 30}},
                        1000);
            }
        });
        q1Runtimelevel1 = true;
    }
}