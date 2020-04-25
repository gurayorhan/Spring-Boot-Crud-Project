package SpringBoot.CrudProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBoot.CrudProject.Model.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

}
