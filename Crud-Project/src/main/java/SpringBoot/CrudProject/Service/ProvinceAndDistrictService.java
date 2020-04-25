package SpringBoot.CrudProject.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBoot.CrudProject.DataTransferObject.DistrictDto;
import SpringBoot.CrudProject.DataTransferObject.ProvinceDto;
import SpringBoot.CrudProject.Model.District;
import SpringBoot.CrudProject.Model.Province;
import SpringBoot.CrudProject.Repository.DistrictRepository;
import SpringBoot.CrudProject.Repository.ProvinceRepository;

@Service
public class ProvinceAndDistrictService {  

	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<ProvinceDto> listToProvince(){
		
		List<Province> x = provinceRepository.findAll();
		List<ProvinceDto> dto = new ArrayList<ProvinceDto>();
		
		for(int i = 0; i<x.size();i++) {
			
			ProvinceDto t;
			t = mapper.map(x.get(i), ProvinceDto.class);
			dto.add(t);
		}
		return dto;
	}
	
	
	public List<DistrictDto> listToDistrict(int id){
		
		List<District> x = districtRepository.findAll();
		List<DistrictDto> dto = new ArrayList<DistrictDto>();
		
		for(int i = 0; i<x.size();i++) {
			if(id == x.get(i).getProvince().getId()) {
				DistrictDto t;
				t = mapper.map(x.get(i), DistrictDto.class);
				dto.add(t);
			}
		}
		
		return dto;
	}
	
}
