package com.zhang.pojo;

import lombok.Data;

import java.util.List;
import java.util.Objects;
@Data
public class Teacher {
    private int id;
    private int name;
    public List<Student> students;

}
