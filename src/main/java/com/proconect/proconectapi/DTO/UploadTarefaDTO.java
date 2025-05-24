package com.proconect.proconectapi.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

public class UploadTarefaDTO {

    @Schema(type = "string", format = "binary", description = "Arquivo da tarefa a ser enviado")
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
