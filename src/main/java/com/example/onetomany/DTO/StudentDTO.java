package com.example.onetomany.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class StudentDTO {
    //private int studentid;
    private String studentname;
    private String city;
    private List<BookDTO> bookDTO;
}
