package admin.console.service;

import admin.console.domain.User;
import admin.console.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        for (User user : userRepository.findAll()) {
            list.add(user);
        }
        return list;
    }
}
