package nl.androidappfactory.Spring5Webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import nl.androidappfactory.Spring5Webapp.model.Author;
import nl.androidappfactory.Spring5Webapp.model.Book;
import nl.androidappfactory.Spring5Webapp.model.Publisher;
import nl.androidappfactory.Spring5Webapp.repositories.AuthorRepository;
import nl.androidappfactory.Spring5Webapp.repositories.BookRepository;
import nl.androidappfactory.Spring5Webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

		initData();
	}

	private void initData() {

		Publisher harper = new Publisher("Harper Collins", "Street 1");
		publisherRepository.save(harper);

		Publisher wbrx = new Publisher("WBRX", "Lane 2");
		publisherRepository.save(wbrx);

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain driven design", "1234");
		eric.getBooks().add(ddd);
		ddd.setPublisher(harper);

		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("JEE development without EJB", "1235");
		rod.getBooks().add(noEJB);
		noEJB.setPublisher(wbrx);

		authorRepository.save(rod);
		bookRepository.save(noEJB);

		Author hans = new Author("Hans", "Meurs, van");
		Book scrum = new Book("Scrum for dummies", "1236");
		hans.getBooks().add(scrum);
		scrum.setPublisher(wbrx);

		authorRepository.save(hans);
		bookRepository.save(scrum);
	}
}
