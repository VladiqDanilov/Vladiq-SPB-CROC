package ru.croc.task17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

public class Task17 {
	public static void main(String[] args) throws FileNotFoundException, SQLException {
		//String file="T:\\Vladiq\\Documents\\Data_Task17.txt";
		/*
		 * Считывание пути к файлу
		 * и Подготовка к заполнению таблиц SQL
		 */
		String file=args[0];
		TablesEditor t1= new TablesEditor();
		t1.doTables();
		String delimiter = ",";
		String line;
		String sqLreq1 = "INSERT INTO order_items (id, order_id, product_id) Values (?, ?, ?)";
		String sqLreq2 = "INSERT INTO product (name, price) Values (?, ?)";
		String sqLreq3 = "INSERT INTO users (id, login) Values (?, ?)";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			Connection cur= DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "");{
				//чтение с файла	
			while ((line = br.readLine()) != null) {
				int randID = randNum();
				List<String> values = Arrays.asList(line.split(delimiter));
				PreparedStatement preparedStatement1 =(cur).prepareStatement(sqLreq1);
				PreparedStatement preparedStatement2 =(cur).prepareStatement(sqLreq2);
				PreparedStatement preparedStatement3=(cur).prepareStatement(sqLreq3);
				//использование выражений для запросов
				preparedStatement1.setInt(1, randID);
				preparedStatement1.setInt(2, Integer.parseInt(values.get(0)));
				preparedStatement1.setString(3, values.get(2));
				preparedStatement1.executeUpdate();
				preparedStatement2.setString(1, values.get(3));
				preparedStatement2.setInt(2, Integer.parseInt(values.get(4)));
				preparedStatement2.executeUpdate();
				preparedStatement3.setInt(1, randID);
				preparedStatement3.setString(2, values.get(1));
				preparedStatement3.executeUpdate();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		//проверка
		Connection connecrion= DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "");
		Statement con= connecrion.createStatement();
		ResultSet ResLogin=con.executeQuery("SELECT login FROM users");
		while (ResLogin.next()) {
			System.out.println(ResLogin.getString("login"));
		}
		con.close();
		//
	}
//для создания идентификатора
	public static int randNum()
	{
		return (int) (Math.random() * 5000);
	}
}
