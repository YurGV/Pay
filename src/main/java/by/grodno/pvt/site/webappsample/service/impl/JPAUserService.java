package by.grodno.pvt.site.webappsample.service.impl;

import java.util.List;
import java.util.Optional;

import by.grodno.pvt.site.webappsample.dto.UserDTO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.repo.UserRepo;
import by.grodno.pvt.site.webappsample.service.UserService;

@Service
@Transactional
public class JPAUserService implements UserService, InitializingBean {

	@Autowired
	private UserRepo repo;

	@Override
	public void addUser(List<OldUser> users) {
		repo.saveAll(users);
	}

	@Override
	public List<OldUser> getUsers() {
		return repo.findAll();
	}

	@Override
	public void deleteUser(Integer number) {
		repo.deleteById(number);
	}

	@Override
	public List<OldUser> findByExample(OldUser userSample) {
		Example<OldUser> exp = Example.of(userSample,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
		return repo.findAll(exp);
	}

	@Override
	public Page<OldUser> getPage(Integer pageNum, Integer pageSize) {
		return repo.findAll(PageRequest.of(pageNum, pageSize, Sort.Direction.ASC, "firstName"));
	}

	@Override
	public List<OldUser> findByFName(String cname) {
		return repo.findByCardName(cname);
	}

	@Override
	public Optional<OldUser> findByUserName(String userName) {
		return repo.findByUsername(userName);
	}

	@Override
	public void edit(UserDTO userDTO) {
		return;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		OldUser oldUser = new OldUser(null, "Visa", 100.01, 2021, "a;slfjghhzbzygh", true, "max","max","ADMIN");
		OldUser oldUser2 = new OldUser(null, "Maestro", 550.10, 2022, null, true,"q","q","USER");
		OldUser oldUser3 = new OldUser(null, "MastreCard", 200.36, 2023, null, true,"w","w","USER");
		OldUser oldUser4 = new OldUser(null, "BelCard", 5600.6, 2025, null, false,"e","e","USER");


		repo.save(oldUser);
		repo.save(oldUser2);
		repo.save(oldUser3);
		repo.save(oldUser4);

	}

	@Override
	public OldUser getUser(Integer id) {
		return repo.getOne(id);
	}

	@Override
	public void saveUser(OldUser user) {
		repo.save(user);
	}

	public void saveUserTest(OldUser user) {
		repo.save(user);
	}

	public void updateUserName(String cardName, Integer id) {
		repo.updateUserName(cardName, id);
	}
	public void updateStatusCard(boolean lock, Integer id) {
		repo.updateStatusCard(lock, id);
	}
	public void updateBalancePlus(Double balance, Integer id) {
		repo.updateBalancePlus(balance, id);
	}


	@Override
	public OldUser getUser(Boolean lock) {
		return repo.getOne(lock.compareTo(true));
	}


}
