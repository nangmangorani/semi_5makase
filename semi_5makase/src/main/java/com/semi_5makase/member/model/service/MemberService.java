package com.semi_5makase.member.model.service;

import static com.semi_5makase.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi_5makase.member.model.dao.MemberDao;
import com.semi_5makase.member.model.vo.Attachment;
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


			
	public Member emailcheckOne(String email) {
		Connection conn = getConnection();
		Member m  = new MemberDao().emailcheckOne(conn ,email);
		close(conn);
		return m;
	}
	
	public Member emailcheck(String memId) {
		Connection conn = getConnection();
		Member m  = new MemberDao().emailcheck(conn ,memId);
		close(conn);
		return m;
	}
	
	
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result  = new MemberDao().insertMember(conn, m);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public int idCheck(String checkId) {
		Connection conn = getConnection();
		int count = new MemberDao().idCheck(conn, checkId);
		
		close(conn);
		return count;
	}
	
	public Member updateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(conn, m);
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, m.getMemId());
		}else { // 실패
			rollback(conn);
		}
		close(conn);
		
		return updateMem;
	}
	
	
	public Member updatePwd(String memId, String memPwd, String updatePwd) {
		Connection conn = getConnection();
		int result = new MemberDao().updatePwd(conn, memId, memPwd, updatePwd);
		
		Member updateMem = null;
		
		if(result > 0 ) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, memId);
		}else {
			rollback(conn);
		}
		close(conn);
		return updateMem;
		
	}
	
	public int memDelete(String memId, String memPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().memDelete(conn, memId, memPwd);
		
		if(result > 0) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
		
	public int deleteReason(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteReason(conn,m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
		
		
	}
	
	
	public int insertProfile(Attachment at, int memNo) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertProfile(conn, at,memNo);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
		
	}
	
	
	public int updateProfile(Attachment at, int memNo) {
		Connection conn = getConnection();
		
		int result = 0;
		
		if(at != null) {
			if(at.getFileNo() != 0) {
				result = new MemberDao().updateProfile(conn,at, memNo);
			}else {
				result = new MemberDao().insertProfile(conn, at, memNo);
			}
			
		}
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
		
		
	}
	
	public Attachment selectAttachment(int memNo) {
		Connection conn = getConnection();
		System.out.println(memNo);
		Attachment pf = new MemberDao().selectAttachment(conn, memNo);
		System.out.println(pf+"서비스");
		
		close(conn);
		return pf;
	}
	

	public Member selectId(String email) {
		Connection conn = getConnection();
		Member m = new MemberDao().selectId(conn, email);
		
		close(conn);
		
		return m;
		
	}
	
	public Member resetPwd(String memId,String memPwd, String newPwd,String checkPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().resetPwd(conn, memId, memPwd, newPwd, checkPwd);
		
		Member resetPwd = null;
		
		if(result > 0 ) {
			commit(conn);
			resetPwd = new MemberDao().selectMember(conn, memId);
		}else {
			rollback(conn);
		}
		close(conn);
		return resetPwd;
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
