package com.proconect.proconectapi.service;

import com.proconect.proconectapi.DTO.BoletimAlunoDTO;
import com.proconect.proconectapi.repository.BoletimAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoletimAlunoService {

    @Autowired
    private BoletimAlunoRepository boletimAlunoRepository;

    public List<BoletimAlunoDTO> getBoletimAlunos() {
        return boletimAlunoRepository.getBoletimAlunos()
                .stream()
                .map(obj -> new BoletimAlunoDTO(
                        ((Number) obj[0]).longValue(),
                        (String) obj[1],
                        (String) obj[2],
                        (String) obj[3],
                        (String) obj[4],
                        (String) obj[5],
                        obj[6] != null ? ((Number) obj[6]).doubleValue() : null
                ))
                .collect(Collectors.toList());
    }
}
