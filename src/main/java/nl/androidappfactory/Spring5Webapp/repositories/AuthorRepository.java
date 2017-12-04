package nl.androidappfactory.Spring5Webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import nl.androidappfactory.Spring5Webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
