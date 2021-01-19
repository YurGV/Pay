package by.grodno.pvt.site.webappsample.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.dto.UserEx;
import by.grodno.pvt.site.webappsample.service.impl.JPAUserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import by.grodno.pvt.site.webappsample.dto.Avatar;
import by.grodno.pvt.site.webappsample.dto.UserDTO;
import by.grodno.pvt.site.webappsample.service.StorageService;

@Controller
public class UsersController {

	@Autowired
	private JPAUserService userService;
	@Autowired
	private StorageService imgService;
	@Autowired
	private ConversionService convertionService;

	@GetMapping("/users")
	public String getAllUsers(Model model) {

		List<UserDTO> users = userService.getUsers().stream().map(u -> convertionService.convert(u, UserDTO.class))
				.collect(Collectors.toList());
		model.addAttribute("users", users);
		return "userList";
	}


	@GetMapping("/users2")
	public String getAllUsers2(Model model) {

		List<UserDTO> users = userService.getUsers().stream().map(u -> convertionService.convert(u, UserDTO.class))
				.collect(Collectors.toList());
		model.addAttribute("users", users);
		return "userList2";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}



//	//@PostMapping("add")
//
//	//@PostMapping("/users/{id}/img")
//	public String handleFileUpload(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file)
//			throws IOException {
//		imgService.store(id, file);
//		return "redirect:/users";
//	}

	@GetMapping("/users/{id}/img")
	public void getImmage(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
		Avatar file = imgService.getFile(id);

		if (file != null) {
			try (InputStream is = file.getData()) {
				IOUtils.copy(is, response.getOutputStream());
			}
		}
	}

	@GetMapping(value = "/userEx")
	public String userDTOForm(Model model) {
		model.addAttribute("userEx" , new UserDTO());
		return "userEx";
	}

	@PostMapping(value = "/userEx")
	public String userDTODelete(@ModelAttribute UserEx userEx, Model model) {
		model.addAttribute("userEx", userEx);
		return "result";
	}

	@GetMapping(value = "/addCard")
	public String createUserForm(OldUser oldUser, Model model) {
		oldUser = new OldUser();
		model.addAttribute("oldUser", oldUser);
		return "addCard";
		//OldUser oldUser = new OldUser(null, "Visa", 100.01, 2021, "a;slfjghhzbzygh", true, "max","max","ADMIN");
	}

	@PostMapping(value = "/addCard")
	public String createUser(@RequestParam(value="cardName") String cardName,
							 @RequestParam(value="balance") Double balance,
							 @RequestParam(value="valid") Integer valid,
							 @RequestParam(value="avatarFileName") String avatarFileName,
							 @RequestParam(value="lock") Boolean lock,
							 @RequestParam(value="username") String username,
							 @RequestParam(value="password") String password) {

		OldUser user = new OldUser();

		user.setCardName(cardName);
		user.setBalance(balance);
		user.setValid(valid);
	    user.setAvatarFileName(avatarFileName);
		user.setLock(lock);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("USER");

		userService.saveUser(user);
		return "redirect:/users";
	}
}
