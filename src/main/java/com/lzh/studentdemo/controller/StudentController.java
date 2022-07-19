package com.lzh.studentdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lzh.studentdemo.domain.Student;
import com.lzh.studentdemo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public ModelAndView show(Model model) {
		List<Student> list = studentService.findAll();
		model.addAttribute("list", list);
		return new ModelAndView("student_table.html","listModel",model);
	}
	
	@RequestMapping("/toDelete/{id}")
	public ModelAndView toDelete(@PathVariable("id")Long id) {
		studentService.delete(id);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/toEdit/{id}")
	public ModelAndView toEdit(@PathVariable("id")Long id,Model model){
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		return new ModelAndView("student_edit.html","studentModel",model);
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(Student student) {
		studentService.update(student);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/toAdd")
	public ModelAndView toAdd() {
		return new ModelAndView("student_add.html");
	}
	
	@RequestMapping("/add")
	public ModelAndView add(Student student) {
		studentService.add(student);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/toQuery")
	public ModelAndView toQuery(String name,Model model) {
		List<Student> sd = studentService.findByNameLike(name);
		model.addAttribute("sd", sd);
		return new ModelAndView("student_query.html","sModel",model);
	}
	
}
