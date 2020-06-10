package ru.Abrakov.service;

import ru.Abrakov.domain.Student;

import java.util.List;

/**
 * Project TestWork
 * Created by End on июнь, 2020
 */

public interface StudentService {

    Student getStudent(Long idStudent);

    List<Student> getAllStudents();

    Student addStudent(Student student);

    Boolean deleteStudent(Long idStudent);

    Student updateStudent(Student student);
}
