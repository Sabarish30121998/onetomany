package com.example.onetomany.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class BookDTO {
    private int bookid;
    private String bookname;
    private String authorname;
    private int pages;
}
