package org.elf.mvc.models;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.elf.mvc.error.ElfRunException;
import org.elf.mvc.models.entitys.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestElfBaseUserController {
	@Autowired ElfBaseUserModels ebum;
	
	/**
	 * 测试用户是否能够成功登入
	 * @throws ElfRunException
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testLogin() throws ElfRunException, NoSuchAlgorithmException {
		String userName = "root";
		String password = "123";
		long equipmentId=0;
		Response response = Response.getSuccess(null, ebum.login(userName, password, equipmentId));
		assertEquals(response.getStatus(), 200);
		System.out.println(JSON.toJSONString(response));
	}
}
