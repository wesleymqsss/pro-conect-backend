package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.AlunoNotaProjection;
import com.proconect.proconectapi.DTO.TurmaDTO;
import com.proconect.proconectapi.DTO.AlunoRespostaDTO;
import com.proconect.proconectapi.model.Aluno;
import com.proconect.proconectapi.repository.AlunoRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Alunos")
public class AlunoController {

    private final AlunoRepository alunoRepo;

    public AlunoController(AlunoRepository alunoRepo) {
        this.alunoRepo = alunoRepo;
    }

    @Operation(summary = "Lista todas as turmas disponíveis")
    @GetMapping("/View-de-turmas")
    public List<TurmaDTO> listarTurmas() {
        List<String> letras = alunoRepo.findDistinctTurmas();
        return letras.stream()
                .map(letra -> {
                    String curso = alunoRepo.findByTurma(letra)
                            .stream()
                            .findFirst()
                            .map(Aluno::getCurso)
                            .orElse("ADS");
                    return new TurmaDTO(
                            (long)(letra.charAt(0) - 'A' + 1),
                            "Turma " + letra,
                            curso,
                            "4º Semestre",
                            "09h00 AM",
                            "12h00 AM"
                    );
                })
                .collect(Collectors.toList());
    }

    @Operation(summary = "Lista todos os alunos de uma turma com suas notas finais (média das provas)")
    @GetMapping("/{turma}")
    public ResponseEntity<List<AlunoRespostaDTO>> listarAlunosPorTurma(
            @PathVariable("turma") String turma) {

        List<Aluno> alunos = alunoRepo.findByTurma(turma);

        Map<Long, Double> notasMap = alunoRepo.buscarNotasFinaisPorAluno()
                .stream()
                .collect(Collectors.toMap(
                        AlunoNotaProjection::getAlunoId,
                        AlunoNotaProjection::getNota
                ));

        List<AlunoRespostaDTO> dto = alunos.stream()
                .map(a -> new AlunoRespostaDTO(
                        a.getId(),
                        a.getNome(),
                        a.getMatricula(),
                        a.getCurso(),
                        a.getTurma(),
                        notasMap.getOrDefault(a.getId(), null)
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(dto);
    }
}
