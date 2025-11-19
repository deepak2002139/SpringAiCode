package com.deepak.SpringAiCode;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ai.ollama.OllamaChatModel;
@RestController
public class OllamaController
{
    private ChatClient chatClient;
    public OllamaController(OllamaChatModel chatModel)
    {
        this.chatClient = ChatClient.create(chatModel);
    }
}
