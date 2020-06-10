package ru.Abrakov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Abrakov.domain.Student;
import ru.Abrakov.exception.StudentExistException;
import ru.Abrakov.exception.StudentNotFoundException;
import ru.Abrakov.exception.StudentsNotFoundException;
import ru.Abrakov.repository.StudentRepository;
import ru.Abrakov.service.StudentService;

import java.util.List;

/**
 * Project TestWork
 * Created by End on июнь, 2020
 */

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public Student getStudent(Long idStudent) {
        return studentRepository.findById(idStudent).orElseThrow(() ->
                new StudentNotFoundException("Студент не найден."));
    }

    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll(Sort.by("name"));
        if (students.isEmpty()) {
            throw new StudentsNotFoundException("Список пуст.");
        } else {
            return students;
        }
    }

    public Student addStudent(Student student) {
        if (studentRepository.existsByPassport(student.getPassport())) {
            throw new StudentExistException("Студент с таким паспортом уже существует.");
        } else {
            return studentRepository.save(student);
        }
    }

    public Boolean deleteStudent(Long idStudent) {
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new StudentNotFoundException("Студент не найден."));
        studentRepository.delete(student);
        return true;
    }

    public Student updateStudent(Student student) {
        Student oldStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new StudentNotFoundException("Студент не найден."));
        if (studentRepository.existsByPassport(student.getPassport())) {
            throw new StudentExistException("Студент с таким паспортом уже существует.");
        } else {
            if (student.getName() != null) {
                oldStudent.setName(student.getName());
            }
            if (student.getPassport() != null) {

                oldStudent.setPassport(student.getPassport());
            }
            return studentRepository.saveAndFlush(oldStudent);
        }
    }
}
