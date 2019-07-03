package pweb.trabfinal.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pweb.trabfinal.domain.Autor;
import pweb.trabfinal.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
	
	List<Livro> findDistinctByTituloContainingAndAutoresIn(
			String titulo,
			List<Autor> autores
	);
	
	Livro save(Autor obj);
}
