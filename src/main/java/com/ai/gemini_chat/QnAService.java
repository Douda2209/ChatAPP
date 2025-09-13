package com.ai.gemini_chat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service //Spring Service: spring managed component
public class QnAService {

    // Access to API KEY and URL (Gemini)
    @Value("${gemini.api.url}")// get the value from the application propreties
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    // Make API call with a webClient:
    private WebClient webClient;
    // Constructor for the Web Client

    public QnAService(WebClient.Builder webClient){
        this.webClient = webClient.build();
    }

    public String getAnswer(String question) {

        // Construct the request payload
        // Gemini Request Body to use the mapping:
        // {
        //    "contents": [
        //      {
        //        "parts": [
        //          {
        //            "text": "here is the question of the user"
        //          }
        //        ]
        //      }
        //    ]
        //  }
        //  contents:[{parts:[{text: value}]}]
        Map<String, Object> requestBody = Map.of("contents", new Object[] {  // immutable Map
                Map.of("parts", new Object[] {
                        Map.of("text", question)
                                                    }
                                                        )
                                                            }
                                                                );



        // Make API Call:
        // URI: URL+API_Key
        // combine the gemini URL with the API Key
        String response = webClient.post().uri(geminiApiUrl + geminiApiKey)
                        .header("Content-Type", "application/json")
                        .bodyValue(requestBody)
                        .retrieve()// execute the request and expect a response
                        .bodyToMono(String.class)// convert the response into reactive mono wrapper contains a string
                        .block(); // body value is the map in json that contains the question of user


        // Return the response
        return response ;
    }
}
