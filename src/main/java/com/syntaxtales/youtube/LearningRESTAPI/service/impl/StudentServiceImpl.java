package com.syntaxtales.youtube.LearningRESTAPI.service.impl;

import com.syntaxtales.youtube.LearningRESTAPI.dto.AddStudentDto;
import com.syntaxtales.youtube.LearningRESTAPI.dto.StudentDto;
import com.syntaxtales.youtube.LearningRESTAPI.entity.Student;
import com.syntaxtales.youtube.LearningRESTAPI.repository.StudentRepository;
import com.syntaxtales.youtube.LearningRESTAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with id"));
       return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentDto addStudentDto) {
        Student newStudent = modelMapper.map(addStudentDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist buy id:" +id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateToStudent(Long id, AddStudentDto addStudentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found with id"));
        modelMapper.map(addStudentDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {

        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found with id"));
        updates.forEach((fields, value) ->{
          switch (fields) {
              case "name": student.setName((String) value);
                            break;
              case "email": student.setEmail((String) value);
              break;
              default:
                  throw new IllegalArgumentException("Field is not supported");

          }
        });
       Student saveStudent = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }
}
