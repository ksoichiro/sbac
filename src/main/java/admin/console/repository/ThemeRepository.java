package admin.console.repository;

import admin.console.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
    Theme findOneByName(String name);
}
