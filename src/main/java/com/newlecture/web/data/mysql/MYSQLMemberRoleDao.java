package com.newlecture.web.data.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.data.dao.MemberRoleDao;
import com.newlecture.web.data.entity.Member;
import com.newlecture.web.data.entity.MemberRole;

public class MYSQLMemberRoleDao implements MemberRoleDao{

	@Override
	public String getDefaultRoleById(String memberId) {
		String sql="SELECT ROLE_ID FROM MEMBER_ROLE WHERE MEMBER_ID=? AND DEFAULT_ROLE=1";
		
		String defaultRole="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberId);

			ResultSet rs = st.executeQuery();

			if (rs.next())
				defaultRole=rs.getString("ROLE_ID");

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return defaultRole;
	}

	@Override
	public List<MemberRole> getRolesOfMember(String memberId) {
		
		return null;
	}

	@Override
	public List<MemberRole> getList() {
		
		return null;
	}

	@Override
	public int add(MemberRole memberRole) {
		
		return 0;
	}

	@Override
	public int delete(MemberRole memberRole) {
		
		return 0;
	}

	@Override
	public int update(MemberRole memberRole) {
		
		return 0;
	}

}
