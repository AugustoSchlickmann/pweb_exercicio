package augusto.pweb.exercicio.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import augusto.pweb.exercicio.domain.Atleta;
import augusto.pweb.exercicio.domain.Competicao;
import augusto.pweb.exercicio.domain.Modalidade;
import augusto.pweb.exercicio.repositories.AtletaRepository;
import augusto.pweb.exercicio.repositories.CompeticaoRepository;
import augusto.pweb.exercicio.repositories.ModalidadeRepository;

@Service
public class DbService {

	
	@Autowired
	private AtletaRepository aRep;
	
	@Autowired
	private ModalidadeRepository mRep;
	
	@Autowired
	private CompeticaoRepository cRep;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		
		Atleta a1 = new Atleta(null,"Atleta 1");
		Atleta a2 = new Atleta(null,"Atleta 2");
		Atleta a3 = new Atleta(null,"Atleta 3");
		Atleta a4 = new Atleta(null,"Atleta 4");
		
		Modalidade m1 = new Modalidade(null,"Natação");
		Modalidade m2 = new Modalidade(null,"Hipismo");
		Modalidade m3 = new Modalidade(null,"Halterofilismo");
		Modalidade m4 = new Modalidade(null,"Ginástica");
		
		Competicao c1 = new Competicao(null,"Competição de Natação","07/04/2019");
		Competicao c2 = new Competicao(null,"Competição de Hipismo","21/08/2019");
		Competicao c3 = new Competicao(null,"Competição de Halterofilismo","13/04/2019");
		Competicao c4 = new Competicao(null,"Competição de Gnástica","20/05/2019");
		
		a1.getModalidades().addAll(Arrays.asList(m1));
		a2.getModalidades().addAll(Arrays.asList(m1,m2));
		a3.getModalidades().addAll(Arrays.asList(m1,m2,m3));
		a4.getModalidades().addAll(Arrays.asList(m1,m2,m3,m4));
		
		m1.getAtletas().addAll(Arrays.asList(a1,a2,a3,a4));
		m2.getAtletas().addAll(Arrays.asList(a2,a3,a4));
		m3.getAtletas().addAll(Arrays.asList(a3,a4));
		m4.getAtletas().addAll(Arrays.asList(a4));
		
		aRep.saveAll(Arrays.asList(a1,a2,a3,a4));
		mRep.saveAll(Arrays.asList(m1,m2,m3,m4));
		cRep.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		
	}
}
