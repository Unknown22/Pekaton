package database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	private static Connection connection = null;

	public static Connection getConnection() {
		System.out.println("DB connection checking");
		if (connection != null)
			return connection;

		else {
			System.out.println("DB connection creating");
			try {
				System.out.println("DB properties loading");

				Properties prop = new Properties();
				InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");

				prop.load(inputStream);

				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("Connected to DB");

			} catch (ClassNotFoundException e) {
				System.err.println("Connection to DB error");
				e.printStackTrace();
				return connection;
			} catch (SQLException e) {
				System.err.println("Connection to DB error");
				e.printStackTrace();
				return connection;

			} catch (FileNotFoundException e) {
				System.err.println("Connection to DB error: file not found");

				e.printStackTrace();
				return connection;

			} catch (IOException e) {
				System.err.println("Connection to DB error");
				e.printStackTrace();
				return connection;

			}
			return connection;
		}

	}

}
