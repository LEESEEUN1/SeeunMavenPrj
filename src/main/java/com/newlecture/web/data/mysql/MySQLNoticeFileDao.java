package com.newlecture.web.data.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.NoticeFileDao;
import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.entity.NoticeFile;

public class MySQLNoticeFileDao implements NoticeFileDao{

	@Override
	public List<NoticeFile> getList(String noticeCode) {
		String sql = "SELECT* FROM NOTICE_FILE WHERE NOTICE_CODE=?";

		List<NoticeFile> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, noticeCode);

			ResultSet rs = st.executeQuery();

			NoticeFile file = null;

			while (rs.next()) {
				file = new NoticeFile();
				file.setCode(rs.getString("CODE"));
				file.setNoticeCode(rs.getString("NOTICE_CODE"));
				file.setSrc(rs.getString("SRC"));
				list.add(file);
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int add(NoticeFile file) {

		return add(file.getSrc(),file.getNoticeCode());
	}

	@Override
	public int add(String src, String noticeCode) {
		String codeSql = "select IFNULL(max(cast(code as unsigned)),0)+1 CODE from NOTICE_FILE";
		String sql = "INSERT INTO NOTICE_FILE(CODE,SRC,NOTICE_CODE) VALUES(?,?,?)";

		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			Statement codeSt = con.createStatement();
			ResultSet rs = codeSt.executeQuery(codeSql);
			rs.next();
			String code = rs.getString("CODE");
			rs.close();
			codeSt.close();

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, code);
			st.setString(2, src);
			st.setString(3, noticeCode);


			result = st.executeUpdate();

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
