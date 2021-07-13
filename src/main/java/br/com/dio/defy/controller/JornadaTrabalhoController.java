package br.com.dio.defy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.dio.defy.exception.NoSuchElementException;
import br.com.dio.defy.model.JornadaTrabalho;
import br.com.dio.defy.services.JornadaService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList() {
        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public Optional<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long idJornada) throws NoSuchElementException {
        return jornadaService.getById(idJornada);
    }

    @PutMapping("{idJornada}")
    public JornadaTrabalho updatejornada(@PathVariable("idJornada") Long idJornada, @RequestBody JornadaTrabalho jornadaTrabalho) throws NoSuchElementException {
        return jornadaService.updateJornada(idJornada, jornadaTrabalho);
    }

    @DeleteMapping("{idJornada}")
    public ResponseEntity<Object> deleteJornada(@PathVariable("idJornada") Long idJornada) throws NoSuchElementException {
        jornadaService.deleteJornada(idJornada);
        return ResponseEntity.ok().build();
    }
}
