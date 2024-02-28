package com.venturenix.cmc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.venturenix.cmc.payload.response.TestCaseDTO;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// Remove the unused import statement

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "testcases")
public class TestCase implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonProperty("testcase_id")
        private Long testcaseId;

        @ManyToOne
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")
        private QuestionBank questionBank;

        @Nonnull
        private String methodSignatures;

        @Nonnull
        private String expectedOutput;

        @Nonnull
        @Column(columnDefinition = "TEXT")
        private String testComputeCase;

        @Nonnull
        @Column(columnDefinition = "TEXT")
        @JsonProperty("input1")
        private String input1;

        @Column(columnDefinition = "TEXT")
        @JsonProperty("input2")
        private String input2;

        @Column(columnDefinition = "TEXT")
        @JsonProperty("input3")
        private String input3;

        private LocalDateTime createdDate;
        private Integer createdBy;
        private LocalDateTime updatedDate;
        private Integer updatedBy;

        public static final String CLASS_DECLARATION_TEMPLATE =
                        "import java.util.*;\nimport java.math.*;\n public class Question%s";
        public static final String CODE_TEMPLATE =
                        " \n //Enter the code Here.Your class should be named Question%s.\n \n ";
        public static final String MAIN_METHOD_TEMPLATE =
                        "public static void main(String[] args) {\n" + //
                                        "    int counter = 0;\n" + //
                                        "    Question%s question%s = new Question%s();\n\n ";

        public static final String COUNT_RUNTIME =
                        "        long startTime = System.nanoTime();\n" + //
                                        "        System.out.println(\"Test Case Result: \" + counter + \" / 10\");\n"
                                        + //
                                        "        long endTime = System.nanoTime();\n"
                                        + //
                                        "        long duration = (endTime - startTime) / 1000000; // Milliseconds\n"
                                        + //
                                        "        System.out.println(\n" + //
                                        "                \"Time taken for Test Case 10: \" + duration + \" milliseconds\");\n";

        public String generateTestCase(List<TestCaseDTO> testCases) {


                StringBuilder testCaseBuilder = new StringBuilder();
                testCases.stream().forEach(e -> {
                        testCaseBuilder.append(
                                        "counter += testComputeCase(question")
                                        .append(QuestionId()).append(", ")
                                        .append(e.getInput1());
                        if (e.getInput2() != null) {
                                if (e.getInput2().equals("0")) {
                                        // Append "0" if input2 is "0"
                                        testCaseBuilder.append(",").append(0);
                                } else {
                                        testCaseBuilder.append(", ")//
                                                        .append(e.getInput2());

                                }

                                // Append input3
                                if (e.getInput3() != null) {
                                        if (e.getInput3().equals("0")) {
                                                // Append "0" if input3 is "0"
                                                testCaseBuilder.append(",")
                                                                .append(0);
                                        } else {
                                                testCaseBuilder.append(", ")
                                                                .append(e.getInput3());
                                        }
                                }


                                // append expectedOutput
                                if (e.getExpectedOutput().equals("0")) {
                                        // Append "0" if input3 is "0"
                                        testCaseBuilder.append(",").append(0);
                                } else {
                                        testCaseBuilder.append(", ").append(
                                                        e.getExpectedOutput());
                                }
                                // testCaseBuilder.append(", ").append(getExpectedOutput())
                                // .append(");\n");
                        }
                        testCaseBuilder.append("); \n");
                });

                testCaseBuilder.append(COUNT_RUNTIME)
                                .append(this.generateEndCodeBlock() + "\n");
                testCaseBuilder.append(this.getTestComputeCase());
                testCaseBuilder.append(this.generateEndCodeBlock());
                return testCaseBuilder.toString();
        }

        public Long QuestionId() {
                return this.getQuestionBank().getQuestionId();
        }

        public String generateClassDeclaration() {
                return String.format(CLASS_DECLARATION_TEMPLATE + //
                                this.generateOpenCodeBlock(), QuestionId());
        }

        public String generateFullCode() {
                return String.format(this.getMethodSignatures() + //
                                this.generateOpenCodeBlock() + //
                                CODE_TEMPLATE + //
                                this.generateEndCodeBlock() + //
                                "\n" + this.generateEndCodeBlock(),
                                QuestionId());
        }

        public String generateMainMethod() {
                StringBuilder mainMethodCode = new StringBuilder();
                mainMethodCode.append(String.format(MAIN_METHOD_TEMPLATE,
                                QuestionId(), //
                                QuestionId(), //
                                QuestionId()//
                )) //
                                .append("\n");//

                return mainMethodCode.toString();
        }

        public String generateOpenCodeBlock() {
                return "{";
        }

        public String generateEndCodeBlock() {
                return "}";
        }
}
