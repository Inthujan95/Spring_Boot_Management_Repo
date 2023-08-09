package Crud.Management_System.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Crud.Management_System.model.Privilages;
import Crud.Management_System.service.PrivilagesService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/privilages")
public class PrivilegesController {
	
			@Autowired
			private PrivilagesService privilegesService;
			
			@GetMapping("")
		    public List<Privilages> getAllPrivileges() {
		        return privilegesService.getAllPrivilages();
		    }

		    @GetMapping("/{id}")
		    public Privilages getRoleById(@PathVariable Long id) {
		        return privilegesService.getPrivilages(id);
		    }

		    @PostMapping("")
		    public Privilages createRoles(@RequestBody Privilages privileges) {
		        return privilegesService.createPrivilages(privileges);
		    }

		    @PutMapping("/{id}")	
		    public Privilages updateRoles(@PathVariable Long id, @RequestBody Privilages privilegesDetails) {
		        return privilegesService.updatePrivilages(id, privilegesDetails);
		    }

		    @DeleteMapping("/{id}")
		    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
		    	privilegesService.deletePrivileges(id);
		        return ResponseEntity.ok().build();
		    }

}
