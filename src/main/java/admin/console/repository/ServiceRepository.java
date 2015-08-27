package admin.console.repository;

import admin.console.domain.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findOneByName(String name);
    Page<Service> findAll(Pageable pageable);
}
