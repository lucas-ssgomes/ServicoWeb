
package com.mycompany.crudrest;

import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("meuwebservice")
class MyApplicationController {
    
   static PersonagemDAO personagemDAO;

    public MyApplicationController() {
        this.personagemDAO = new PersonagemDAO();
    } 
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Ola mundooo!";
    }
    
    // http://localhost:8084/ExemploCrudREST/meuwebservice/adicionar?nome=Leonardo&idade=31
    @POST
    @Path("adicionar")
    public Response adicionar(@QueryParam("nome") String nome,
            @QueryParam("classe") String classe,
            @QueryParam("vida") int vida,
            @QueryParam("arma") String arma) {
        Personagem personagem = new Personagem(nome, classe, vida, arma);
        personagemDAO.getInstance().adicionar(personagem);
        return Response.status(Response.Status.OK).build();
    }
    
    @GET
    @Path("recuperar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recuperar(@QueryParam("nome") String nome) {
        Personagem personagem = personagemDAO.getInstance().recuperar(nome);
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(personagem)).build();
    }
    
    @POST
    @Path("alterar")
    public Response alterar(@QueryParam("nomeAntigo") String nomeAntigo,
            @QueryParam("nome") String nome,
            @QueryParam("classe") String classe,
            @QueryParam("vida") int vida,
            @QueryParam("arma") String arma){
        Personagem novoPersonagem = new Personagem(nome,classe,vida,arma);
        PersonagemDAO.getInstance().alterar(nomeAntigo, novoPersonagem);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("deletar")
    public Response deletar(@QueryParam("nome") String nome){
        PersonagemDAO.getInstance().deletar(nome);
        return Response.status(Response.Status.OK).build();
    }
    
    @GET
    @Path("recuperarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recuperarTodos(){
        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(PersonagemDAO.getInstance().recuperarTodos())).build();
    }
    
}
