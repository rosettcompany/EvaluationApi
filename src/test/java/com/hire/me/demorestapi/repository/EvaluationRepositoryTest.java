package com.hire.me.demorestapi.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.evaluation.demorestapi.model.Evaluation;
import com.evaluation.demorestapi.repository.EvaluationRepository;
import com.hire.me.demorestapi.config.FakeMongo;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;

/**
 * Created by Anand_Rajneesh on 6/14/2017. TODO FIXME - Text based search
 * queries are not working in test mode, Fongo not able to set up text index ?
 */
@RunWith(SpringRunner.class)
@Import(value = { FakeMongo.class })
@EnableMongoRepositories(basePackageClasses = { EvaluationRepository.class })
public class EvaluationRepositoryTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private EvaluationRepository studentRepository;

	@Rule
	public MongoDbRule embeddedMongoDbRule = newMongoDbRule().defaultSpringMongoDb("mockDB");

	@Test
	@UsingDataSet(loadStrategy = LoadStrategyEnum.DELETE_ALL)
	public void noStudentsTest() {
		List<Evaluation> students = studentRepository.findAll();
		assertTrue("Returned book list should be empty", students.isEmpty());
	}
	
	@Test
	@UsingDataSet(loadStrategy = LoadStrategyEnum.DELETE_ALL)
	public void saveStudentsTest() {
		int qt = 10;
		for (int i = 0; i < qt; i++) {
			studentRepository.save(new Evaluation());		
		}
		List<Evaluation> students = studentRepository.findAll();
		assertEquals(qt, students.size());
	}
	
	@Test
	@UsingDataSet(loadStrategy = LoadStrategyEnum.DELETE_ALL)
	public void findById() {
		studentRepository.save(new Evaluation("1"));
		List<Evaluation> students = studentRepository.findAll();
		Optional<Evaluation> st = studentRepository.findById(students.get(0).getId());
		assertTrue(st.isPresent());
		assertEquals("volmar", st.get().getId());
	}

}