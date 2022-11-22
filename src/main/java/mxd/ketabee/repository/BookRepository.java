package mxd.ketabee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mxd.ketabee.model.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Long> {

}
