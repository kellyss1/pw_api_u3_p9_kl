package uce.edu.api.web.matricula.application;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.api.web.matricula.infraestructure.HijoRepository;
import uce.edu.api.web.matricula.domain.Hijo;

@ApplicationScoped
public class HijoService {
    
    @Inject
    private HijoRepository hijoRepository;

    public List<Hijo> buscarPorIdEstudiante(Integer idEstudiante) {
        return this.hijoRepository.buscarPorIdEstudiante(idEstudiante);
    }
}