package com.ai.gemini_chat;


import org.springframework.stereotype.Service;

@Service //Spring Service: spring managed component
public class QnAService {
    public String getAnswer(String question) {

        return "none initially";
    }
}
