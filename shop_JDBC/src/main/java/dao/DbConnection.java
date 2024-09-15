package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConnection {

	/*public static EntityManager getDb()
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("shop");
		
		EntityManager em=emf.createEntityManager();
		
		return em;
	}*/
	
	public static void main(String[] args) {
		System.out.println(DbConnection.getDb());
	}
	
	public static Connection getDb() {
		String url="jdbc:mysql://localhost:3306/shop";
		String user="root";
		String password="root";
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no Connection");
			e.printStackTrace();
		}
		return conn;
	}

}	
		
	