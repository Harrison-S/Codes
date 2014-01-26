package org.market.matching;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.market.mysql.ConnectMysql;
import org.market.types.GoodsType;

//构造邻接矩阵的步骤
//取用户数和标签数，构造初始化的邻接矩阵
public class Adjacency_Matrix {
	public static int[][] matrix;
	private int num_of_users;
	private int num_of_labels;
	private Connection conn = null;
	private ResultSet rs = null;
	private ArrayList<String>[] label_own;
	private ArrayList<String>[] label_want;
	public Adjacency_Matrix()
	{
		String sql="select * from tb_label";
		conn = ConnectMysql.connect();
		Statement stmt = null;
		//ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int i=0;
			
			while(rs.next()){
				i++;
			}
			num_of_labels=i;
			sql="select * from tb_customer";
			rs = stmt.executeQuery(sql);
			i=0;
			
			while(rs.next()){
				i++;
			}
			num_of_users=i;
			sql="select * from tb_goods";
			rs = stmt.executeQuery(sql);
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
//		for(int j=0;j<(num_of_users+num_of_labels);j++)
//		{
//			label_own[j]=new ArrayList<String>();
//			label_want[j]=new ArrayList<String>();
//		}
		matrix=new int[num_of_users+num_of_labels][num_of_users+num_of_labels];
		for(int j=0;j<(num_of_users+num_of_labels);j++)
		{
			for(int k=0;k<(num_of_users+num_of_labels);k++)
			{
				matrix[j][k]=0;
			}
		}
		initialize_ownarray();
		initialize_wantarray();
		for(int j=0;j<(num_of_users+num_of_labels);j++)
		{
			for(int k=0;k<(num_of_users+num_of_labels);k++)
			{
				System.out.print(matrix[j][k]+" ");
			}
			System.out.println("");
		}
	}
	private void initialize_ownarray()
	{
		int index1=-1;
		int index2=-1;
		String sql="select * from tb_goods where Gproperty=0";
		conn = ConnectMysql.connect();
		Statement stmt = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				index1=rs.getInt(3);
				System.out.println("---"+index1);
				index2=rs.getInt(10);
				System.out.println("---"+(index2));
				matrix[index2+num_of_users][index1]=1;
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
	}
	private void initialize_wantarray()
	{
		int index1=-1;
		int index2=-1;
		String sql="select * from tb_goods where Gproperty=1";
		conn = ConnectMysql.connect();
		Statement stmt = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				index1=rs.getInt(3);
				System.out.println("---"+index1);
				index2=rs.getInt(10);
				System.out.println("---"+(index2+num_of_users));
				matrix[index1][index2+num_of_users]=1;
			}
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
				System.out.println("roll back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
	}
	public static void main(String[] args)
	{
		new Adjacency_Matrix();
	}
	public int get_scale()
	{
		return (this.num_of_labels+this.num_of_users);
	}
}
