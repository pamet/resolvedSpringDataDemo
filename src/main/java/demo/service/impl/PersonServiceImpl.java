package demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import demo.domain.Person;
import demo.model.GridRequest;
import demo.model.GridResponse;
import demo.repository.PersonRepository;
import demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public GridResponse findAll(GridRequest gridRequest) {
		GridResponse gridResponse = new GridResponse();

		// 1. Implement simple paging functionality
		// Pageable pg = new PageRequest(gridRequest.getPage(), gridRequest.getPageSize());
		// Page<Person> page = getPersonRepository().findAll(pg);

		// 2. Implement paging and sorting functionality

		/*
		 * Direction dir = "asc".equalsIgnoreCase(gridRequest.getSortOrder()) ? Direction.ASC : Direction.DESC;
		 * Sort sort = new Sort(dir, gridRequest.getSortColumn());
		 * Pageable pg = new PageRequest(gridRequest.getPage(), gridRequest.getPageSize(), sort);
		 * Page<Person> page = getPersonRepository().findAll(pg);
		 */

		// 3. Implement search functionality

		Direction dir = "asc".equalsIgnoreCase(gridRequest.getSortOrder()) ? Direction.ASC : Direction.DESC;
		Sort sort = new Sort(dir, gridRequest.getSortColumn());
		Pageable pg = new PageRequest(gridRequest.getPage(), gridRequest.getPageSize(), sort);

		/*Page<Person> page = getPersonRepository()
				.findByFirstNameContainingOrLastNameContainingAllIgnoreCase(
						gridRequest.getSearchQuery(),
						gridRequest.getSearchQuery(), pg);*/
		
		Page<Person> page = getPersonRepository().findBySearchQuery("%" + gridRequest.getSearchQuery() + "%", pg);

		gridResponse.setCurrentPage(page.getContent());
		gridResponse.setTotalRows(page.getTotalElements());
		return gridResponse;
	}

	@Override
	public Person findById(Long id) {
		// Implement FETCH BY ID functionality

		return getPersonRepository().findOne(id);
	}

	@Override
	public Person create(Person person) {
		// Implement CREATE PERSON functionality

		return getPersonRepository().save(person);
	}

	@Override
	public void delete(Long id) {
		// Implement DELETE functionality

		getPersonRepository().delete(id);
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

}
