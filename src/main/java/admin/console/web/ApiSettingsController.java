package admin.console.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api_settings")
public class ApiSettingsController {
    @RequestMapping
    public String index() {
        return "api_settings/index";
    }
}
