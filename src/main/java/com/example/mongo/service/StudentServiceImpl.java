package com.example.mongo.service;

import com.example.mongo.model.StudentRequest;
import com.example.mongo.model.StudentResponse;
import com.example.mongo.persistence.entity.Student;
import com.example.mongo.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Override
    public StudentResponse create(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setDocument(request.getDocument());
        student.setBirthDate(request.getBirthDate());

        repository.save(student);



        return createResponse(student);
    }

    private StudentResponse createResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setDocument(student.getDocument());
        response.setBirthDate(student.getBirthDate());

        return response;
    }

    @Override
    public List<StudentResponse> getAll() {
        List<StudentResponse> responses = new ArrayList<>();

        List<Student> students = repository.findAll();

        if(!students.isEmpty()){
            students.forEach(student -> responses.add(createResponse(student)));
        }

        /*for (Student student: students){ mesma coisa que o lambda
            responses.add(createResponse());
        }*/

        return responses;
    }






}
