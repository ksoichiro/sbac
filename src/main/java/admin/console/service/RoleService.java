package admin.console.service;

import admin.console.domain.Role;
import admin.console.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        List<Role> list = new ArrayList<Role>();
        for (Role role : roleRepository.findAll()) {
            list.add(role);
        }
        return list;
    }
}
