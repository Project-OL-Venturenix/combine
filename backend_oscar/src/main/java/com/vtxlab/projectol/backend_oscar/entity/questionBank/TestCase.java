package com.vtxlab.projectol.backend_oscar.entity.questionBank;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "testcases")
public class TestCase implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "testcaseId")
        @JsonProperty("id")
        private Long testcaseId;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "question_id")
        @JsonProperty("question_id")
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
