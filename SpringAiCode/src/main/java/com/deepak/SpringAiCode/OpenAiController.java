package com.deepak.SpringAiCode;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.openai.OpenAiChatModel;

@RestController
public class OpenAiController
{
    private OpenAiChatModel chatModel;

    public OpenAiController(OpenAiChatModel chatModel)
    {
        this.chatModel = chatModel;
    }
//    @GetMapping("/api{message}")
//    public String getAnswer(@PathVariable String message)
//    {
//        return "Hello, World!"+ message;
//    }
    @GetMapping("/api/{message}")
    public String getAnswer(@PathVariable String message)
    {
        String response = chatModel.call(message);
        return response;
    }
}
