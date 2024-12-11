package com.project.PracticeApp.services;

import com.project.PracticeApp.orm.Practice;
import com.project.PracticeApp.orm.Student;
import com.project.PracticeApp.repositories.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {
    @Autowired
    PracticeRepository practiceRepository;

    public List<Practice> getPracticesForStudent(Student student) {
        return practiceRepository.findAllPracticeByStudent(student);
    }

    public Practice getPracticeById(Long practiceId) {
        return practiceRepository.findPracticeById(practiceId);
    }

    public void updatePracticeDetails(Long practiceId, Practice practice, Student student) {

    }
}
