package com.project.PracticeApp.dto;

import com.project.PracticeApp.orm.PracticeStatus;

public class PracticeDTO {
    private String curator;
    private String period;
    private PracticeStatus status;
    private String organization;
    private String organizationAddress;
    private String contactPerson;
    private String phone;
    private String email;

    public PracticeDTO(String curator, String period, PracticeStatus status, String organization, String organisationAddress, String contactPerson, String phone, String email) {
        this.curator = curator;
        this.period = period;
        this.status = status;
        this.organization = organization;
        this.organizationAddress = organisationAddress;
        this.contactPerson = contactPerson;
        this.phone = phone;
        this.email = email;
    }

    public String getCurator() {
        return curator;
    }

    public String getPeriod() {
        return period;
    }

    public PracticeStatus getStatus() {
        return status;
    }

    public String getOrganization() {
        return organization;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setStatus(PracticeStatus status) {
        this.status = status;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
