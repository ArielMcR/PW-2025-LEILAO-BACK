package com.pw.leiloeiro.api.Controllers;

import com.pw.leiloeiro.api.DTO.ResponseAnyDTO;
import com.pw.leiloeiro.api.Domains.Feedback.Feedback;
import com.pw.leiloeiro.api.Services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<ResponseAnyDTO> getAllFeedbacks() {
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "", "" , feedbackService.getAllFeedbacks()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback feedbackDetails) {
        return feedbackService.updateFeedback(id, feedbackDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        return feedbackService.deleteFeedback(id);
    }
}
