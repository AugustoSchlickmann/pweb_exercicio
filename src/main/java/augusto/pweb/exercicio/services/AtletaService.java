package augusto.pweb.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import augusto.pweb.exercicio.domain.Atleta;
import augusto.pweb.exercicio.domain.Modalidade;
import augusto.pweb.exercicio.repositories.AtletaRepository;
import augusto.pweb.exercicio.repositories.ModalidadeRepository;


@Service
public class AtletaService {

	@Autowired
	private AtletaRepository rep;
	@Autowired
	private ModalidadeRepository modalidadeRepository;
	
	
	
	public List<Atleta> search(String nome, List<Integer> ids) {
		List<Modalidade> Modalidades = modalidadeRepository.findAllById(ids);
		return rep.findDistinctByNomeContainingAndModalidadesIn(nome, Modalidades);
	}
	
	
	public Atleta find (Integer id) {
		Optional<Atleta> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	
	public Atleta insert (Atleta obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	
	public Atleta update (Atleta obj) {
		find(obj.getId());
		return rep.save(obj);
	}


	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	
	public List<Atleta> findAll(){
		return rep.findAll();
	}
	
	
	
}
