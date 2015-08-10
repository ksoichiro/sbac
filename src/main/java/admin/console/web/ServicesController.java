package admin.console.web;

import admin.console.aspect.RoleRequired;
import admin.console.constant.RoleEnum;
import admin.console.exception.UniqueConstraintException;
import admin.console.form.ServiceForm;
import admin.console.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @RoleRequired(role = RoleEnum.ROLE_MANAGER)
    public String index(Model model, @PageableDefault(10) Pageable pageable) {
        model.addAttribute("serviceList", serviceService.findAll(pageable));
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
        try {
            serviceService.save(form);
        } catch (UniqueConstraintException e) {
            bindingResult.reject("error.services.name.duplicate");
            return newService(form);
        }
        return "redirect:/services";
    }
}
