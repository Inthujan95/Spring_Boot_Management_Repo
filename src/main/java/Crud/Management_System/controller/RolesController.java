package Crud.Management_System.controller;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Crud.Management_System.model.Roles;
import Crud.Management_System.service.RolesService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

     @Slf4j
	@RestController
	@RequestMapping("/api/roles")
	public class RolesController {
    	 
		@Autowired
		private RolesService roleService;
		
		@GetMapping("")
	    public List<Roles> getAllRoles() {

			return roleService.getAllRoles();
	    }

	    @GetMapping("/{id}")
	    public Roles getRoleById(@PathVariable Long id) {
	        return roleService.getRoles(id);
	    }

	    @PostMapping("/add")
	    public Roles createRoles(@RequestBody Roles roles) {

			log.info(roles.getName());
			log.info("role controller worked");

			return roleService.createRoles(roles);
	    }

	    @PutMapping("/{id}")	
	    public Roles updateRoles(@PathVariable Long id, @RequestBody Roles roleDetails) {
	        return roleService.updateRoles(id, roleDetails);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
	    	roleService.deleteRoles(id);
	        return ResponseEntity.ok().build();
	    }

}
