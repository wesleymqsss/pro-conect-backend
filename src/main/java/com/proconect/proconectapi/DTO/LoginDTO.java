package com.proconect.proconectapi.DTO;

public class LoginDTO {

    private Integer id;
    private String username;
    private String password;
    private String role;

    // ——— getters e setters ———

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {       // <— deve existir
        return username;
    }

    public void setUsername(String username) {  // <— deve existir
        this.username = username;
    }

    public String getPassword() {       // <— deve existir
        return password;
    }

    public void setPassword(String password) {  // <— deve existir
        this.password = password;
    }

    public String getRole() {           // <— deve existir
        return role;
    }

    public void setRole(String role) {  // <— deve existir
        this.role = role;
    }
}
