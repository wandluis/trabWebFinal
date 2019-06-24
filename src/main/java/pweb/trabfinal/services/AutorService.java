package pweb.trabfinal.services;

import java.util.List;
import java.util.Optional;

import pweb.trabfinal.domain.Autor;
import pweb.trabfinal.repositories.AutorRepository;

public class AutorService {
	
	private AutorRepository rep;
	
	//BUSCAR POR ID
		public Autor find (Integer id) {
			Optional<Autor> obj = rep.findById(id);
			return obj.orElse(null);
		}
	
	//INSERIR
	public Autor insert (Autor obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	//ATUALIZAR
	public Autor update (Autor obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	//LISTAR TODAS
	public List<Autor> findAll(){
		return rep.findAll();
	}

}
