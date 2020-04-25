package SpringBoot.CrudProject.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import SpringBoot.CrudProject.DataTransferObject.LoginDto;
import SpringBoot.CrudProject.DataTransferObject.UserDto;
import SpringBoot.CrudProject.Service.ProvinceAndDistrictService;
import SpringBoot.CrudProject.Service.ServiceRepository;

@Controller
public class UserController {

	 
	@Autowired
	private ServiceRepository<UserDto> userService;
	
	@Autowired
	private ProvinceAndDistrictService provinceAndDistrictService;
	
	@RequestMapping("/")
	public String login(Model model) {
		model.addAttribute("nesne",new LoginDto());
		return "login";
	}
	
	@PostMapping("/kontrol")
	public String loginKontrol(@Valid LoginDto loginDto,Model model) {
		Boolean response = userService.kayitBul(loginDto.getMail(),loginDto.getPassword());
		if(response) {
			return "redirect:/kullanici-listele";
		}else {
			return "redirect:/";
		}
	}
	
	
	@RequestMapping("/kullanici-ekle")
	public String kullaniciEkle(Model model) {
		model.addAttribute("iller",provinceAndDistrictService.listToProvince());
		model.addAttribute("user",new UserDto());
		return "kayit";
	}
	
	@PostMapping("/kullanici-ekle")
	public String kullaniciEklePost(@Valid UserDto userDto,Model model) {
		userService.add(userDto);
		return "redirect:/kullanici-listele";
	}
	
	@PostMapping("/kullanici-sil/{id}")
	@ResponseBody
	public void kullaniciSil(@PathVariable("id") long id,Model model){
		userService.sil(id);
	}
	
	@RequestMapping("/kullanici-listele")
	public String kullaniciListele(Model model) {
		model.addAttribute("users",userService.listele());
		return "liste";
	}
}
