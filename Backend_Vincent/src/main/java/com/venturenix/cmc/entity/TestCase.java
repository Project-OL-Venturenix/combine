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
        private String expectedOutput;

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

        
}
