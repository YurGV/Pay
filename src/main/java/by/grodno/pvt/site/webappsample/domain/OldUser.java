package by.grodno.pvt.site.webappsample.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
