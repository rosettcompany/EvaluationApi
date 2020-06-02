package com.evaluation.demorestapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluation.demorestapi.model.Evaluation;

public interface EvaluationRepository extends MongoRepository<Evaluation, String> {


}
