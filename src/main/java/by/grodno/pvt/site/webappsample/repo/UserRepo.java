package by.grodno.pvt.site.webappsample.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<OldUser, Integer> {

	List<OldUser> findByCardName(String cardName);

	Optional<OldUser> findByUsername(String userName);

	@Modifying
	@Query("UPDATE OldUser SET firstName = :uname WHERE id = :id")
	void updateUserName(@Param("uname") String username, @Param("id") Integer userId);
}
