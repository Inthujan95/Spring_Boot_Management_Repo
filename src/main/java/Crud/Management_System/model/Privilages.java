package Crud.Management_System.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "privilage")
public class Privilages {
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			
			@Column(name = "name")
			private String name;
		
		    @CreationTimestamp
		    private LocalDateTime createDateTime;
		 
		    @UpdateTimestamp
		    private LocalDateTime updateDateTime;

		 // constructors, getters, and setters
		    
			public Privilages(Long id, String name, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
				super();
				this.id = id;
				this.name = name;
				this.createDateTime = createDateTime;
				this.updateDateTime = updateDateTime;
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public LocalDateTime getCreateDateTime() {
				return createDateTime;
			}

			public void setCreateDateTime(LocalDateTime createDateTime) {
				this.createDateTime = createDateTime;
			}

			public LocalDateTime getUpdateDateTime() {
				return updateDateTime;
			}

			public void setUpdateDateTime(LocalDateTime updateDateTime) {
				this.updateDateTime = updateDateTime;
			}
					
	            @ManyToMany(mappedBy = "privilages")
	             private Set<Roles> roles = new HashSet<>();
}
