package com.lucas.rn.solid;

import com.lucas.rn.solid.model.Cargo;
import com.lucas.rn.solid.model.DadoPessoal;
import com.lucas.rn.solid.model.Funcionario;
import com.lucas.rn.solid.service.reajuste.ReajusteService;
import com.lucas.rn.solid.service.reajuste.ValidacaoPercentualReajuste;
import com.lucas.rn.solid.service.reajuste.ValidacaoPeriodicidadeEntreReajuste;
import com.lucas.rn.solid.service.reajuste.ValidacaoReajuste;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;

    @Before
    public void setUp() {
        ValidacaoPercentualReajuste percentual = new ValidacaoPercentualReajuste();
        ValidacaoPeriodicidadeEntreReajuste periodicidade = new ValidacaoPeriodicidadeEntreReajuste();
        Set<ValidacaoReajuste> validacoes = new HashSet<>();

        validacoes.add(percentual);
        validacoes.add(periodicidade);

        reajusteService = new ReajusteService(validacoes);
    }

    @Test
    public void testPrimeiroAumento() {
        Funcionario funcionario = givenFuncionario();
        funcionario.setDataUltimoReajuste(null);

        var aumento = givenAumento(funcionario.getDadoPessoal().getSalario(), "0.1");

        reajusteService.validar(funcionario, aumento);

        assertEquals(new BigDecimal("6270.000"), funcionario.getDadoPessoal().getSalario());
        assertEquals(LocalDate.now(), funcionario.getDataUltimoReajuste());
    }

    @Test
    public void testAumento() {
        var funcionario = givenFuncionario();
        var aumento = givenAumento(funcionario.getDadoPessoal().getSalario(), "0.1");

        reajusteService.validar(funcionario, aumento);

        assertEquals(new BigDecimal("6270.000"), funcionario.getDadoPessoal().getSalario());
        assertEquals(LocalDate.now(), funcionario.getDataUltimoReajuste());
    }

    @Test
    public void testAumentoMaiorQue40() {
        var funcionario = givenFuncionario();
        var aumento = givenAumento(funcionario.getDadoPessoal().getSalario(), "0.5");

        var erro = "";
        try {
            reajusteService.validar(funcionario, aumento);
        } catch (ValidacaoException v) {
            erro = v.getMessage();
        }
        assertEquals(erro, "Reajuste não pode ser superior a 40% do salário!");
    }

    @Test
    public void testPeriodoMenorQue6Meses() {
        var funcionario = givenFuncionario();
        funcionario.setDataUltimoReajuste(LocalDate.now());

        var aumento = givenAumento(funcionario.getDadoPessoal().getSalario(), "0.1");

        var erro = "";
        try {
            reajusteService.validar(funcionario, aumento);
        } catch (ValidacaoException v) {
            erro = v.getMessage();
        }
        assertEquals(erro, "Intervalo para reajuste deve ser de 6 meses.");
    }

    private Funcionario givenFuncionario() {
        return Funcionario.builder()
                .dadoPessoal(givenDadoPessoal())
                .dataUltimoReajuste(LocalDate.of(2020, 3, 30))
                .build();
    }

    private DadoPessoal givenDadoPessoal(){
        return DadoPessoal.builder()
                .nome("Funcionário Feliz")
                .cpf("12345678901")
                .cargo(Cargo.ESPECIALISTA)
                .salario(new BigDecimal("5700.00"))
                .build();
    }

    private BigDecimal givenAumento(BigDecimal salario, String porcentagem) {
        var valorPorcentagem = new BigDecimal(porcentagem);
        return valorPorcentagem.multiply(salario);
    }

}
