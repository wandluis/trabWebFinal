package pweb.trabfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pweb.trabfinal.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
}
