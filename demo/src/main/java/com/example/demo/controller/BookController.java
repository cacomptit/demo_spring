package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/index")
    public String index(Model model) {
        List<Book> listBook = bookRepository.findAll();
        model.addAttribute("books", listBook);
        return "index";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }
    
    @GetMapping(value = "/edit/{id}")
    public String add(@PathVariable("id") int id, Model model) {
        Book book = bookRepository.findById(id);
        model.addAttribute("book", book);
        return "edit";
    } 

    @PostMapping(value = "/addBook")
    public String addBook(@ModelAttribute Book book, Model model) {
        bookRepository.addBook(book);
        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/index";
    }

    @PostMapping(value = "/editBook")
    public String editBook(@ModelAttribute Book book, Model model) {
        bookRepository.editBook(book);
        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        bookRepository.deleteBook(id);
        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/index";
    }
}