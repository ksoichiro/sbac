package admin.console.service;

import admin.console.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<admin.console.domain.Service> findAll() {
        List<admin.console.domain.Service> list = new ArrayList<admin.console.domain.Service>();
        for (admin.console.domain.Service service : serviceRepository.findAll()) {
            list.add(service);
        }
        return list;
    }
}
