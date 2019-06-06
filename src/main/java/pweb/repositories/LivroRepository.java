package pweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pweb.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
}
