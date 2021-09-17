package com.example.onetomany.EntityORModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Library;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentid")
    private  int studentid;

    @Column(name = "studentname")
    private String studentname;

    @Column(name = "city")
    private  String city;

/*    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "listofinter")
    private ArrayList<Integer> arrayList;*/


/*    @OneToMany(cascade = CascadeType.ALL,mappedBy = "studentid")
    @JoinColumn(name = "bookhave",referencedColumnName = "studentid")
    private List<Book> sabari = new ArrayList<>();*/


}
