package  com.robinfood.encuestas.service;

import java.util.List;
import java.util.Optional;

public interface GenericService <T,ID>{
	
	 	public List<T> findAll();
	 	
	 	public Optional<T> findById(ID id);

	    public T save(T entity) throws Exception;

	    public void validate(T entity) throws Exception;

}
