package uk.co.redsoft.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class ExampleController {

    @RequestMapping("/")
    public ExampleResponse home() {
        ExampleResponse messages = new ExampleResponse();
        messages.addMessage("Java system property (server.port): [" + System.getProperty("server.port") + "]");
        messages.addMessage("Environment variable via System.getenv(MESSAGE): [" + System.getenv("MESSAGE") + "]");
        return messages;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleController.class, args);
    }
    
    private static class ExampleResponse {
        private final List<String> message = new ArrayList<>();

        public void addMessage(String message) {
            this.message.add(message);
        }

        public List<String> getMessage() {
            return message;
        }
    }
}