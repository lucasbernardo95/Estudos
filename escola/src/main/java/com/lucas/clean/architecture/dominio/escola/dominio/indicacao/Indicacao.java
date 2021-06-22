package com.lucas.clean.architecture.dominio.escola.dominio.indicacao;

import com.lucas.clean.architecture.dominio.escola.dominio.aluno.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Indicacao {
    private Aluno indicador;
    private Aluno indicante;
    private LocalDateTime dataIndicacao = LocalDateTime.now();
}
