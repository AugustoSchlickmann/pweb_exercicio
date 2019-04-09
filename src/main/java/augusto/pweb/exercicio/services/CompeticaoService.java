package augusto.pweb.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import augusto.pweb.exercicio.domain.Competicao;
import augusto.pweb.exercicio.repositories.CompeticaoRepository;

@Service
public class CompeticaoService {

	@Autowired
	private CompeticaoRepository rep;
	
	
	public Competicao find (Integer id) {
		Optional<Competicao> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	
	public Competicao insert (Competicao obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	
	public Competicao update (Competicao obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	
	public List<Competicao> findAll(){
		return rep.findAll();
	}
}

