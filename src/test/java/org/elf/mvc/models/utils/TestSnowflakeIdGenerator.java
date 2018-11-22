package org.elf.mvc.models.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSnowflakeIdGenerator {
	@Autowired SnowflakeIdGenerator sig ;
	@Test
	public void testNextId() {
		System.out.println(sig.nextId());
	}
}
