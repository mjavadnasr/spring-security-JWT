package ir.javad.jwttutorialspringboot.repo;

import ir.javad.jwttutorialspringboot.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role , Long> {
    Role findByName(String name);
}
