package augusto.pweb.exercicio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import augusto.pweb.exercicio.domain.Modalidade;
import augusto.pweb.exercicio.repositories.ModalidadeRepository;


@Service
public class ModalidadeService {

	@Autowired
	private ModalidadeRepository rep;

	
	    //BUSCAR POR ID
		public Modalidade find (Integer id) {
			Optional<Modalidade> obj = rep.findById(id);
			return obj.orElse(null);
		}
		
		//INSERIR
		public Modalidade insert (Modalidade obj) {
			obj.setId(null);
			return rep.save(obj);
		}

		//ATUALIZAR
		public Modalidade update (Modalidade obj) {
			find(obj.getId());
			return rep.save(obj);
		}

		//DELETAR
		public void delete (Integer id) {
			find(id);
			rep.deleteById(id);
		}
		
		//LISTAR TODAS
		public List<Modalidade> findAll(){
			return rep.findAll();
		}
		
	
}
