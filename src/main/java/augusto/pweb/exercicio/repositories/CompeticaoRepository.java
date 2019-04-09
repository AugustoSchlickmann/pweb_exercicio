package augusto.pweb.exercicio.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import augusto.pweb.exercicio.domain.Competicao;


public interface CompeticaoRepository extends JpaRepository<Competicao, Integer>{

}
