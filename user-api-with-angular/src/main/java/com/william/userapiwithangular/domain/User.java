package com.william.userapiwithangular.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_USERNAME")
    private String username;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_ADDRESS")
    //@ManyToOne(cascade = CascadeType.ALL)
    @Embedded
    private Address address;

    @Column(name = "USER_PHONE")
    //@ManyToOne(cascade = CascadeType.ALL)
    private String phone;

    @Column(name = "USER_WEBSITE")
    //@ManyToOne(cascade = CascadeType.ALL)
    private String website;

    @Column(name = "USER_COMPANY")
    //@OneToMany(cascade = CascadeType.ALL)
    @Embedded
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
