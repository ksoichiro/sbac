package admin.console.service;

import admin.console.exception.UniqueConstraintException;
import admin.console.form.ServiceForm;
import admin.console.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public Page<admin.console.domain.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
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
