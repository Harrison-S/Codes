package org.market.controlmysql;

import org.market.types.*;
import org.market.mysql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminInfo {
	
	Connection conn = null;
	public AdminInfo(){
		super();
	}
	//login
	public boolean login(AdminType admin){
		boolean flag  = false;
		String sql = "SELECT * FROM tb_admin AS A WHERE A.AID=? AND A.APassword=?";
		conn = ConnectMysql.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, admin.getName());
			stmt.setString(2, admin.getPassword());
			rs = stmt.executeQuery();
			while(rs.next()){
				flag = true;
			}
			conn.setAutoCommit(true);
			stmt.close();
			rs.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.login roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}
}
