package ru.Abrakov.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Abrakov.domain.Student;
import ru.Abrakov.service.StudentService;

import java.util.List;

/**
 * Project TestWork
 * Created by End on июнь, 2020
 */

@RestController
@Tag(name = "Студенты", description = "Api для студентов")
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{idStudent}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = @Content(schema = @Schema(implementation = Student.class))),
            @ApiResponse(responseCode = "404", description = "Студент не найден")})
    @Operation(summary = "Получение студента", description = "-", tags = {"student"})
    public Student getStudent(@PathVariable Long idStudent) {
        return studentService.getStudent(idStudent);
    }

    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = @Content(schema = @Schema(implementation = Student.class),mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Список пуст")})
    @Operation(summary = "Получение списка всех студентов", description = "-", tags = {"student"})
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = @Content(schema = @Schema(implementation = Student.class),mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Студент с таким паспортом уже существует")})
    @Operation(summary = "Добавление студента", description = "-", tags = {"student"})
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{idStudent}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = @Content(schema = @Schema(implementation = Student.class),mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Студент не найден")})
    @Operation(summary = "Удаление студента", description = "-", tags = {"student"})
    public Boolean deleteStudent(@PathVariable Long idStudent) {
        return studentService.deleteStudent(idStudent);
    }

    @PutMapping("/updateStudent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = @Content(schema = @Schema(implementation = Student.class),mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Студент не найден")})
    @Operation(summary = "Обновление информации о студенте", description = "-", tags = {"student"})
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

}
