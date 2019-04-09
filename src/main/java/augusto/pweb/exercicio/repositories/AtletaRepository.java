package augusto.pweb.exercicio.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import augusto.pweb.exercicio.domain.Atleta;
import augusto.pweb.exercicio.domain.Modalidade;

public interface AtletaRepository extends JpaRepository<Atleta, Integer>{

	List<Atleta> findDistinctByNomeContainingAndModalidadesIn(String nome,List<Modalidade> modalidades);
}
