package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.model.Aluno;
import com.proconect.proconectapi.model.Tarefa;
import com.proconect.proconectapi.repository.AlunoRepository;
import com.proconect.proconectapi.repository.TarefaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Operation(
            summary = "Faz upload de uma tarefa para um aluno",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Tarefa enviada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno ao enviar tarefa")
            }
    )
    @PostMapping(value = "/upload/{alunoId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> enviarTarefa(
            @PathVariable Integer alunoId,
            @RequestPart("file") MultipartFile file) {

        try {
            Aluno aluno = alunoRepository.findById(alunoId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

            Tarefa tarefa = new Tarefa();
            tarefa.setNomeArquivo(file.getOriginalFilename());
            tarefa.setTipoArquivo(file.getContentType());
            tarefa.setDados(file.getBytes());
            tarefa.setDataEnvio(LocalDateTime.now());
            tarefa.setAluno(aluno);

            tarefaRepository.save(tarefa);
            return ResponseEntity.ok("Tarefa enviada com sucesso!");
        } catch (IOException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar o arquivo.");
        }
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Tarefa> listarPorAluno(@PathVariable Long alunoId) {
        return tarefaRepository.findByAlunoId(alunoId);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {
        Optional<Tarefa> tarefaOpt = tarefaRepository.findById(id);
        if (tarefaOpt.isPresent()) {
            Tarefa tarefa = tarefaOpt.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + tarefa.getNomeArquivo() + "\"")
                    .contentType(MediaType.parseMediaType(tarefa.getTipoArquivo()))
                    .body(tarefa.getDados());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
