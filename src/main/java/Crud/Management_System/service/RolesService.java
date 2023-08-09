package Crud.Management_System.service;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Crud.Management_System.model.Roles;
import Crud.Management_System.repository.RolesRepo;
import Crud.Management_System.utils.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RolesService {

    @Autowired
    private RolesRepo rolesRepo;

    public  List<Roles> getAllRoles() {
        return rolesRepo.findAll();
    }

    public Roles getRoles(long id) {
        return rolesRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + id));
    }

    public Roles createRoles(Roles roles) {


        return rolesRepo.save(roles);


    }

    public Roles updateRoles(Long id, Roles rolesDetails) {
        Roles roles = rolesRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + id));
        roles.setName(rolesDetails.getName());
        return rolesRepo.save(roles);
    }

    public void deleteRoles(Long id) {
        rolesRepo.deleteById(id);
    }

}
