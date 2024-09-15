package dao;

import org.junit.Test;

public class DbConnectionTest {
	@Test
	public void getDbTest()
	{
		
		System.out.println(DbConnection.getDb());
		System.out.println("success");
	}

}
