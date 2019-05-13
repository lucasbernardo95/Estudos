package com.frontend.controller;

import com.frontend.model.Convidado;
import com.frontend.model.Evento;
import com.frontend.repository.ConvidadoRepository;
import com.frontend.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository repository;

    @Autowired
    private ConvidadoRepository repositoryConvidado;

    //retorna o formulário quando solicitado
    @GetMapping("/cadastrarEvento")
    public String form(){
        return "evento/formEvento";
    }

    //chamado quando o botão salvar, em evento/formEvento for  'clicado'
    @PostMapping("/cadastrarEvento")
    public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarEvento";
        }
        repository.save(evento);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
        return "redirect:/cadastrarEvento";
    }

    @GetMapping("/eventos")
    public ModelAndView listaEventos(){
        //informa qual a página que vai ser renderizada de acordo com os dados do evento
        ModelAndView mv = new ModelAndView("index");
        //o nome eventos tem que ser o mesmo no arquivo html
        Iterable<Evento> eventos = repository.findAll();
        mv.addObject("eventos", eventos);

        return  mv;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhesEvento(@PathVariable long id){
        Evento evento = repository.findEventoById(id);

        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);

        //busca os convidados de cada evento e add a view
        Iterable<Convidado> convidados = repositoryConvidado.findConvidadoByEvento(evento);
        mv.addObject("convidados", convidados);

        return mv;
    }

    @PostMapping("/{id}")
    public String cadastrarConvidado(@PathVariable long id, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes){

        //se houverem erros
        if (result.hasErrors()) {
            //se ocorrer algum erro, o addFlashAttribute redireciona essa mensagem para a view
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            //redireciona para o formulário
            return "redirect:/{id}";
        }

        Evento evento = repository.findEventoById(id);
        convidado.setEvento(evento);
        repositoryConvidado.save(convidado);
        attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
        return "redirect:/{id}";
    }

    @RequestMapping("/deletarEvento")
    public String deletarEvento(long id){
        Evento evento = repository.findEventoById(id);

//        if (!evento.getConvidado().isEmpty()){
//            for (Convidado c : evento.getConvidado()){
//                repositoryConvidado.delete(c);
//            }
//        }
        repository.delete(evento);
        return "redirect:/eventos";
    }

}