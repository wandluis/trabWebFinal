package pweb.trabfinal.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pweb.trabfinal.domain.Autor;
import pweb.trabfinal.domain.enums.Genero;
import pweb.trabfinal.repositories.AutorRepository;

@Service
public class DbService {
	
	@Autowired
	private AutorRepository autorRep;

	public void inicializaBancoDeDados() throws ParseException {
		
		Autor aut1 = new Autor(null, "Machado de Assis", 40, Genero.MASCULINO);
		
		autorRep.saveAll(Arrays.asList(aut1));
	
	}
}
