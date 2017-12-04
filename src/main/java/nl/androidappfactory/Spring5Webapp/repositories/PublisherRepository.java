package nl.androidappfactory.Spring5Webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import nl.androidappfactory.Spring5Webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
