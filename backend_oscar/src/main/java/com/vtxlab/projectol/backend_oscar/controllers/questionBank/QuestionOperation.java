package com.vtxlab.projectol.backend_oscar.controllers.questionBank;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBonusRuntime;
import com.vtxlab.projectol.backend_oscar.payload.request.question.QuestionRequest;
import com.vtxlab.projectol.backend_oscar.payload.response.question.QuestionBankDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.question.QuestionResponse;
import jakarta.validation.Valid;

public interface QuestionOperation {

        @PostMapping("/questions/add")
        public ResponseEntity<?> addQuestion(
                        @Valid @RequestBody QuestionRequest questionRequest);

        @GetMapping("/questions")
        public ResponseEntity<List<QuestionBank>> getAllQuestions();

        @GetMapping("/questions/{eventid}")
        public ResponseEntity<List<QuestionBankDTO>> getQuestionByEventId(
                        @PathVariable String eventid);

        @PatchMapping("/addEventQuestion/event/{eventId}/question/{questionId}")
        public ResponseEntity<?> addQuestionInEvent(//
                        @PathVariable("eventId") Long eventId, //
                        @PathVariable("questionId") Long questionId);

        @GetMapping("/questionRun/{id}")
        public ResponseEntity<QuestionResponse> getQuestionRunById(
                        @PathVariable("id") String id);

        @GetMapping("/questionSubmit/{id}")
        public ResponseEntity<QuestionResponse> getQuestionSubmitById(
                        @PathVariable("id") String id);

        @PostMapping("/questionBonus/{id}")
        @ResponseStatus(HttpStatus.CREATED)
        public QuestionBonusRuntime updateQuestionBonus(
                        @PathVariable("id") String id, //
                        @RequestBody QuestionBonusRuntime questionBonusRuntime);

        @PutMapping("/questions/{id}")
        public ResponseEntity<QuestionBank> updateQuestion(
                        @PathVariable("id") long id,
                        @RequestBody QuestionBank question);

        @DeleteMapping("/questions/{id}")
        public ResponseEntity<?> deleteQuestion(@PathVariable("id") long id);

}
