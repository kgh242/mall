package cafe.jjdev.mall.service;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

public class MemberDao {
	//DB연결
	private Connection getConnection() throws NamingException, SQLException {
		Connection conn = null;
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mall");
		conn = ds.getConnection();
		return conn;
	}
	//DB연결종료
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
            try {rs.close();} catch(Exception e){e.printStackTrace();}
        }
        if(pstmt != null) {
            try {pstmt.close();} catch(Exception e){e.printStackTrace();}
        }
        if(conn != null) {
            try {conn.close();} catch(Exception e){e.printStackTrace();}
        }
    }
	//회원가입 
	public int insertMember(Member member){
		System.out.println("Dao 회원가입 실행");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO member(id,pw,level) VALUES(?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setInt(3, member.getLevel());
			
			System.out.println(member.getId());
			System.out.println(member.getPw());
			System.out.println(member.getLevel());
			row = pstmt.executeUpdate();
		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		finally {
 			this.close(conn,pstmt,rs);
 			}
		return row;
	}
	//로그인 처리
	public boolean loginMember(Member member) {
		System.out.println("Dao 로그인체크");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isLogin = false;
		
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement("SELECT id, level From member WHERE id=? and pw=?");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				isLogin = true;	//SELECT가 있을때 true
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return isLogin;
	}
	
}
	
