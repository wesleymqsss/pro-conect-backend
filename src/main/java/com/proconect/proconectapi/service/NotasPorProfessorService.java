package com.proconect.proconectapi.service;

import com.proconect.proconectapi.DTO.NotasPorProfessorDTO;
import com.proconect.proconectapi.repository.NotasPorProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotasPorProfessorService {

    @Autowired
    private NotasPorProfessorRepository repository;

    public List<NotasPorProfessorDTO> listarNotas() {
        return repository.getNotasPorProfessor().stream().map(obj -> new NotasPorProfessorDTO(
                ((Number) obj[0]).longValue(),         // prova_id
                (String) obj[1],                       // descricao_prova
                ((Date) obj[2]).toLocalDate(),         // data_prova
                ((Number) obj[3]).longValue(),         // professor_id
                ((Number) obj[4]).longValue(),         // aluno_id
                (String) obj[5],                       // aluno_nome
                (String) obj[6],                       // matricula
                (String) obj[7],                       // curso
                (String) obj[8],                       // turma
                ((Number) obj[9]).doubleValue()        // nota
        )).collect(Collectors.toList());
    }
}
