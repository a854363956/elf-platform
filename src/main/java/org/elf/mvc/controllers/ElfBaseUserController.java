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
	
	/**
	 *   登入系统
	 * @param loginName 登入名称
	 * @param password  用户密码
	 * @param equipmentId  设备ID
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws ElfRunException
	 */
	@POST
	@Path("/login")
	public Response login(
			@FormParam("loginName") String loginName, 
			@FormParam("password") String password,
			@FormParam("equipmentId") Long equipmentId
	) throws NoSuchAlgorithmException, ElfRunException {
		return Response.getSuccess(null,ImmutableBiMap.of("sessionCode",ebum.login(loginName, password, equipmentId)));
	}
	
	/**
	 *   获取当前人员可以访问的机构信息
	 * @param sessionCode 当前的会话ID
	 * @param equipmentId 当前的设备类型
	 * @return
	 */
	@POST
	@Path("/getMechanism")
	public Response getMechanism(
			 @FormParam("sessionCode") String sessionCode
			) {
	 	return Response.getSuccess(null,ebmm.getMechanismGroup(ebum.queryUserBySession(sessionCode).getUserId()));
	}
	
	/**
	 * 更新当前用户的密码
	 * @param sessionCode 当前的会话ID
	 * @param password    当前用户的密码
	 * @param newPassword 要更新的新密码
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NoSuchAlgorithmException
	 * @throws ElfRunException
	 */
	@POST
	@Path("/updatePassword")
	public Response updatePassword(
			@FormParam("sessionCode") String sessionCode,
			@FormParam("password") String password,
			@FormParam("newPassword") String newPassword
			) throws IllegalArgumentException, NoSuchAlgorithmException, ElfRunException {
		return Response.getSuccess(null, ImmutableBiMap.of("affectedLine",ebum.updatePassword(sessionCode, password, newPassword)));
	}
}
