package SpringBoot.CrudProject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringBoot.CrudProject.DataTransferObject.UserDto;
import SpringBoot.CrudProject.Model.Address;
import SpringBoot.CrudProject.Model.User;
import SpringBoot.CrudProject.Repository.AddressRepository;
import SpringBoot.CrudProject.Repository.UserRepository;

@Service
public class UserService implements ServiceRepository<UserDto>{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	public Boolean kayitBul(String mail,String password) {
		User x = userRepository.findByMailAndPassword(mail,password);
		if(x != null) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public UserDto add(UserDto userDto) {
		User user = mapper.map(userDto,User.class);
		user = userRepository.save(user);
		for(int i = 0;i<userDto.getAddresses().size();i++) {
			if(userDto.getAddresses().get(i).getOpenAddress() != "") {
				userDto.getAddresses().get(i).setUser(user); 
				Address address = mapper.map(userDto.getAddresses().get(i),Address.class);
				addressRepository.save(address);
			}
		}
		return mapper.map(user,UserDto.class);
	}

	@Override
	public List<UserDto> listele() {
		List<User> users = userRepository.findAll();
		List<UserDto> usersDto = new ArrayList<UserDto>();
		
		for (User user : users) {
			usersDto.add(mapper.map(user,UserDto.class));
		}
		
		return usersDto;
	}

	@Override
	public void sil(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDto update(UserDto entity) {
		User user = mapper.map(entity,User.class);
		user = userRepository.save(user);
		return mapper.map(user,UserDto.class);
	}

	@Override
	public UserDto getir(long id) {
		Optional<User> user = userRepository.findById(id);
		return mapper.map(user,UserDto.class);
	}
}
