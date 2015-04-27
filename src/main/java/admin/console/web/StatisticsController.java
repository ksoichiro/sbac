package admin.console.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "statistics/dashboard";
    }

    @RequestMapping("/logs")
    public String logs() {
        return "statistics/logs";
    }
}
