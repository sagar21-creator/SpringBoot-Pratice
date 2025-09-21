package com.syntaxtales.youtube.LearningRESTAPI.service;

import com.syntaxtales.youtube.LearningRESTAPI.dto.AddStudentDto;
import com.syntaxtales.youtube.LearningRESTAPI.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface StudentService {
    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentDto addStudentDto);

    void deleteStudentById(Long id);

    StudentDto updateToStudent(Long id, AddStudentDto addStudentDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
