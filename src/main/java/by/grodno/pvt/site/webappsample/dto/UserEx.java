package by.grodno.pvt.site.webappsample.dto;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserEx {

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
