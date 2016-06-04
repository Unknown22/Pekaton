package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import database.DbUtil;

public class DBTest {
	
	@Test
	public void test() {

		DbUtil db = new DbUtil();
		assertNotNull(db.getConnection());

	}


}
