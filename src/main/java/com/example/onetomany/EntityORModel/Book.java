package com.example.onetomany.EntityORModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
@Data
@Setter
@Getter
public class Book {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid")
    private int bookid;

    @Column(name = "bookname")
    private String bookname;

    @Column(name = "authorname")
    private String authorName;

    @Column(name = "pages")
    private int pages;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stu_id")
    private Student student;
}
