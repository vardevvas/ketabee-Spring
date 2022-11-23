package mxd.ketabee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mxd.ketabee.model.BookModel;
import mxd.ketabee.service.BookService;

@RestController
public class BookController {

    @Autowired
    BookService serviceInstance;

    @PostMapping("/book")
    ResponseEntity<BookModel> addBook(@RequestBody BookModel book) {
        return new ResponseEntity<>(serviceInstance.addBook(book), HttpStatus.OK);
    }

    @GetMapping("/books")
    ResponseEntity<List<BookModel>> getBookList() {
        return new ResponseEntity<>(serviceInstance.getBookList(), HttpStatus.OK);
    }

    @GetMapping("/books/{Id}")
    ResponseEntity<?> getBook(@PathVariable Long Id) {
        return new ResponseEntity<>(serviceInstance.getBook(Id), HttpStatus.OK);
    }

}