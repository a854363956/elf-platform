package org.elf.mvc.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestElfBaseMechanismModels {
	
	@Autowired ElfBaseMechanismModels ebmm;
	
	@Test
	public void testGetMechanismGroup() {
		var data = ebmm.getMechanismGroup(0);
		assertNotEquals(data.size(), 0);
		System.out.println(JSON.toJSONString(data));
	}
}
