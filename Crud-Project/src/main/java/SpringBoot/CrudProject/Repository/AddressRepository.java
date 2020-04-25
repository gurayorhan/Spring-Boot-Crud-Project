package SpringBoot.CrudProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.CrudProject.Model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

    /*
    @Transactional
    @Modifying
    @Query("delete from Address b where b.provinceId=:il")
    void deleteAllProvinceAddresses(@Param("il") long id);
    */

}
