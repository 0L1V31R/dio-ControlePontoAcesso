package br.com.dio.defy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.defy.exception.NoSuchElementException;
import br.com.dio.defy.model.JornadaTrabalho;
import br.com.dio.defy.repository.JornadaRepository;

@Service
public class JornadaService {
    
    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
        return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> findAll() {
        return jornadaRepository.findAll();
    }

    public Optional<JornadaTrabalho> getById(long idJornada) throws NoSuchElementException {
        verifyId(idJornada);
        return jornadaRepository.findById(idJornada);
    }

    public JornadaTrabalho updateJornada(long idJornada, JornadaTrabalho jornadaTrabalho) throws NoSuchElementException{
        verifyId(idJornada);
        return jornadaRepository.save(jornadaTrabalho);
    }
    
    public void deleteJornada(long idJornada) throws NoSuchElementException {
        verifyId(idJornada);
        jornadaRepository.deleteById(idJornada);
    }

    private JornadaTrabalho verifyId(long idJornada) throws NoSuchElementException {
        return jornadaRepository.findById(idJornada).orElseThrow(() -> new NoSuchElementException(idJornada));
    }
}
