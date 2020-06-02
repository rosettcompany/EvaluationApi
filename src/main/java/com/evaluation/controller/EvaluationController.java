package com.evaluation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.demorestapi.model.Busqueda;
import com.evaluation.demorestapi.model.Evaluation;
import com.evaluation.demorestapi.repository.EvaluationRepository;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/api")
public class EvaluationController {
		
	    @Autowired
	    EvaluationRepository evaluationRepository;
	    
	    @RequestMapping(method=RequestMethod.GET)
	    public Iterable<Evaluation> student() {
	        return evaluationRepository.findAll();
	    }

	    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Evaluation create(@RequestBody Evaluation student) {
	    	return evaluationRepository.save(student);
	    }

	    @RequestMapping(method=RequestMethod.GET, value = "/{id}")
	    public Optional<Evaluation> read(@PathVariable String id) {
	        return evaluationRepository.findById(id);
	    }
	    
	    @PostMapping("/consult")
	    public void consult(@RequestBody Busqueda busqueda) {
	    	Busqueda st = new Busqueda();
	    	st.setFechaInicio(busqueda.getFechaInicio());
	    	st.setFechaFin(busqueda.getFechaFin());
	    	//return evaluationRepository.findById(id); 
	    	
	    }
	    
	    /*
	    @PostMapping("/modify")
	    public void modify(@RequestBody Evaluation student) {
	    	Evaluation st = new Evaluation();
	    	st.setId(student.getId());
	    	evaluationRepository.delete(st); 
	    	
	    	Query query = new Query();
	    	query.addCriteria(Criteria.where("name").is("Markus"));
	    	Update update = new Update();
	    	update.set("name", "Nick");
	    	Evaluation user = mongoTemplate.findAndModify(query, update, Evaluation.class);
	    }
	    */
}
