package com.lucas.solid.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Terceirizado {
    private DadoPessoal dadoPessoal;
    private String empresa;

}
