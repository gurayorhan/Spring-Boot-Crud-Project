package SpringBoot.CrudProject.Service;

import java.util.List;

public interface ServiceRepository<T>{

	List<T> listele();
	
	void sil(long id);
	
	T update(T entity);
	
	T getir(long id);
	
	T add(T entity);

	Boolean kayitBul(String mail, String password);
	
}
