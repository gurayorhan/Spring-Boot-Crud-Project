package SpringBoot.CrudProject.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adres")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 200,name = "acik_adres",nullable = false)
	private String openAddress;
	@Column(length = 100,name = "aciklama",nullable = false)
	private String statement;
	@Column(name = "il_id",nullable = false)
	private long provinceId;
	@Column(name = "ilce_id",nullable = false)
	private int districtId;
	@Column(name = "zip_code",nullable = false)
	private int zipCode;
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOpenAddress() {
		return openAddress;
	}
	public void setOpenAddress(String openAddress) {
		this.openAddress = openAddress;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
}
