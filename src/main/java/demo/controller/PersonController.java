package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.domain.Person;
import demo.model.GridRequest;
import demo.model.GridResponse;
import demo.service.PersonService;

@Controller
@RequestMapping(value = "/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/")
	public String getPersonsPage() {
		return "persons";
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	@ResponseBody
	public GridResponse findAll(@RequestBody GridRequest gridRequest) {
		return getPersonService().findAll(gridRequest);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Person findPersonById(@PathVariable Long id) {
		return getPersonService().findById(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Person create(@RequestBody Person person) {
		return getPersonService().create(person);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public void deletePerson(@RequestBody Long id) {
		if (id != null) {
			getPersonService().delete(id);
		}
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
