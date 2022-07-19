package com.lzh.studentdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzh.studentdemo.domain.Student;
import com.lzh.studentdemo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		Iterable<Student> list = studentRepository.findAll();
		return (List<Student>) list;
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student findById(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.get();
	}

	@Override
	public void update(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void add(Student student) {
		studentRepository.save(student);
	}

	@Override
	public List<Student> findByNameLike(String name) {
		Iterable<Student> list  = studentRepository.findByNameLike("%"+name+"%");
		return (List<Student>) list;
	}
	
}
