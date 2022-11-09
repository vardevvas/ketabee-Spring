package mxd.ketabee.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class BookModel {
    private String name;
    private String barcode;
    private String author;
    private String price;
    private String quantity;
}
