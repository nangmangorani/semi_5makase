package com.semi_5makase.member.model.service;

import static com.semi_5makase.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi_5makase.member.model.dao.MemberDao;
import com.semi_5makase.member.model.vo.Member;

public class MemberService {
	
	public ArrayList<Member> selectAdminMemberList() {
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectAdminMemberList(conn);
		
		close(conn);
		
		return list;
		
	}
	public Member loginMember(String memId, String memPwd) {
		Connection conn = getConnection();
		
		Member m = new MemberDao().loginMember(conn, memId, memPwd);
		
		close(conn);
		return m;
		
	}
	
	public Member selectAdminMember(int no) {
		Connection conn = getConnection();
		
		Member m = new MemberDao().selectAdminMember(conn, no);
		
		close(conn);
		
		return m;
	}
	
	public int updateAdminMember(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateAdminMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteAdminMember(int no) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteAdminMember(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
