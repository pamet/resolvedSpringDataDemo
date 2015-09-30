package demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import demo.domain.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> { // extends CrudRepository<Person, Long> {
	Page<Person> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(String firstName, String lastName, Pageable pageable);
	
	@Query("SELECT p FROM Person p WHERE LOWER(p.firstName) LIKE LOWER(:searchQuery) OR LOWER(p.lastName) LIKE LOWER(:searchQuery)")
	Page<Person> findBySearchQuery(@Param("searchQuery") String searchQuery, Pageable pageable);
}
