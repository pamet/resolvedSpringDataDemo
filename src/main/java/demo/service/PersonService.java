package demo.service;

import demo.domain.Person;
import demo.model.GridRequest;
import demo.model.GridResponse;

public interface PersonService {

	GridResponse findAll(GridRequest gridRequest);
	
	Person findById(Long id);

	Person create(Person person);

	void delete(Long id);

}
