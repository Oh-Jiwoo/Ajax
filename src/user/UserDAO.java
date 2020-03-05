package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/ajax";
			String dbID = "root";
			String dbPWD = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, dbID, dbPWD);
		} catch (Exception e) {
			System.out.println("UserDAO err : "+e);
		}
	}
	
	public ArrayList<user> search(String userName) {
		String SQL = "SELECT * FROM user WHERE userName LIKE ?";
		ArrayList<user> userList = new ArrayList<user>();
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, "%"+ userName + "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				user user = new user();
				user.setUserName(rs.getString(1));
				user.setUserAge(rs.getInt(2));
				user.setUserGender(rs.getString(3));
				user.setUserEmail(rs.getString(4));
				userList.add(user);
			}
			
		} catch (Exception e) {
			System.out.println("search err : "+e);
		}
		
		return userList;
	}
	
	public int register(user user) {
	
		String SQL = "INSERT INTO user VALUES(?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, user.getUserName());
			pstmt.setInt(2, user.getUserAge());
			pstmt.setString(3, user.getUserGender());
			pstmt.setString(4, user.getUserEmail());
			
			return pstmt.executeUpdate(); //성공했을때 1을 반환
			
		} catch (Exception e) {
			System.out.println("register err: " + e);
		}
		return -1; //데이터베이스 오류
	}
}
