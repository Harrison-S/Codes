package org.market.mysql;

import java.sql.Connection;
import java.sql.SQLException;

public class CloseMysql {
	public static void close(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
