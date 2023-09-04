package com.semi_5makase.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import com.semi_5makase.member.model.vo.Member;
import com.semi_5makase.member.model.vo.Report;

import static com.semi_5makase.common.JDBCTemplate.*;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		String filePath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Member> selectAdminMemberList(Connection conn){
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdminMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("mem_no"),
									rset.getString("mem_grade"),
									rset.getString("mem_name"),
									rset.getString("gender"),
									rset.getString("phone"),
									rset.getString("address"),
									rset.getString("status")
									));
			}
			
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public Member loginMember(Connection conn, String memId, String memPwd) {
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt =  conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			pstmt.setString(2, memPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("mem_no"),
						rset.getString("mem_grade"),
						rset.getString("mem_id"),
						rset.getString("mem_pwd"),
						rset.getString("mem_name"),
						rset.getString("gender"),
						rset.getInt("age"),
						rset.getString("nickname"),
						rset.getString("email"),
						rset.getString("phone"),
						rset.getString("address"),
						rset.getDate("enroll_date"),
						rset.getString("status"),
						rset.getString("quitreason")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return m;
		
		
	}
	public Member selectAdminMember(Connection conn, int no) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdminMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("mem_no"),
								rset.getString("mem_name"),
								rset.getString("mem_id"),
								rset.getString("mem_pwd"),
								rset.getString("phone"),
								rset.getString("address"),
								rset.getString("email"),
								rset.getString("mem_grade"),
								rset.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}
	
	public int updateAdminMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAdminMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getAddress());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getMemGrade());
			pstmt.setString(5, m.getStatus());
			pstmt.setInt(6, m.getMemNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteAdminMember(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteAdminMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Report> adminSelectReportList(Connection conn){
		
		ArrayList<Report> list = new ArrayList<Report>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminSelectReportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Report(rset.getInt("report_no"),
									rset.getString("reporter"),
									rset.getString("suspect"),
									rset.getString("report_content"),
									rset.getDate("report_date"),
									rset.getString("result")
									));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public Report adminSelectReportDetail(Connection conn, int reportNo) {
		Report rep = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectReportDetailList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reportNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rep = new Report(rset.getInt("report_no"),
									rset.getString("reporter"),
									rset.getString("suspect"),
									rset.getString("report_content"),
									rset.getDate("report_date"),
									rset.getString("result")
									);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rep;
	}
	
	public int adminUpdaterReport(Connection conn, Report rep) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminUpdaterReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rep.getResult());
			pstmt.setInt(2, rep.getReportNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int selectListCount(Connection conn) {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public int selectReportListCount(Connection conn) {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
}














