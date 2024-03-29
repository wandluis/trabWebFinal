package pweb.trabfinal.config;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pweb.trabfinal.services.DbService;

@Configuration
public class DevConfig {

	@Autowired
	private DbService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean inicializaBancoDeDados() throws ParseException {
		//System.out.println("Teste");
		if (!strategy.equals("create")) {
			return false;
		}
		
		dbService.inicializaBancoDeDados();
		return true;
	}
}