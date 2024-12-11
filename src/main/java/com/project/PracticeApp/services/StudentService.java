package com.project.PracticeApp.services;

import com.project.PracticeApp.dto.StudentDTO;
import com.project.PracticeApp.orm.Student;
import com.project.PracticeApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student findByUsername(String username) {
        return studentRepository.findByUser_Username(username);
    }

    public void updateStudentInfo(String username, Student student) {
        Student old_student = findByUsername(username);
        old_student.setPhone(student.getPhone());
        old_student.setComments(student.getComments());
        old_student.setEmail(student.getEmail());
        old_student.setRegistration(student.getRegistration());
        old_student.setCompetencies(student.getCompetencies());
        studentRepository.save(old_student);
    }

    public void updateStudentInfoWithDTO(String username, StudentDTO studentDTO) {
        Student old_student = findByUsername(username);
        old_student.setPhone(studentDTO.getPhone());
        old_student.setComments(studentDTO.getComments());
        old_student.setEmail(studentDTO.getEmail());
        old_student.setRegistration(studentDTO.getRegistration());
        old_student.setCompetencies(studentDTO.parseCompetencies(studentDTO.getCompetencies()));
        studentRepository.save(old_student);
    }
}
