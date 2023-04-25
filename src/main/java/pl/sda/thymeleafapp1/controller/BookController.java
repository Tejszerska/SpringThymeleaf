package pl.sda.thymeleafapp1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.thymeleafapp1.model.Book;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class BookController {
    private final List<Book> books;

    public BookController() {
        Book book = new Book("Dzieci z Bulerbyn", "Astrid Lindgren");
        Book book1 = new Book("Bracia Lwie Serce", "Astrid Lindgren");
        Book book2 = new Book("Harry Potter i Kamień Filizoficzny", "J.K. Rowling");
        Book book3 = new Book("Harry Potter i Komnata Tajemnic", "J.K. Rowling");

        this.books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book);
    }
    @PostMapping("/add-book")
    public String addBook(@Valid @ModelAttribute("newBook") Book book){

        System.out.println(book);
        books.add(book);
        return "redirect:/books";
    }
    @GetMapping("/books")
    public String book(Model model){
        model.addAttribute("books", books);
        model.addAttribute("newBook", new Book());
        return "showBooks";
    }
}
