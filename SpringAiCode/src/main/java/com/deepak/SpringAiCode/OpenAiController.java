package com.deepak.SpringAiCode;


import org.springframework.web.bind.annotation.*;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class OpenAiController
{
    private static final Logger logger = LoggerFactory.getLogger(OpenAiController.class);
    private final OpenAiChatModel chatModel;

    public OpenAiController(OpenAiChatModel chatModel)
    {
        this.chatModel = chatModel;
    }

    @GetMapping("/api/{message}")
    public String getAnswerPath(@PathVariable String message)
    {
        logger.info("Received path request with message: {}", message);
        try {
            String response = chatModel.call(message);
            logger.info("Generated response: {}", response);
            return response;
        } catch (Exception e) {
            logger.error("Error processing request: ", e);
            throw new RuntimeException("Error processing request: " + e.getMessage(), e);
        }
    }

    @GetMapping("/api")
    public String getAnswerQuery(@RequestParam String message)
    {
        logger.info("Received query request with message: {}", message);
        try {
            String response = chatModel.call(message);
            logger.info("Generated response: {}", response);
            return response;
        } catch (Exception e) {
            logger.error("Error processing request: ", e);
            throw new RuntimeException("Error processing request: " + e.getMessage(), e);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e)
    {
        logger.error("Handling exception: ", e);
        return ResponseEntity
            .internalServerError()
            .body("Error: " + e.getMessage());
    }
}
