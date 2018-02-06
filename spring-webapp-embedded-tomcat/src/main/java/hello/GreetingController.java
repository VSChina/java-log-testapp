package hello;

import com.microsoft.azure.JULLogWriter;
import com.microsoft.azure.Log4JLogWriter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        JULLogWriter.writeLog(java.util.logging.Level.INFO, "Greeting request received.");
        Log4JLogWriter.writeLog(org.apache.log4j.Level.INFO, "Greeting request received.");

        model.addAttribute("name", name);
        return "greeting";
    }

}
