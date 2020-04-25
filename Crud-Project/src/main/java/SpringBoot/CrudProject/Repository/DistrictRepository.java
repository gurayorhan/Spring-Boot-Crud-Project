package SpringBoot.CrudProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBoot.CrudProject.Model.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

}
