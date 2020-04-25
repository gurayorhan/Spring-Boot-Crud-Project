package SpringBoot.CrudProject.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import SpringBoot.CrudProject.DataTransferObject.DistrictDto;
import SpringBoot.CrudProject.DataTransferObject.ProvinceDto;
import SpringBoot.CrudProject.Service.ProvinceAndDistrictService;

@Controller
public class ProvinceAndDistrictController {
	
	@Autowired
	private ProvinceAndDistrictService provinceAndDistrictService;
	
	
	@RequestMapping("/ilceler/{id}")
	@ResponseBody
	public List<DistrictDto> sehirGetir(@PathVariable("id") int id){
		return provinceAndDistrictService.listToDistrict(id); 
	}

	@RequestMapping("/iller")
	@ResponseBody
	public List<ProvinceDto> getir() {
		return provinceAndDistrictService.listToProvince();
	}
	
}
