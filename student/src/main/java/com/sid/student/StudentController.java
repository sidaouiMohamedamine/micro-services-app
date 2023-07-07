package com.sid.student;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }
    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }
    @GetMapping("/school/school-id")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable("school-id")Long schoolId){
        return ResponseEntity.ok(studentService.findAllStudentsBySchools(schoolId));
    }

}
