package org.elf.config;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.elf.mvc.error.ElfRunException;

import com.alibaba.fastjson.JSON;

@Provider
public class ExceptionMappingResource  implements ExceptionMapper<Exception>{
	@Override
	public Response toResponse(Exception exception) {
		if(exception instanceof ElfRunException) {
			var data = org.elf.mvc.models.entitys.Response.getError((ElfRunException)exception);
			return Response.ok(JSON.toJSONString(data)).status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}else {
			var data = org.elf.mvc.models.entitys.Response.getError(exception.getMessage(),null );
			return Response.ok(JSON.toJSONString(data)).status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
