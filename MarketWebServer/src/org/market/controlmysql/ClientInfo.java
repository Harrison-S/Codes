package org.market.controlmysql;

import org.market.mysql.*;
import org.market.types.*;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientInfo {

	private Connection conn = null;
	
	public ClientInfo(){
		super();
	}
	public boolean login(ClientType client){
		boolean flag  = false;
		String sql = "SELECT * FROM tb_customer AS C WHERE C.CID=? AND C.CPassword=?";
		conn = ConnectMysql.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getPassword());
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
	public boolean findClient(String username){
		boolean flag  = false;
		String sql = "SELECT * FROM tb_customer WHERE CID=?";
		conn = ConnectMysql.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
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
				System.out.println("ClientInfo.findClient roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}
	//register client
	public boolean addClient(ClientType client){
		boolean flag  = false;
		String sql = "INSERT INTO tb_customer(CID,CPassword,CGender,CStuNO,CPhone,CEmail,CDate) " +
				"VALUES (?,?,?,?,?,?,?)";
		conn = ConnectMysql.connect();
		PreparedStatement pstmt = null;
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(0, clientTemp.getCNO());
			pstmt.setString(1, client.getName());
			pstmt.setString(2, client.getPassword());
			pstmt.setInt(3, client.getGender());
			pstmt.setString(4, client.getStuNO());
			pstmt.setString(5, client.getPhone());
			pstmt.setString(6, client.getEmail());
			pstmt.setString(7, client.getDate());
			if(pstmt.executeUpdate() > 0){
				flag = true;
			}
			conn.setAutoCommit(true);
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.addClient roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return flag;
	}
	public boolean modifyClient(ClientType client){
		boolean flag  = false;
		String sql = "UPDATE tb_customer SET CPassword=?,CGender=?,CStuNO=?,CPhone=? WHERE CID = ?";
		conn = ConnectMysql.connect();
		PreparedStatement pstmt = null;
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, client.getPassword());
			pstmt.setInt(2, client.getGender());
			pstmt.setString(3, client.getStuNO());
			pstmt.setString(4, client.getPhone());
			pstmt.setString(5, client.getName());
			if(pstmt.executeUpdate() > 0){
				flag = true;
			}
			conn.setAutoCommit(true);
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.modifyClient roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return flag;
	}
	public boolean deleteClient(String username){
		boolean flag  = false;
		String sql = "DELETE FROM tb_customer WHERE CID = ?";
		conn = ConnectMysql.connect();
		PreparedStatement stmt = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			if(stmt.executeUpdate()> 0){
				flag = true;
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.deleteClient roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}
	//client number
	public int clientNum(){
		int count=-1;
		conn = ConnectMysql.connect();
		String sql = "SELECT COUNT(*) FROM tb_customer";
		try{
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				count = rs.getInt(1) ;
			}
			conn.setAutoCommit(true);
			stmt.close() ;
			rs.close() ;
			conn.close();
		}catch(Exception e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.clientNum roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return count;
	}
	//view individual information by user name
	public ClientType viewIndividualInfo(String usr){
		ClientType client = new ClientType();
		String sql = "SELECT * FROM tb_customer WHERE CID = ?";
		conn = ConnectMysql.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usr);
			rs = stmt.executeQuery();
			if(rs.next()){
				int CNO = rs.getInt(1);
				System.out.println("Find the customer NO:"+CNO);
				client.setName(rs.getString(2));
				client.setPassword(rs.getString(3));
				client.setGender(rs.getInt(4));
				client.setStuNO(rs.getString(5));
				client.setPhone(rs.getString(6));
				client.setEmail(rs.getString(7));
				client.setDate(rs.getString(8));
			}
			conn.setAutoCommit(true);
			stmt.close();
			rs.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.viewIndividualInfo roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return client;
	}

	//all client information
	public ArrayList<ClientType> allClient(){
		ArrayList<ClientType> list = new ArrayList<ClientType>();
		String sql = "SELECT * FROM tb_customer";
		conn = ConnectMysql.connect();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int i = 1;
				ClientType temp = new ClientType();
				temp.setCNO(rs.getInt(i++));
				temp.setName(rs.getString(i++));
				temp.setPassword(rs.getString(i++));
				temp.setGender(rs.getInt(i++));
				temp.setStuNO(rs.getString(i++));
				temp.setPhone(rs.getString(i++));
				temp.setEmail(rs.getString(i++));
				temp.setDate(rs.getString(i++));
				list.add(temp);
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("ClientInfo.alterIndividualInfo roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
		return list;
	}
}
