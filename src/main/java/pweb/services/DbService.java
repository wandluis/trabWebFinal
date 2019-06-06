package pweb.services;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pweb.repositories.LivroRepository;

@Service
public class DbService {
	
	@SuppressWarnings("unused")
	@Autowired
	private LivroRepository livroRep;

	public void inicializaBancoDeDados() throws ParseException {
	
	}
}
