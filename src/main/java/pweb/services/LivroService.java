package pweb.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import pweb.domain.Livro;
import pweb.repositories.LivroRepository;

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
