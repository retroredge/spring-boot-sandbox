package uk.co.redsoft.springboot;

import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ExampleController {

    @RequestMapping("/")
    public ExampleResponse home() {
        return new ExampleResponse("Hello World it's " + DateTime.now());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleController.class, args);
    }
    
    private static class ExampleResponse {
        private final String message;

        public ExampleResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}