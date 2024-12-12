package com.project.PracticeApp.services;

import com.project.PracticeApp.dto.StudentDTO;
import com.project.PracticeApp.orm.Competency;
import com.project.PracticeApp.orm.Student;
import com.project.PracticeApp.repositories.CompetenceRepository;
import com.project.PracticeApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CompetenceRepository competenceRepository;

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
        old_student.setCompetencies(this.parseCompetencies(studentDTO.getCompetencies()));
        competenceRepository.saveAll(old_student.getCompetencies());
        studentRepository.save(old_student);
    }

    public String joinCompetencies(Set<Competency> competencies){
        return String.join(", ", competencies.stream().map(Competency::getName).collect(Collectors.toSet()));
    }

    public Set<Competency> parseCompetencies(String competenciesString){
        Set<Competency> competencies = new HashSet<>();
        Set<String> comp = Arrays.stream(competenciesString.split(",")).map(String::strip).collect(Collectors.toSet());
        for (String com : comp) {
            Competency newCompetency = competenceRepository.findByName(com).orElseGet(() -> new Competency(com));
            competencies.add(newCompetency);
        }
        return competencies;
    }

}
