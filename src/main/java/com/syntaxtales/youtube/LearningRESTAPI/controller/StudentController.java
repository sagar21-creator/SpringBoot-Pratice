package com.syntaxtales.youtube.LearningRESTAPI.controller;


import com.syntaxtales.youtube.LearningRESTAPI.dto.AddStudentDto;
import com.syntaxtales.youtube.LearningRESTAPI.dto.StudentDto;

import com.syntaxtales.youtube.LearningRESTAPI.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<StudentDto> getAllStudent(){
        return ResponseEntity.ok((StudentDto) studentService.getAllStudent());
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id)
    {
        return ResponseEntity.ok(studentService.getStudentById(id));

    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentDto addStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateToStudent(@PathVariable Long id, @RequestBody AddStudentDto addStudentDto){

        return ResponseEntity.ok(studentService.updateToStudent(id, addStudentDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){

        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }


}
