package admin.console.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Theme {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
