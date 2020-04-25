package SpringBoot.CrudProject.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "iller")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "il_no")
	private int id;
	@Column(length = 100,name = "isim",nullable = false)
	private String name;
	@OneToMany(mappedBy = "province")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<District> districts;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	
	
	
}
