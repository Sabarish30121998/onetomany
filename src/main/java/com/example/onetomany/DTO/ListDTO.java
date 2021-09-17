package com.example.onetomany.DTO;

import com.example.onetomany.EntityORModel.Book;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class ListDTO {
    private int studentid;
    private String studentname;
    private String city;
    private List<BookDTO> bookDTO;
}
