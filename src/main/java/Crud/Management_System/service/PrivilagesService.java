package Crud.Management_System.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Crud.Management_System.model.Privilages;
import Crud.Management_System.repository.PrivilegegesRepo;
import Crud.Management_System.utils.ResourceNotFoundException;

@Service
public class PrivilagesService {
		
	    @Autowired
	    private PrivilegegesRepo privillegesRepo;

	    
	    public  List<Privilages> getAllPrivilages() {
	        return privillegesRepo.findAll();
	    }

	    public Privilages getPrivilages(long id) {
	        return privillegesRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Privilages not found with id " + id));
	    }

	    public Privilages createPrivilages(Privilages privileges) {
	        return privillegesRepo.save(privileges);
	    }

	    public Privilages updatePrivilages(Long id, Privilages privilegesService) {
	    	Privilages privileges = privillegesRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Privilages not found with id " + id));
	    	privileges.setName(privilegesService.getName());
	        return privillegesRepo.save(privileges);
	    }

	    public void deletePrivileges(Long id) {
	    	privillegesRepo.deleteById(id);
	    }

		
}
