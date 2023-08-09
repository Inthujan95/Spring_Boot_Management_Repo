package Crud.Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Crud.Management_System.model.Roles;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Long> {

  }
