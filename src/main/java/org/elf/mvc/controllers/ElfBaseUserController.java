package org.elf.mvc.controllers;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.elf.mvc.error.ElfRunException;
import org.elf.mvc.models.ElfBaseUserModels;
import org.elf.mvc.models.entitys.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Path("/api/user")
@Produces(MediaType.APPLICATION_JSON)
public class ElfBaseUserController {
	@Autowired
	ElfBaseUserModels ebum;

	@POST
	@Path("/login")
	public Response login(
			@FormParam("userName") String userName, 
			@FormParam("password") String password,
			@FormParam("equipmentId") long equipmentId
	) throws NoSuchAlgorithmException, ElfRunException {
		return Response.getSuccess(null, ebum.login(userName, password, equipmentId));
	}
}
