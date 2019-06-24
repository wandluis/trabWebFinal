package pweb.trabfinal.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import pweb.trabfinal.domain.Livro;
import pweb.trabfinal.repositories.LivroRepository;

public class LivroService {
	
	@Autowired
	private LivroRepository rep;
	
	public Livro find(Integer id) {
		Optional<Livro> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Livro insert (Livro obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	
	

}
