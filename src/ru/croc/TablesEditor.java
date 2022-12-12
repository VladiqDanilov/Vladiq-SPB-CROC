package ru.croc.task17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesEditor {
	
	public static void doTables() {
		try {
			Connection connecrion= DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "");
			Statement cur= connecrion.createStatement();{
				cur.executeUpdate("CREATE TABLE order_items("
						+"id INT UNIQUE,"
						+"order_id INT," 
						+"product_id  VARCHAR(30))");
				cur.executeUpdate("CREATE TABLE product("
						+ "id INT REFERENCES order_items(id),"
						+ "name VARCHAR(30),"
						+ "price INT)");
				cur.executeUpdate("CREATE TABLE users("
						+ "id VARCHAR(30) PRIMARY KEY REFERENCES order_items(id),"
						+"login VARCHAR(30))");
			}
			//созданные таблицы в локал
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

