package com.app.StudentPracticeApp.orm;
import com.app.StudentPracticeApp.security.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "site_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password_hash;

    protected User() {
    }

    public User(Long id, String username, String password_hash, Role role){
        this.username = username;
        this.password_hash = password_hash;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

