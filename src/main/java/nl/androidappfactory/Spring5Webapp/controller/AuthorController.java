package nl.androidappfactory.Spring5Webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nl.androidappfactory.Spring5Webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	@Autowired
	AuthorRepository authorRepository;

	// public AuthorController(AuthorRepository authorRepository) {
	// this.authorRepository = authorRepository;
	// }

	@GetMapping("/authors")
	public String getAuthors(Model model) {

		model.addAttribute("authors", authorRepository.findAll());

		return "authors";
	}
}
