package admin.console.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Service {
    @Id
    private Long id;
    private String name;

    public Service() {}
}
