package uk.co.redsoft.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ExampleController {

    @Value("#{systemEnvironment['MESSAGE']}")
    private String message;

    @RequestMapping("/")
    public ExampleResponse home() {
        return new ExampleResponse("Java system property (server.port): " + System.getProperty("server.port")
                                 + ". Environment Variable via System.getenv(MESSAGE): " + System.getenv("MESSAGE")
                                 + ". Environment Variable via @Value annotation (MESSAGE): " + message);
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