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
	public void insertMember(Member member){
		System.out.println("Dao 회원가입 실행");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO member(id,pw,level) VALUES(?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setInt(3, 0);
			
			System.out.println(member.getId());
			System.out.println(member.getPw());
			pstmt.executeUpdate();
		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		finally {
 			this.close(conn,pstmt,rs);
 			}
	}
	//로그인
	public void login(Member member) {
		
	}
}
	
