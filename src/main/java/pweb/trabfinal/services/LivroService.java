package pweb.trabfinal.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pweb.trabfinal.domain.Autor;
import pweb.trabfinal.domain.Livro;
import pweb.trabfinal.repositories.AutorRepository;
import pweb.trabfinal.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository rep;
	
	@Autowired
	private AutorRepository autRep;
	
	public Livro find(Integer id) {
		Optional<Livro> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Livro insert (Livro obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	public List<Livro> search(String titulo, List<Integer> ids) {
		List<Autor> autores = autRep.findAllById(ids);
		return rep.findDistinctByTituloContainingAndAutoresIn(titulo, autores);
	}
	
	public List<Livro> findAll(){
		return rep.findAll();
	}

}
