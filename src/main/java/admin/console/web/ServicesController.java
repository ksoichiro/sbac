package admin.console.web;

import admin.console.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServiceService serviceService;

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("serviceList", serviceService.findAll());
        return "services/index";
    }
}
