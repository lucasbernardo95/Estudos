package com.lucas.escola;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Indicacao {
    private Aluno indicador;
    private Aluno indicante;
}
