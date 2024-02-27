package com.venturenix.cmc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
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

        private String methodSignatures;

        @Column(columnDefinition = "TEXT")
        private String mainMethod;

        @Column(columnDefinition = "TEXT")
        private String inputParameters;

        @Column(columnDefinition = "TEXT")
        private String expectedOutput;

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


        public String generateClassDeclaration() {
                return String.format(CLASS_DECLARATION_TEMPLATE + //
                                this.generateOpenCodeBlock(),
                                this.getQuestionBank().getQuestionId());
        }

        public String generateFullCode() {
                return String.format(this.getMethodSignatures() + //
                                this.generateOpenCodeBlock() + //
                                CODE_TEMPLATE + //
                                this.generateEndCodeBlock() + //
                                "\n" + this.generateEndCodeBlock(),
                                this.getQuestionBank().getQuestionId());
        }

        public String generateMainMethod() {
                return String.format(MAIN_METHOD_TEMPLATE ,
                                this.getQuestionBank().getQuestionId(), //
                                this.getQuestionBank().getQuestionId(), //
                                this.getQuestionBank().getQuestionId());
        }

        public String generateOpenCodeBlock() {
                return "{";
        }

        public String generateEndCodeBlock() {
                return "}";
        }
}
