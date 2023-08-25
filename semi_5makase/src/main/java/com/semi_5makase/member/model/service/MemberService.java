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
}
