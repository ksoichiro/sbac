package admin.console.repository;

import admin.console.domain.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, Long> {
    Theme findOneByName(String name);
}
