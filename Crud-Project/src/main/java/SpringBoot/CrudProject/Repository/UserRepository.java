package SpringBoot.CrudProject.Repository;

import SpringBoot.CrudProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByMailAndPassword(String mail,String Password);

}
  