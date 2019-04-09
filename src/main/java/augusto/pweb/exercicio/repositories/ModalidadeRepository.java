package augusto.pweb.exercicio.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import augusto.pweb.exercicio.domain.Modalidade;


public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer>{
	
	
}
