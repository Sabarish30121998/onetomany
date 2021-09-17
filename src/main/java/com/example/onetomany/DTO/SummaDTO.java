package com.example.onetomany.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class SummaDTO {
    private int studendid;
    private String studentname;
    private String city;
    private BookDTO bookDTO;
}
