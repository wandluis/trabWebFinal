package pweb.trabfinal.resources;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pweb.trabfinal.domain.Livro;
import pweb.trabfinal.dtos.LivroDTO;
import pweb.trabfinal.resources.utils.URL;
import pweb.trabfinal.services.LivroService;

@RestController
@RequestMapping(value="/livros")
public class LivroResource {
	
	@Autowired
	private LivroService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> find(@PathVariable Integer id) {
		Livro obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LivroDTO>> find(
			@RequestParam(value = "titulo", defaultValue = "") String titulo,
			@RequestParam(value = "autores", defaultValue = "") String autores) {

		String tituloDecoded = URL.decodeParam(titulo);
		List<Integer> ids = URL.decodeIntList(autores);
		List<Livro> list = service.search(tituloDecoded, ids);
		List<LivroDTO> listDto = new ArrayList<LivroDTO>();
		for (Livro p : list) {
			listDto.add(new LivroDTO(p));
		}
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Livro obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/all",method=RequestMethod.GET)
	public ResponseEntity<List<LivroDTO>> findAll() {
		List<Livro> lista = service.findAll();
		List<LivroDTO> listaDTO = new ArrayList<LivroDTO>();
		for (Livro c : lista) {
			listaDTO.add(new LivroDTO(c));
		}
		return ResponseEntity.ok().body(listaDTO);
	}
}
