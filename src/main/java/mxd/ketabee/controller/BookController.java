package mxd.ketabee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mxd.ketabee.model.BookModel;
import mxd.ketabee.service.BookService;

public class BookController {
    @Autowired
    BookService serviceInstance;

    @PostMapping("/booklist")
    ResponseEntity<?> addBook(@RequestBody BookModel book) {
        return serviceInstance.addBook(book);
    }

    @GetMapping("/booklist")
    ResponseEntity<?> getBookList() {
        return serviceInstance.getBookList();
    }

    @GetMapping("/booklist/{Id}")
    ResponseEntity<?> getBook(@PathVariable Long Id) {
        return serviceInstance.getBook(Id);
    }
}
