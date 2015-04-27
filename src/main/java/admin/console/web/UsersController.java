package admin.console.web;

import admin.console.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping
    public String index(Model model, @PageableDefault(10) Pageable pageable) {
        model.addAttribute("userList", userService.findAll(pageable));
        return "users/index";
    }

    @RequestMapping("/new")
    public String newUser() {
        return "users/new";
    }
}
