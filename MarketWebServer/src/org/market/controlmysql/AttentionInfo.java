package org.market.controlmysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.market.mysql.ConnectMysql;

public class AttentionInfo {
	
	Connection conn = null;
	public AttentionInfo(){
		super();
	}
	public int supply(String username){
		int count = 0;
		String sql = "SELECT COUNT(*) FROM tb_attention WHERE AOwner=?";
		conn = ConnectMysql.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			conn.setAutoCommit(true);
			stmt.close();
			rs.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("AttentionInfo.supply roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return count;
	}
	
	public int request(String username){
		int count = 0;
		String sql = "SELECT COUNT(*) FROM tb_attention WHERE ABuyer=?";
		conn = ConnectMysql.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			conn.setAutoCommit(true);
			stmt.close();
			rs.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("AttentionInfo.request roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return count;
	}
}
