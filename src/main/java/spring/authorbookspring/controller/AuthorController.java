package spring.authorbookspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.authorbookspring.entity.Author;
import spring.authorbookspring.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    @GetMapping
    public String authorPage(ModelMap modelMap) {
        List<Author> authors = authorRepository.findAll();
        modelMap.put("authors", authors);
        return "/author/authors";
    }

    @GetMapping("/add")
    public String addAuthor() {
        return "/author/addAuthor";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam("id") int id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }

    @GetMapping("/editAuthor")
    public String editAuthorPage(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            modelMap.put("author", author);
            return "/author/editAuthor";
        }
        return "redirect:/authors";
    }

    @PostMapping("/editAuthor")
    public String editAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }
}
