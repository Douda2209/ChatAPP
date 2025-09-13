package com.ai.gemini_chat;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service //Spring Service: spring managed component
public class QnAService {

    // Access to API KEY and URL (Gemini)
    @Value("${gemini.api.url}")// get the value from the application propreties
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;
    public String getAnswer(String question) {
        // Construct the request payload

        // Make API Call

        // Return the response
        return "none initially";
    }
}
