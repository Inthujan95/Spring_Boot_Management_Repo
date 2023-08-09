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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "roles")
	public class Roles {
		public Roles(String name) {
			this.name = name;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
        @Column(name = "name")
		private String name;
		 
	    @CreationTimestamp
	    private LocalDateTime createDateTime;
	 
	    @UpdateTimestamp
	    private LocalDateTime updateDateTime;

		public Roles() {

		}

		// constructors, getters, and setters
		
//	    public Roles(Long id, String name, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
//			this.id = id;
//			this.name = name;
//			this.createDateTime = createDateTime;
//			this.updateDateTime = updateDateTime;
//		}
//
//		public Roles() {
//
//		}


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
		
		@ManyToMany
	    @JoinTable(
	        name = "role_privilage", // Name of the join table
	        joinColumns = @JoinColumn(name = "role_id"), // Column name in the join table referring to Roles
	        inverseJoinColumns = @JoinColumn(name = "privilage_id") // Column name in the join table referring to Privilages
	    )
	    private Set<Privilages> privilages = new HashSet<>();

}
