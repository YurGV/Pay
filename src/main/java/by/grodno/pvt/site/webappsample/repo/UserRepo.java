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
	@Query("UPDATE OldUser c SET c.cardName = :Name WHERE c.id = :id")
	void updateUserName(@Param("Name") String cardName, @Param("id") Integer userId);

	@Modifying
	@Query("UPDATE OldUser c SET c.lock = :lock WHERE c.id = :id")
	void updateStatusCard(@Param("lock") Boolean lock, @Param("id") Integer userId);

//	@Modifying
//	@Query("UPDATE OldUser c SET c.balance = :balance WHERE c.id = :id")
//	void updateBalancePlus(@Param("balance") Double balance, @Param("id") Integer userId);

	@Modifying
	@Query("UPDATE OldUser c SET c.balance = :balance + balance WHERE c.id = :id")
	void updateBalancePlus(@Param("balance") Double balance, @Param("id") Integer userId);



}
