package by.grodno.pvt.site.webappsample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "new_old_user_table")
public class OldUser {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String cardName;
	private Double balance;
	private Integer valid;

	private String avatarFileName;

	@Column(name = "isLock")
	private Boolean lock;

	private String username;
	private String password;
	private String role;

	public Boolean getLock() {
		return lock;
	}

	public void setLock(Boolean lock) {
		this.lock = lock;
	}

}
