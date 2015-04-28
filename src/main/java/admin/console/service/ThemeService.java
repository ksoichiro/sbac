package admin.console.service;

import admin.console.domain.Theme;
import admin.console.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    public Iterable<Theme> findAll() {
        return themeRepository.findAll();
    }
}
