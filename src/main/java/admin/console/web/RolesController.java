package admin.console.web;

import admin.console.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("roleList", roleService.findAll());
        return "roles/index";
    }
}
