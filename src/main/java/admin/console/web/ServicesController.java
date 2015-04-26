package admin.console.web;

import admin.console.form.ServiceForm;
import admin.console.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/new")
    public String newService(ServiceForm form) {
        return "services/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(ServiceForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return newService(form);
        }
        serviceService.save(form);
        return "redirect:/services";
    }
}
