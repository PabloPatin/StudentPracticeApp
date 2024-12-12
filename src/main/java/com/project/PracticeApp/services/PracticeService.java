package com.project.PracticeApp.services;

import com.project.PracticeApp.dto.PracticeDTO;
import com.project.PracticeApp.orm.Company;
import com.project.PracticeApp.orm.Contact;
import com.project.PracticeApp.orm.Practice;
import com.project.PracticeApp.orm.Student;
import com.project.PracticeApp.repositories.CompanyRepository;
import com.project.PracticeApp.repositories.ContactRepository;
import com.project.PracticeApp.repositories.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticeService {
    @Autowired
    PracticeRepository practiceRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    CompanyRepository companyRepository;

    public List<Practice> getPracticesForStudent(Student student) {
        return practiceRepository.findAllPracticeByStudent(student);
    }

    public Practice getPracticeById(Long practiceId) {
        return practiceRepository.findPracticeById(practiceId);
    }

    public void updatePracticeDetails(Long practiceId, Practice practice, Student student) {

    }

    public void updatePracticeWithDTO(Practice practice, PracticeDTO practiceDTO) {
        practice.setStatus(practiceDTO.getStatus());
        Company company = companyRepository.findByName(practiceDTO.getOrganization())
                .orElseGet(() -> new Company(practiceDTO.getOrganization()));
        if (practice.getCompany() != company) {
            practice.setCompany(company);
        }
        Contact mentor = contactRepository.findByName(practiceDTO.getContactPerson())
                .orElseGet(() -> new Contact(practiceDTO.getContactPerson(), practice.getCompany()));
        if (practice.getCompanyMentor() != mentor){
            practice.setCompanyMentor(mentor);
        }
        company.setAddress(practiceDTO.getOrganizationAddress());
        mentor.setEmail(practiceDTO.getEmail());
        mentor.setPhone(practiceDTO.getPhone());
        if (!company.getContacts().contains(mentor)) {
            company.addContact(mentor);
        }
        companyRepository.save(practice.getCompany());
        practiceRepository.save(practice);
    }
}
