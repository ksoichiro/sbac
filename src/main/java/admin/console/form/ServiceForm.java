package admin.console.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Data
public class ServiceForm {
    @NotEmpty
    @Size(min = 1, max = 255)
    private String name;
}
