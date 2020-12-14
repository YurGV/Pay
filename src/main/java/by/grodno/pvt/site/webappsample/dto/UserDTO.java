package by.grodno.pvt.site.webappsample.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

	private Integer id;
	private String cardName;
	private Double balance;
	private Integer valid;
	private Boolean lock;

}
