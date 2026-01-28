package uce.edu.api.web.matricula.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import uce.edu.api.web.matricula.application.MateriaService;
import uce.edu.api.web.matricula.domain.Materia;

import java.util.List;

@Path("/materia")
public class MateriaResource {

   @Inject
   private MateriaService materiaService;

   // 1.
   @GET
   @Path("")
   public List<Materia> listarTodos() {
      return materiaService.listarTodos();
   }

   // 2.
   @GET
   @Path("/{id}")
   public Materia consultarPorId(@PathParam("id") Integer id) {
      return materiaService.consultarPorId(id);
   }

   // 3.
   @POST
   @Path("")
   public void guardar(Materia materia) {
      materiaService.guardar(materia);
   }

   // 4.
   @PUT
   @Path("/{id}")
   public void actualizar(@PathParam("id") Integer id, Materia materia) {
      materiaService.actualizar(id, materia);
   }

   // 5.
   @PATCH
   @Path("/{id}")
   public void actualizarMateria(@PathParam("id") Integer id, Materia materia) {
      materiaService.actualizar(id, materia);
   }

   // 6.
   @DELETE
   @Path("/{id}")
   public void borrar(@PathParam("id") Integer id) {
      materiaService.eliminar(id);
   }

   // Nuevos endpoints
   // 7.
   @GET
   @Path("/{nombre}")
   public List<Materia> buscarPorNombre(@PathParam("nombre") String nombre) {
      return materiaService.buscarPorNombre(nombre);
   }

   // 8.
   @GET
   @Path("/{creditos}")
   public List<Materia> buscarPorSemestre(@PathParam("creditos") Integer creditos) {
      return materiaService.listarPorCreditos(creditos);
   }
}