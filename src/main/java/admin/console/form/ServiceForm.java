package admin.console.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class ServiceForm {
    @NotEmpty
    private String name;
}
