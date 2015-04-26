package admin.console.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RolesController {
    @RequestMapping
    public String index() {
        return "roles/index";
    }
}
