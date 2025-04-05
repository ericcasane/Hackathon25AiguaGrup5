package org.tecnocampus.aquaactua.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatRestController {

    private final ChatClient chatClient;

    public ChatRestController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public String chat(@RequestBody String message) {
        log.info("Chat with message: {}", message);

        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

}