package admin.console.web;

import admin.console.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String index(Model model, @PageableDefault(10) Pageable pageable) {
        model.addAttribute("roleList", roleService.findAll(pageable));
        return "roles/index";
    }
}
