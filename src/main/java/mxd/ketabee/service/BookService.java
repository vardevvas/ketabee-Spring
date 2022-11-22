package mxd.ketabee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mxd.ketabee.model.BookModel;
import mxd.ketabee.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository repoInstance;

    public List<BookModel> getBookList() {
        return repoInstance.findAll();
    }

    public Optional<BookModel> getBook(Long Id) {
        return repoInstance.findById(Id);
    }

    public BookModel addBook(BookModel book) {
        return repoInstance.save(book);
    }
}
