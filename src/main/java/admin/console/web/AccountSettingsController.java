package admin.console.web;

import admin.console.domain.Theme;
import admin.console.domain.User;
import admin.console.form.AccountSettingsUpdateThemeForm;
import admin.console.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account_settings")
public class AccountSettingsController {
    @Autowired
    private ThemeService themeService;

    @RequestMapping
    public String index(@AuthenticationPrincipal User user, Model model, AccountSettingsUpdateThemeForm form) {
        model.addAttribute("themeList", themeService.findAll());
        return "account_settings/index";
    }

    @RequestMapping(value = "/update_theme", method = RequestMethod.POST)
    public String updateTheme(@AuthenticationPrincipal User user, Model model, @Validated AccountSettingsUpdateThemeForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return index(user, model, form);
        }
        Theme theme = themeService.findOneByName(form.getThemeName());
        if (theme != null) {
            user.setTheme(theme);
        }
        return "redirect:/account_settings";
    }
}
