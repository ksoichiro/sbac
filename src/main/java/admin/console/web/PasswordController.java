package admin.console.web;

import admin.console.domain.User;
import admin.console.form.PasswordUpdateForm;
import admin.console.repository.UserRepository;
import admin.console.validator.PasswordMatchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/password")
public class PasswordController {
    @Autowired
    private PasswordMatchValidator validator;

    @Autowired
    private UserRepository userRepository;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @RequestMapping("/edit")
    public String edit(PasswordUpdateForm form) {
        return "password/edit";
    }

    @RequestMapping("/update")
    public String update(@AuthenticationPrincipal User user, @Validated PasswordUpdateForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return edit(form);
        }
        user.setPassword(new StandardPasswordEncoder().encode(form.getNewPassword()));
        userRepository.save(user);
        return "redirect:/";
    }
}
