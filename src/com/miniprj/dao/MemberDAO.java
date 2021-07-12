package com.miniprj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.miniprj.dto.MemberDTO;




public class MemberDAO {

	
	ArrayList<MemberDTO> arr=new ArrayList<>();
	
	MemberDTO dto=new MemberDTO();

public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	// db 연결 메서드
	private Connection getConnection(){
		String className="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="hr";
		String pwd="hr";
	    Connection conn=null;
	    
		
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url,user,pwd);
		}catch(SQLException|ClassNotFoundException e) {
			System.out.println(e);
		}
		return conn;
	}
	
//insert메서드
	public int insert(String id, String pwd, String name, String email) {
		
		
		Connection conn=getConnection();
		
		PreparedStatement pstmt=null;
		
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into member(memberno,id,pwd,name,email)");
		sql.append(" values(memberseq.nextval,?,?,?,?)                 ");
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);

			
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(pstmt,conn);
		}
		return result;
	}

// delete 메서드
	
	public int delete(String id) {
		
		Connection conn=getConnection();
		
		PreparedStatement pstmt=null;
		
		StringBuilder sql=new StringBuilder();
		sql.append(" delete from member where id=?");
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(pstmt,conn);
		}
		return result;
	}
	
	
//update메서드 
	
	public int update(String id,String pwd,String email) {
		
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
	
		
		StringBuilder sql=new StringBuilder();
		int result=0;
		
		try{
			sql.append(" update member     ");
			sql.append(" set               ");
			sql.append("     pwd=?         ");
			sql.append("   , email=?       ");
            sql.append("where id=?         ");
			
			
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1,pwd);
			pstmt.setString(2,email);
			pstmt.setString(3,id);
			
			result=pstmt.executeUpdate();
	
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(pstmt,conn);
		}
		return result;
	}
// 조회기능
	
	public void selectOne(String id) {
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		StringBuilder sql=new StringBuilder();
		try {
		sql.append(" select                     ");
		sql.append("        memberno            ");
		sql.append("      ,id                   ");
		sql.append("      ,pwd                  ");
		sql.append("      ,name                 ");
		sql.append("      ,email                ");
		sql.append("      ,mdate                ");
		sql.append(" from  member               ");
		sql.append(" where id=?                 ");
		
		pstmt=conn.prepareStatement(sql.toString());
		pstmt.setString(1, id);
		
		rs=pstmt.executeQuery();
		while(rs.next()) {
			


			System.out.printf("%d\t %s\t %s\t %s\t %s\t %s\n",rs.getInt(1)
					                            ,rs.getString("id")
					                            ,rs.getString("pwd")
					                            ,rs.getString("name")
					                            ,rs.getString("email")
					                            ,rs.getDate("mdate"));
		}
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(pstmt,conn);
			if(rs!=null) try { rs.close();} catch(SQLException e) {}
		}
		return ;
	}
	
	
// select 기능 메서드
	public ArrayList<MemberDTO> getAll() {
		// db 연결해서 자료를 받아서 test로 넘겨줘야함
		// arraylist ( db 연결후에 arraylist 에 담아서 리턴)
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		StringBuilder sql=new StringBuilder();
		try {
		sql.append(" select                     ");
		sql.append("        memberno            ");
		sql.append("      ,id                   ");
		sql.append("      ,pwd                  ");
		sql.append("      ,name                 ");
		sql.append("      ,email                ");
		sql.append("      ,mdate                ");
		sql.append(" from  member               ");
		
		
		
		pstmt=conn.prepareStatement(sql.toString());
		rs=pstmt.executeQuery();
		while(rs.next()) {
			System.out.printf("%d\t\t %s\t %s\t %s\t %s\t %s\n",rs.getInt(1)
					                            ,rs.getString("id")
					                            ,rs.getString("pwd")
					                            ,rs.getString("name")
					                            ,rs.getString("email")
					                            ,rs.getDate("mdate"));
		}
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(pstmt,conn);
			if(rs!=null) try { rs.close();} catch(SQLException e) {}
		}
		return arr;
	}

	private void close(PreparedStatement pstmt,Connection conn) { //pstmt,conn close하는기능
		
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
		
	}
	
	public boolean cid(String id) {
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		StringBuilder sql=new StringBuilder();
		
		
		
		try {
			sql.append(" select   id                ");
			sql.append("    from member             ");
			sql.append("    where id=?              ");
		

			pstmt=conn.prepareStatement(sql.toString());
   		    pstmt.setString(1, id);

			rs=pstmt.executeQuery();
			
			if(rs.next())
				return true;
		
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(pstmt,conn);
		}
		return false;
	}
	

}

