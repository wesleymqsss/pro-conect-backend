package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.LoginDTO;
import com.proconect.proconectapi.model.LoginAlunoModel;
import com.proconect.proconectapi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    // 1) LOGIN
    @PostMapping("/auth")
    public String login(@RequestBody LoginDTO dto) {
        Optional<LoginAlunoModel> u = loginRepository
                .findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        return u.isPresent()
                ? "Login bem‑sucedido!"
                : "Usuário ou senha inválidos.";
    }

    // 2) CREATE (registro)
    @PostMapping("/register")
    public String register(@RequestBody LoginDTO dto) {
        LoginAlunoModel u = new LoginAlunoModel();
        u.setUsername(dto.getUsername());
        u.setPassword(dto.getPassword());
        u.setRole(LoginAlunoModel.Role.valueOf(dto.getRole()));
        loginRepository.save(u);
        return "Usuário registrado com ID: " + u.getId();
    }

    // 3) READ ALL
    @GetMapping
    public List<LoginAlunoModel> listAll() {
        return loginRepository.findAll();
    }

    // 4) READ BY ID
    @GetMapping("/{id}")
    public Optional<LoginAlunoModel> getById(@PathVariable Integer id) {
        return loginRepository.findById(id);
    }

    // 5) UPDATE
    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody LoginDTO dto) {
        Optional<LoginAlunoModel> uOpt = loginRepository.findById(id);
        if (uOpt.isEmpty()) {
            return "Usuário não encontrado.";
        }
        LoginAlunoModel u = uOpt.get();
        u.setUsername(dto.getUsername());
        u.setPassword(dto.getPassword());
        u.setRole(LoginAlunoModel.Role.valueOf(dto.getRole()));
        loginRepository.save(u);
        return "Usuário atualizado.";
    }

    // 6) DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        if (!loginRepository.existsById(id)) {
            return "Usuário não encontrado.";
        }
        loginRepository.deleteById(id);
        return "Usuário deletado.";
    }

    @GetMapping("/find")
    public ResponseEntity<Map<String, Object>> findByUsernameAndPassword(
            @RequestParam String username,
            @RequestParam String password) {

        Optional<LoginAlunoModel> u = loginRepository.findByUsernameAndPassword(username, password);
        if (u.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login encontrado");
            response.put("user", u.get());
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Usuário ou senha inválidos.");
            return ResponseEntity.status(404).body(error);
        }
    }
}


