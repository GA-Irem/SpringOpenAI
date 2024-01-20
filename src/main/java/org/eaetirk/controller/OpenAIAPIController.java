package org.eaetirk.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ai/v1")
public class OpenAIAPIController {
    private final ChatClient chatClient;
    private final String PROMPT_TEMPLATE = "translate the given turkish sentence into croatian sentence {query}";

    @Autowired
    public OpenAIAPIController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/convert")
    public Map convertMessage(@RequestParam(value="message") String message){
        PromptTemplate promptTemplate =new PromptTemplate(PROMPT_TEMPLATE);
        Prompt prompt = promptTemplate.create(Map.of("query", message));
        return Map.of("generation", chatClient.generate(prompt));
    }

}
