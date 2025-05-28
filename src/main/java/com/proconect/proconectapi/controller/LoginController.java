package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.LoginDTO;
import com.proconect.proconectapi.model.LoginAlunoModel;
import com.proconect.proconectapi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    // 1) LOGIN
    @PostMapping("/auth")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO dto) {
        Optional<LoginAlunoModel> u = loginRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());

        Map<String, String> response = new HashMap<>();
        if (u.isPresent()) {
            response.put("message", "Login bem‑sucedido!");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Usuário ou senha inválidos.");
            return ResponseEntity.status(401).body(response);
        }
    }

    // 2) CREATE (registro)
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody LoginDTO dto) {
        LoginAlunoModel u = new LoginAlunoModel();
        u.setUsername(dto.getUsername());
        u.setPassword(dto.getPassword());
        u.setRole(LoginAlunoModel.Role.valueOf(dto.getRole()));
        loginRepository.save(u);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuário registrado com ID: " + u.getId());
        return ResponseEntity.ok(response);
    }

    // 3) READ ALL
    @GetMapping
    public ResponseEntity<List<LoginAlunoModel>> listAll() {
        List<LoginAlunoModel> users = loginRepository.findAll();
        return ResponseEntity.ok(users);
    }

    // 4) READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable Integer id) {
        Optional<LoginAlunoModel> userOpt = loginRepository.findById(id);

        if (userOpt.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Usuário encontrado.");
            response.put("user", userOpt.get());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(404)
                    .body(Map.of("error", "Usuário não encontrado."));
        }
    }



    // 5) UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable Integer id, @RequestBody LoginDTO dto) {
        Optional<LoginAlunoModel> uOpt = loginRepository.findById(id);
        if (uOpt.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("error", "Usuário não encontrado."));
        }

        LoginAlunoModel u = uOpt.get();
        u.setUsername(dto.getUsername());
        u.setPassword(dto.getPassword());
        u.setRole(LoginAlunoModel.Role.valueOf(dto.getRole()));
        loginRepository.save(u);

        return ResponseEntity.ok(Map.of("message", "Usuário atualizado."));
    }

    // 6) DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        if (!loginRepository.existsById(id)) {
            return ResponseEntity.status(404).body(Map.of("error", "Usuário não encontrado."));
        }

        loginRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Usuário deletado."));
    }

    // 7) FIND LOGIN
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
            return ResponseEntity.status(404).body(Map.of("error", "Usuário ou senha inválidos."));
        }
    }
}
