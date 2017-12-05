package nl.androidappfactory.Spring5Webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.androidappfactory.Spring5Webapp.repositories.BookRepository;

/**
 * 
 * @author Hans van Meurs
 *
 */
@Controller
public class BookController {

	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {

		model.addAttribute("books", bookRepository.findAll());

		return "books";
	}
}