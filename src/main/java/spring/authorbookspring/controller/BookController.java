package spring.authorbookspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.authorbookspring.entity.Author;
import spring.authorbookspring.entity.Book;
import spring.authorbookspring.service.AuthorService;
import spring.authorbookspring.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping
    public String bookPage(ModelMap modelMap) {
        List<Book> books = bookService.findAll();
        modelMap.put("books", books);
        return "book/books";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/editBook")
    public String editBookPage(@RequestParam("id") int id, ModelMap modelMap) {
        Book book = bookService.findById(id);
        if (book != null) {
            modelMap.put("book", book);
            return "/book/editBook";
        }
        return "redirect:/books";
    }
//    @PostMapping("/editBook")
//    public String editBook(@ModelAttribute Book book) {
//        bookService.save(book);
//        return "redirect:/books";
//    }

    @GetMapping("/add")
    public String addBookPage(ModelMap modelMap) {
        List<Author> authors = authorService.findAll();
        modelMap.put("authors", authors);
        return "book/addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, @RequestParam("image") MultipartFile multipartFile) {
        bookService.save(book, multipartFile);
        return "redirect:/books";
    }
}
