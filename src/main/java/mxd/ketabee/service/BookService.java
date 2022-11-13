package mxd.ketabee.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mxd.ketabee.model.BookModel;
import mxd.ketabee.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository repoInstance;

    public ResponseEntity<?> getBookList() {
        List<BookModel> bookList = new ArrayList<>();
        repoInstance.findAll().forEach(bookList::add);
        return ResponseEntity.ok().body(bookList);
    }

    public ResponseEntity<?> getBook(Long Id) {
        return ResponseEntity.ok().body(repoInstance.findById(Id));
    }

    public ResponseEntity<?> addBook(BookModel book) {
        return ResponseEntity.ok().body(repoInstance.save(book));
    }
}
