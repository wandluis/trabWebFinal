package pweb.trabfinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pweb.trabfinal.domain.Autor;
import pweb.trabfinal.repositories.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository rep;
	
	public Autor find (Integer id) {
		Optional<Autor> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Autor insert (Autor obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	public Autor update (Autor obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	public List<Autor> findAll(){
		return rep.findAll();
	}
}