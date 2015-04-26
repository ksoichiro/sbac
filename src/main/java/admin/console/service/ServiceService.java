package admin.console.service;

import admin.console.exception.UniqueConstraintException;
import admin.console.form.ServiceForm;
import admin.console.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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

    public admin.console.domain.Service save(ServiceForm serviceForm) throws UniqueConstraintException {
        if (serviceRepository.findOneByName(serviceForm.getName()) != null) {
            throw new UniqueConstraintException();
        }
        admin.console.domain.Service service = new admin.console.domain.Service();
        service.setName(serviceForm.getName());
        return serviceRepository.save(service);
    }
}
