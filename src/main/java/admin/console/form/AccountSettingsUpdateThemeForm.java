package admin.console.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class AccountSettingsUpdateThemeForm {
    @NotEmpty
    private String themeName;
}
