package uk.co.redsoft.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class ExampleController {

    private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @GetMapping("/")
    public ExampleResponse home() {
        logger.info("Root endpoint");

        ExampleResponse messages = new ExampleResponse();
        messages.addMessage("Java system server.port=" + System.getProperty("server.port"));
        messages.addMessage("Environment variable MESSAGE=" + System.getenv("MESSAGE"));
        return messages;
    }

    @GetMapping("/greeting")
    public String sayHello() {
        logger.info("Greeting endpoint");

        return "Hello";
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