package mxd.ketabee.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import mxd.ketabee.model.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Long> {

}
