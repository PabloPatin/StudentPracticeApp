package com.project.PracticeApp.controllers;

import com.project.PracticeApp.orm.Curator;
import com.project.PracticeApp.orm.Faculty;
import com.project.PracticeApp.orm.GroupPractice;
import com.project.PracticeApp.orm.StudentGroup;
import com.project.PracticeApp.services.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher")
public class CuratorController {
    @Autowired
    CuratorService curatorService;

    @GetMapping("/welcome")
    public String hello(@AuthenticationPrincipal UserDetails userDetails){
        Curator curator = curatorService.findByUserame(userDetails.getUsername());
        return "Добро пожаловать " + curator.getFullName();
    }

    @GetMapping("/groups")
    public List<StudentGroup> getAllGroups(@AuthenticationPrincipal UserDetails userDetails){
        Curator curator = curatorService.findByUserame(userDetails.getUsername());
        Set<StudentGroup> groups = curator.getGroupPractices().stream().map(GroupPractice::getGroup).collect(Collectors.toSet());
        return groups.stream().toList();
    }

    @PostMapping("/group")
    public ResponseEntity<StudentGroup> addGroup(@RequestParam String groupName, @RequestParam String faculty, @RequestParam Short course){
        Faculty new_faculty = curatorService.findFaculty(faculty);
        StudentGroup group = new StudentGroup(groupName, new_faculty, course);
        curatorService.saveGroup(group);
        return ResponseEntity.ok(group);
    }

    @PutMapping("/group/{id}")
    public ResponseEntity<StudentGroup> updateGroup(@PathVariable Long id, @RequestParam String groupName,
                                           @RequestParam String faculty, @RequestParam Short course){
        StudentGroup old_group = curatorService.findGroup(id);
        Faculty new_faculty = curatorService.findFaculty(faculty);
        if (old_group==null){
            return ResponseEntity.ofNullable(null);
        } else {
            old_group.setCourse(course);
            old_group.setFaculty(new_faculty);
            old_group.setName(groupName);
            curatorService.saveGroup(old_group);
            return ResponseEntity.ok(old_group);
        }
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<StudentGroup> deleteGroup(@PathVariable Long id){
        StudentGroup old_group = curatorService.findGroup(id);
        if (old_group==null){
            return ResponseEntity.ofNullable(null);
        } else {
            curatorService.deleteGroup(old_group);
            return ResponseEntity.ok(old_group);
        }
    }

}
