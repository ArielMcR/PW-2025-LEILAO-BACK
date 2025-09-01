package com.pw.leiloeiro.api.Services;

import com.pw.leiloeiro.api.Domains.Feedback.Feedback;
import com.pw.leiloeiro.api.Domains.User.User;
import com.pw.leiloeiro.api.Repositories.FeedbackRepository;
import com.pw.leiloeiro.api.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public ResponseEntity<Feedback> getFeedbackById(Long id) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        return feedback.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Feedback createFeedback(Feedback feedback) {
        if (feedback.getAuthor() != null && feedback.getAuthor().getId_user() != null) {
            User author = userRepository.findById(feedback.getAuthor().getId_user())
                    .orElseThrow(() -> new EmptyResultDataAccessException("Author not found", 1));
            feedback.setAuthor(author);
        } else {
            throw new IllegalArgumentException("Author is required");
        }

        if (feedback.getRecipient() != null && feedback.getRecipient().getId_user() != null) {
            User recipient = userRepository.findById(feedback.getRecipient().getId_user())
                    .orElseThrow(() -> new EmptyResultDataAccessException("Recipient not found", 1));
            feedback.setRecipient(recipient);
        } else {
            throw new IllegalArgumentException("Recipient is required");
        }

        return feedbackRepository.save(feedback);
    }

    public ResponseEntity<Feedback> updateFeedback(Long id, Feedback feedbackDetails) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        if (feedback.isPresent()) {
            Feedback updatedFeedback = feedback.get();
            updatedFeedback.setComment(feedbackDetails.getComment());
            updatedFeedback.setNote(feedbackDetails.getNote());
            updatedFeedback.setAuthor(feedbackDetails.getAuthor());
            updatedFeedback.setRecipient(feedbackDetails.getRecipient());
            return ResponseEntity.ok(feedbackRepository.save(updatedFeedback));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteFeedback(Long id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
