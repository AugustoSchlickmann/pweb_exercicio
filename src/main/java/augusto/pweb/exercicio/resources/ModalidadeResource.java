package augusto.pweb.exercicio.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import augusto.pweb.exercicio.domain.Modalidade;
import augusto.pweb.exercicio.dtos.ModalidadeDTO;
import augusto.pweb.exercicio.services.ModalidadeService;


@RestController 
@RequestMapping(value="/modalidades") 
public class ModalidadeResource {



	@Autowired
	private ModalidadeService service; 
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Modalidade> find(@PathVariable Integer id){
		Modalidade obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Modalidade obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Modalidade obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();  
	}
	

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ModalidadeDTO>> findAll() {
		List<Modalidade> lista = service.findAll();
		List<ModalidadeDTO> listaDTO = new ArrayList<ModalidadeDTO>();
		for (Modalidade m : lista) {
			listaDTO.add(new ModalidadeDTO(m));
		}
		return ResponseEntity.ok().body(listaDTO);
	}
}
