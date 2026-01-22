package uce.edu.api.web.matricula.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import uce.edu.api.web.matricula.application.MateriaService;
import uce.edu.api.web.matricula.domain.Materia;

import java.util.List;

@Path("/materias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MateriaResource {

    @Inject
    private MateriaService materiaService;

    @GET
    @Path("/")
    public List<Materia> listarTodos() {
        return materiaService.listarTodos();
    }

    @GET
    @Path("/consultarPorId/{id}")
    public Materia consultarPorId(@PathParam("id") Integer id) {
        return materiaService.consultarPorId(id);
    }

    @POST
    @Path("")
    public void guardar(Materia materia) {
        materiaService.guardar(materia);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(@PathParam("id") Integer id, Materia materia) {
        materiaService.actualizar(id, materia);
    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id) {
        materiaService.eliminar(id);
    }

    // Buscar materias por nombre
    @GET
    @Path("/buscarPorNombre/{nombre}")
    public List<Materia> buscarPorNombre(@PathParam("nombre") String nombre) {
        return materiaService.buscarPorNombre(nombre);
    }

    // Listar materias con un número mínimo de créditos
    @GET
    @Path("/creditos/{minCreditos}")
    public List<Materia> listarPorCreditos(@PathParam("minCreditos") Integer minCreditos) {
        return materiaService.listarPorCreditos(minCreditos);
    }
}