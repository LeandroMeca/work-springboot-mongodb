package com.example.mongo.service;

import com.example.mongo.model.StudentRequest;
import com.example.mongo.model.StudentResponse;

import java.util.List;

public interface StudentService {


    StudentResponse create(StudentRequest request);


    public List<StudentResponse> getAll();
}
