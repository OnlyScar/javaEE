package excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

	public static void insert(String sql, Student student) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL,Common.USERNAME,Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getNo());
			ps.setString(2, student.getName());
			ps.setString(3, student.getAge());
			ps.setString(4, String.valueOf(student.getScore()));
			boolean flag = ps.execute();
			if (!flag) {
				System.out.println("save data: NO.="+student.getNo());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (ps!=null) {
				ps.close();
			}
			if (conn!=null) {
				conn.close();
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List selectOne(String sql, Student student) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL,Common.USERNAME,Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString("no").equals(student.getNo())||rs.getString("name").equals(student.getName())||rs.getString("age").equals(student.getAge())) {
					list.add(1);
				}else{
					list.add(0);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (ps!=null) {
				ps.close();
			}
			if (conn!=null) {
				conn.close();
			}
		}
		
		return list;
	}

	public static ResultSet selectAll(String sql) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL,Common.USERNAME,Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (ps!=null) {
				ps.close();
			}
			if (conn!=null) {
				conn.close();
			}
		}	
		return rs;			
	}
	
	
}
