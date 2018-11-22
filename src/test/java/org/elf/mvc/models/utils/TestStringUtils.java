package org.elf.mvc.models.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStringUtils {
	@Test
	public void testMd5() throws NoSuchAlgorithmException {
		var a = StringUtils.md5("123");
		var b = StringUtils.md5("123");
		var c = StringUtils.md5("1234");
		assertEquals(a, b);
		assertNotEquals(a, c);
	}
}
