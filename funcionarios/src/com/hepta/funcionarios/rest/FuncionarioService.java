package com.hepta.funcionarios.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;

@Path("/funcionarios")
public class FuncionarioService {

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private FuncionarioDAO dao;

	public FuncionarioService() {
		dao = new FuncionarioDAO();
	}

	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * Adiciona novo Funcionario
	 * 
	 * @param Funcionario: Novo Funcionario
	 * @return response 200 (OK) - Conseguiu adicionar
	 */
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response FuncionarioCreate(Funcionario funcionario) {
		try {
			
			dao.save(funcionario);
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao inserir funcionário.").build();
		}
		
		return Response.status(Status.OK).entity(funcionario).build();
	}

	/**
	 * Lista todos os Funcionarios
	 * 
	 * @return response 200 (OK) - Conseguiu listar
	 */
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response FuncionarioRead() {
		List<Funcionario> Funcionarios = new ArrayList<>();
		try {
			Funcionarios = dao.getAll();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar Funcionarios").build();
		}

		GenericEntity<List<Funcionario>> entity = new GenericEntity<List<Funcionario>>(Funcionarios) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	/**
	 * Lista um Funcionario
	 * 
	 * @return response 200 (OK) - Conseguiu listar
	 */
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response FuncionarioGet(@PathParam("id") Integer id) {
		Funcionario funcionario = new Funcionario();
		try {
			funcionario = dao.find(id);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar Funcionario").build();
		}

		GenericEntity<Funcionario> entity = new GenericEntity<Funcionario>(funcionario) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}
	

	/**
	 * Atualiza um Funcionario
	 * 
	 * @param id:          id do Funcionario
	 * @param Funcionario: Funcionario atualizado
	 * @return response 200 (OK) - Conseguiu atualizar
	 */
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response FuncionarioUpdate(@PathParam("id") Integer id, Funcionario Funcionario) {
		try {
			dao.update(Funcionario, id);
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar funcionário!").build();
		}
		return Response.status(Status.OK).entity("Funcionário atualizado com sucesso!").build();
	}

	/**
	 * Remove um Funcionario
	 * 
	 * @param id: id do Funcionario
	 * @return response 200 (OK) - Conseguiu remover
	 */
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response FuncionarioDelete(@PathParam("id") Integer id) {
		try {
			dao.delete(id);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar Funcionario.").build();
		}
		return Response.status(Status.OK).entity("Funcionario excluido com sucesso.").build();
	}
	
	
	/*Setores*/
	
	@Path("/setores")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response SetorRead() {
		List<Setor> Setores = new ArrayList<>();
		try {
			Setores = dao.getAllSetores();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar Setores").build();
		}

		GenericEntity<List<Setor>> entity = new GenericEntity<List<Setor>>(Setores) {
		};
		return Response.status(Status.OK).entity(entity).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@Path("/setores/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response SetorUpdate(@PathParam("id") Integer id, Setor setor) {
		try {
			dao.updateSetor(setor, id);
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar setor!").build();
		}
		return Response.status(Status.OK).entity("Setor atualizado com sucesso!").build();
	}
	
	
	
	@Path("/setores/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response SetorGet(@PathParam("id") Integer id) {
		Setor setor = new Setor();
		try {
			setor = dao.findSetor(id);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar Funcionario").build();
		}

		GenericEntity<Setor> entity = new GenericEntity<Setor>(setor) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@Path("/setores")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response SetorCreate(Setor setor) {
		try {
			
			dao.saveSetor(setor);
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao inserir setor.").build();
		}
		
		return Response.status(Status.OK).entity(setor).build();
	}

}
