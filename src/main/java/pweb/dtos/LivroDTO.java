package pweb.dtos;

import java.io.Serializable;
import pweb.domain.Livro;

public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private Double preco;

	public LivroDTO() {

	}

	public LivroDTO(Livro obj) {
		id = obj.getId();
		titulo = obj.getTitulo();
		preco = obj.getPreco();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
