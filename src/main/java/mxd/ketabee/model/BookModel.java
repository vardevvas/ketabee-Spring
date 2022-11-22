package mxd.ketabee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Books")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // @Column(name = "Name")
    private String name;
    // @Column(name = "QR Code")
    private String barcode;
    // @Column(name = "Author")
    private String author;
    // @Column(name = "Price")
    private String price;
    // @Column(name = "Quantity")
    private String quantity;
}
