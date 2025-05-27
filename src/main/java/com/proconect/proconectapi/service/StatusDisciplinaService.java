package com.proconect.proconectapi.service;

import com.proconect.proconectapi.DTO.StatusDisciplinaDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusDisciplinaService {

    private final JdbcTemplate jdbcTemplate;

    public StatusDisciplinaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<StatusDisciplinaDTO> listarStatus() {
        String sql = """
            SELECT disciplina, aprovados, reprovados, recuperacao
            FROM status_disciplinas
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new StatusDisciplinaDTO(
                        rs.getString("disciplina"),
                        rs.getInt("aprovados"),
                        rs.getInt("reprovados"),
                        rs.getInt("recuperacao")
                )
        );
    }
}
