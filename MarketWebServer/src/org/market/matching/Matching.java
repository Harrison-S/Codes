package org.market.matching;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import org.market.mysql.ConnectMysql;

public class Matching {
	private Adjacency_Matrix Amatrix=new Adjacency_Matrix();
	private int n;  
    private int[] visited;//节点状态,值为0的是未访问的  
    private int[][] e;//有向图的邻接矩阵  
    private static ArrayList<Integer> trace=new ArrayList<Integer>();//从出发节点到当前节点的轨迹  
    private static ArrayList<ArrayList<Integer>> all_trace=new ArrayList<ArrayList<Integer>>();
    private boolean hasCycle=false;  
    private Connection conn = null;
	private ResultSet rs = null;
	private String content="您和这些用户匹配成功 ： ";
    public Matching(){  
        this.n=Amatrix.get_scale();  
        visited=new int[n];  
        Arrays.fill(visited,0);  
        this.e=Amatrix.matrix;  
    }      
    void findCycle(int v)   //递归DFS  
   {  
       if(visited[v]==1)  
       {  
           int j;  
           if((j=trace.indexOf(v))!=-1)  
           {  
               hasCycle=true;  
               for(int q=0;q<trace.size();q++)
   				{
   					for(int k=0;k<trace.size();k++)
   					{
   						System.out.println("&&&&&&&&&&&&"+trace.size());
   						if(k!=q)
   						{
   							if(getun_viauno(trace.indexOf(k)).equals("*"))
   							{}
   							else
   							{
   								content+=getun_viauno(trace.indexOf(k));
   								content+=" , ";
   							}
   						}
   					}
   					SendResult send=new SendResult();
   					send.send_tosig(86400,q,"物物匹配成功",content);
   					System.out.println(content);
   					content="您和这些用户匹配成功 ： ";
   				}
               System.out.println(trace);  
               System.out.println(all_trace); 
               System.out.print("Cycle:");  
               while(j<trace.size())  
               {  
                   System.out.print(trace.get(j)+" ");  
                   j++;  
               }  
               System.out.print("\n");  
               return;  
           }  
           return;  
       }  
       visited[v]=1;  
       trace.add(v);  
         
       for(int i=0;i<n;i++)  
       {  
           if(e[v][i]==1)  
               findCycle(i);  
       }  
       trace.remove(trace.size()-1);  
   }  
   
    public boolean getHasCycle(){  
    	return hasCycle;  
    }  
//    public void deal_with_traces()
//    {
//    	ArrayList temp;
//    	int length1=all_trace.size();
//    	int length2=0;
//    	for(int i=0;i<length1;i++)
//    	{
//    		temp=all_trace.get(i);
//    		length2=temp.size();
//    		for(int j=0;j<length2;j++)
//    		{
//    			
//    		}
//    	}
//    }
    public String getun_viauno(int userno)
    {
    	String temp="*";
    	String sql="select CID from tb_customer where CNO="+userno;
		conn = ConnectMysql.connect();
		Statement stmt = null;
		//ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
			temp=rs.getString(1);}
			System.out.println(temp);
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
		return temp;
    }
    public static void main(String[] args) {  
    	int n=7;  
    	Matching tc=new Matching();  
    	tc.findCycle(0);  
    	if(!tc.hasCycle)   
    		System.out.println("No Cycle.");  
    }  
    public ArrayList<ArrayList<Integer>> getalltraces()
    {
    	return this.all_trace;
    }
}
