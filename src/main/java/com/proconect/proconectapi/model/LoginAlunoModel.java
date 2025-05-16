package com.proconect.proconectapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class LoginAlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // renomeei para username/password para bater com o controller
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Role role;

    public enum Role {
        professor,
        aluno
    }

    // ——— getters e setters ———

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {      // <— deve existir
        return username;
    }

    public void setUsername(String username) {  // <— deve existir
        this.username = username;
    }

    public String getPassword() {      // <— deve existir
        return password;
    }

    public void setPassword(String password) {  // <— deve existir
        this.password = password;
    }

    public Role getRole() {            // <— deve existir
        return role;
    }

    public void setRole(Role role) {   // <— deve existir
        this.role = role;
    }
}
