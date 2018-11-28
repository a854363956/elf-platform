package org.elf.mvc.controllers;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.elf.mvc.error.ElfRunException;
import org.elf.mvc.models.ElfBaseMechanismModels;
import org.elf.mvc.models.ElfBaseUserModels;
import org.elf.mvc.models.entitys.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.collect.ImmutableBiMap;

@Path("/api/user")
@Controller
@Produces(MediaType.APPLICATION_JSON)
public class ElfBaseUserController {
	@Autowired
	ElfBaseUserModels ebum;

	@Autowired
	ElfBaseMechanismModels ebmm;
	
	@POST
	@Path("/login")
	public Response login(
			@FormParam("loginName") String loginName, 
			@FormParam("password") String password,
			@FormParam("equipmentId") long equipmentId
	) throws NoSuchAlgorithmException, ElfRunException {
		return Response.getSuccess(null,ImmutableBiMap.of("sessionCode",ebum.login(loginName, password, equipmentId)));
	}
	
	@POST
	@Path("/getMechanism")
	public Response getMechanism(
			 @FormParam("sessionCode") String sessionCode,
			 @FormParam("equipmentId") long equipmentId
			) {
	 	return Response.getSuccess(null,ebmm.getMechanismGroup(ebum.queryUserBySession(sessionCode,equipmentId).getUserId()));
	}
}
