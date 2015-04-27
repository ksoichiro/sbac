package admin.console.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account_settings")
public class AccountSettingsController {
    @RequestMapping
    public String index() {
        return "account_settings/index";
    }
}
