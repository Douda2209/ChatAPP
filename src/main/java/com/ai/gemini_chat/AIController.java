package com.ai.gemini_chat;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RestController
@RequestMapping("/api/qna")
@AllArgsConstructor // to generate constructors with all parameters: autowiring
public class AIController {

    private final QnAService qnAService ;

    public ResponseEntity<String> askQuestion (@RequestBody Map<String, String> payload) {
        String question = payload.get("question");
        String answer = qnAService.getAnswer(question); // to be implemented later

        return ResponseEntity.ok(answer);

    }
}


