package hello;

import com.microsoft.azure.JULLogWriter;
import com.microsoft.azure.Log4JLogWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        JULLogWriter.writeLogs();
        Log4JLogWriter.writeLogs();

        SpringApplication.run(Application.class, args);
    }

}
