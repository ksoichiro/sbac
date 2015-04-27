package admin.console.repository;

import admin.console.domain.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Long> {
    Service findOneByName(String name);
    Page<Service> findAll(Pageable pageable);
}
