package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
