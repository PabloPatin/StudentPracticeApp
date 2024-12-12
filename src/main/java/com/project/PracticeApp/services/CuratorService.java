package com.project.PracticeApp.services;

import com.project.PracticeApp.orm.Curator;
import com.project.PracticeApp.orm.Faculty;
import com.project.PracticeApp.orm.StudentGroup;
import com.project.PracticeApp.repositories.CuratorRepository;
import com.project.PracticeApp.repositories.FacultyRepository;
import com.project.PracticeApp.repositories.GroupPracticeRepository;
import com.project.PracticeApp.repositories.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuratorService {
    @Autowired
    CuratorRepository curatorRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    GroupPracticeRepository groupPracticeRepository;

    @Autowired
    StudentGroupRepository studentGroupRepository;

    public Curator findByUserame(String username) {
        return curatorRepository.findByUser_Username(username);
    }

    public Faculty findFaculty(String faculty) {
            return facultyRepository.findByName(faculty).orElseGet(() -> new Faculty(faculty));
    }

    public void saveGroup(StudentGroup group) {
        studentGroupRepository.save(group);
    }

    public StudentGroup findGroup(Long id) {
        return studentGroupRepository.findById(id).orElse(null);
    }

    public void deleteGroup(StudentGroup group) {
        groupPracticeRepository.deleteAll(group.getGroupPractices());
        studentGroupRepository.delete(group);
    }
}
