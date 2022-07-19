package com.lzh.studentdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.lzh.studentdemo.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	Iterable<Student> findByNameLike(String string);


}
