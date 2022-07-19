package com.lzh.studentdemo.service;

import java.util.List;

import com.lzh.studentdemo.domain.Student;

public interface StudentService {
	List<Student> findAll();
	void delete(Long id);
	Student findById(Long id);
	void update(Student student);
	void add(Student student);
	List<Student> findByNameLike(String name);
}
