package augusto.pweb.exercicio.dtos;

import java.io.Serializable;

import augusto.pweb.exercicio.domain.Competicao;

public class CompeticaoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String descricao;
	private String data;
	
	public CompeticaoDTO (Competicao c) {
		id = c.getId();
		descricao = c.getdescricao();
        data = c.getData();				
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompeticaoDTO other = (CompeticaoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}

