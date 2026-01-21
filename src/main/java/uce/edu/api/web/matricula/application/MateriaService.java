package uce.edu.api.web.matricula.application;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.api.web.matricula.domain.Materia;
import uce.edu.api.web.matricula.infraestructure.MateriaRepository;

@ApplicationScoped
public class MateriaService {

    @Inject
    private MateriaRepository materiaRepository;

    public List<Materia> listarTodos() {
        return this.materiaRepository.listAll();
    }

    public Materia consultarPorId(Integer id) {
        return this.materiaRepository.findById(id.longValue());
    }

    @Transactional
    public void guardar(Materia materia) {
        this.materiaRepository.persist(materia);
    }

    @Transactional
    public void actualizar(Integer id, Materia materia) {
        Materia existente = this.consultarPorId(id);
        existente.setNombre(materia.getNombre());
        existente.setCreditos(materia.getCreditos());
        // Se actualiza automáticamente por dirty checking
    }

    @Transactional
    public void eliminar(Integer id) {
        this.materiaRepository.deleteById(id.longValue());
    }

    // Nuevo método: Buscar materias por nombre
    public List<Materia> buscarPorNombre(String nombre) {
        return this.materiaRepository.find("nombre", nombre).list();
    }

    // Nuevo método: Listar materias con un número mínimo de créditos
    public List<Materia> listarPorCreditos(Integer minCreditos) {
        return this.materiaRepository.find("creditos >= ?1", minCreditos).list();
    }
}