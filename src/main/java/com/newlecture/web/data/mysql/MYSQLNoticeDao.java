package com.newlecture.web.data.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;

public class MYSQLNoticeDao implements NoticeDao {

	//close媛� �씠琉꾩�硫� �듃�젋�젥�뀡�씠 �씠誘� (�옄�룞�쑝濡� commit�씠 �맖)
	//connection�쓣 �븯怨� con.setAutoCommit(false)濡� �궡媛� �뿀�슜�븯湲� �쟾�뿉 �옄�룞�쑝濡� commit�븯吏�留� �븯怨�
	//留� �븘�옒 con.commit();�쑝濡� 而ㅻ컠�븯�뒗 諛⑸쾿�룄 �엳吏�留�
	//�슦由щ뒗 �븿�닔瑜� �뿬�윭媛쒕�� �떎�뻾�븯怨� �엳湲� �븣臾몄뿉
	//怨꾩냽 close瑜� �빐以섏빞 �븿
	
	
	//�슦由щ뒗 �씠�젣 �뒪�봽留곸쓣 �넻�빐�꽌 �듃�젋�젥�뀡�쓣 泥섎━�븷 寃껋엫
	
	
	@Override
	public List<NoticeView> getList() {
		
		return getList(1,"TITLE","");
	}

	@Override
	public List<NoticeView> getList(int page) {
		
		return getList(page,"TITLE","");
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) {
		String sql = "SELECT* FROM NOTICE_VIEW WHERE BINARY "+field+" LIKE ? limit ?,10";
	      
	      List<NoticeView> list = new ArrayList<>();
	      
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, "%"+query+"%");
	         st.setInt(2, 10*(page-1));
	         
	         ResultSet rs = st.executeQuery();
	         
	         NoticeView notice = null;
	         
	         while(rs.next()){
	            notice= new NoticeView();
	            notice.setCode(rs.getString("CODE"));
	            notice.setTitle(rs.getString("TITLE"));
	            notice.setContent(rs.getString("CONTENT"));
	            notice.setWriter(rs.getString("WRITER"));
	            notice.setRegDate(rs.getDate("REGDATE"));
	            notice.setHit(rs.getInt("HIT"));
	            //NoticeView 而щ읆
	            notice.setWriterName(rs.getString("WRITER_NAME"));
	            notice.setCommentCount(rs.getInt("COMMENT_COUNT"));
	            
	            list.add(notice);
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
	public int getSize() {
		
		return getSize("TITLE","");
	}

	@Override
	public int getSize(String field, String query) {
		String sql = "SELECT COUNT(CODE) SIZE FROM NOTICE WHERE BINARY "+field+" LIKE ?";
	      int size=0;
	     
	      
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, "%"+query+"%");
	      
	         
	         ResultSet rs = st.executeQuery();
	         if(rs.next())
	         size=rs.getInt("SIZE");
	         
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
	      return size;
	   }

	@Override
	public int add(Notice notice) {
		
		String codeSql= "select max(cast(code as unsigned))+1 Code from NOTICE";
	    String sql = "INSERT INTO NOTICE(CODE,TITLE,WRITER,CONTENT)VALUES(?,?,?,?)";
	         
	       int result=0;
	         
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	            Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	            Statement codeSt = con.createStatement();
	            ResultSet rs=codeSt.executeQuery(codeSql);
	            rs.next();
	            String code=rs.getString("CODE");
	            rs.close();
	            codeSt.close();
	            
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, code);
	            st.setString(2, notice.getTitle());
	            st.setString(3, notice.getWriter());
	            st.setString(4, notice.getContent());
	            
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

	@Override
	public int add(String title, String content, String writer) {
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		return add(notice);
	}

	@Override
	public NoticeView get(String code) {

		String sql = "SELECT * FROM NOTICE_VIEW WHERE CODE=?";
		
		NoticeView notice = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, code);
	         
	        ResultSet rs = st.executeQuery();

	        if(rs.next()){
	            notice= new NoticeView();
	            notice.setCode(rs.getString("CODE"));
	            notice.setTitle(rs.getString("TITLE"));
	            notice.setContent(rs.getString("CONTENT"));
	            notice.setWriter(rs.getString("WRITER"));
	            notice.setRegDate(rs.getDate("REGDATE"));
	            notice.setHit(rs.getInt("HIT"));
	            //NoticeView 而щ읆
	            notice.setWriterName(rs.getString("WRITER_NAME"));
	            notice.setCommentCount(rs.getInt("COMMENT_COUNT"));
	         }
	      
	         rs.close();
	         st.close();
	         con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return notice;
	}
	@Override
	   public NoticeView prev(String code) {
	      String sql = "SELECT * FROM NOTICE_VIEW WHERE CAST(CODE AS UNSIGNED) < CAST(? AS UNSIGNED)  ORDER BY REGDATE DESC LIMIT 0, 1";
	       
	      NoticeView notice = null;
	      Connection con = null;
	      PreparedStatement st = null;
	      ResultSet rs =null;
	      
	       try {
	          Class.forName("com.mysql.jdbc.Driver");
	          List<NoticeView> list=new ArrayList<>();
	        
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	          con = DriverManager.getConnection(url, "newlec", "sclass");
	          st = con.prepareStatement(sql);
	          st.setString(1, code);
	                    
	          rs = st.executeQuery();
	            
	          if(rs.next())
	          {
	             notice = new NoticeView();
	             notice.setCode(rs.getString("CODE"));
	             notice.setTitle(rs.getString("TITLE"));
	             notice.setContent(rs.getString("CONTENT"));
	             notice.setWriter(rs.getString("WRITER"));
	             notice.setRegDate(rs.getDate("REGDATE"));
	             notice.setHit(rs.getInt("HIT"));
	             list.add(notice); 
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
	         try {
	            rs.close();
	            st.close();
	            con.close();
	         } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	         }
	         
	      }
	   
	      return notice;
	   }

	   @Override
	   public NoticeView next(String code) {
	      String sql = "SELECT * FROM NOTICE_VIEW WHERE CAST(CODE AS UNSIGNED) > CAST(? AS UNSIGNED)  ORDER BY REGDATE ASC LIMIT 0, 1";
	       
	      NoticeView notice = null;
	      
	       try {
	          Class.forName("com.mysql.jdbc.Driver");
	          List<NoticeView> list=new ArrayList<>();
	        
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	          Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	          PreparedStatement st = con.prepareStatement(sql);
	          st.setString(1, code);
	                    
	          ResultSet rs = st.executeQuery();
	            
	          if(rs.next())
	          {
	             notice = new NoticeView();
	             notice.setCode(rs.getString("CODE"));
	             notice.setTitle(rs.getString("TITLE"));
	             notice.setContent(rs.getString("CONTENT"));
	             notice.setWriter(rs.getString("WRITER"));
	             notice.setRegDate(rs.getDate("REGDATE"));
	             notice.setHit(rs.getInt("HIT"));
	             list.add(notice); 
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
	   
	      return notice;

	   }

	@Override
	//�닔�젙�븯�뒗 dao
	public int update(Notice notice) {
		
		String sql = "UPDATE NOTICE SET TITLE=?,CONTENT=? WHERE CODE=?";
				
		int result=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getCode());

			result = st.executeUpdate();

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	//�궘�젣�븯�뒗 dao
	public int delete(String code) {
		
		String sql = "DELETE FROM NOTICE WHERE CODE=?";
		int result=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, code);

			result = st.executeUpdate();

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(String title, String content, String code) {
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setCode(code);
		
		return update(notice);
	}

	@Override
	public String lastcode() {
		String sql = "SELECT max(cast(code as unsigned)) CODE FROM NOTICE";
		String code="0";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next())
				code = rs.getString("CODE");

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
		return code;
	}
	
	
	
}
