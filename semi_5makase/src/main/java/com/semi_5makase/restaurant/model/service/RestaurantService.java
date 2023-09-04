package com.semi_5makase.restaurant.model.service;

import static com.semi_5makase.common.JDBCTemplate.*;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;

import javax.websocket.CloseReason.CloseCode;

import com.semi_5makase.common.model.vo.PageInfo;
import com.semi_5makase.restaurant.model.dao.RestaurantDao;
import com.semi_5makase.restaurant.model.vo.AdminRequestRestaurant;
import com.semi_5makase.restaurant.model.vo.AdminRestaurant;
import com.semi_5makase.restaurant.model.vo.AdminUpdateRestaurant;
import com.semi_5makase.restaurant.model.vo.Attachment;
import com.semi_5makase.restaurant.model.vo.Category;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.Restaurant;
import com.semi_5makase.restaurant.model.vo.TV;
import com.semi_5makase.restaurant.model.vo.Time;

public class RestaurantService {
	
	public Restaurant selectRestaurantDetail(int restNo) {
		
		Connection conn = getConnection(); 
		
		// 음식점번호, 이름, 주소, 전화번호, 주차, 소개, 메뉴, 조회수, 영업시간 조회
		Restaurant rest = new RestaurantDao().selectRestaurantDetail(restNo, conn);
		
		close(conn);
		return rest;
	}
	

	
	public int selectFavoriteCount(int restNo) {
		
		Connection conn = getConnection(); 
		
		int favor = new RestaurantDao().selectFavoriteCount(restNo, conn);
		
		close(conn);
		return favor;
	}
	
	public int selectReviewCount(int restNo) {
		
		Connection conn = getConnection(); 
		
		int review = new RestaurantDao().selectReviewCount(restNo, conn);
		
		close(conn);
		return review;
	}
	
	public double selectReviewRatingAvg(int restNo) {
		
		Connection conn = getConnection(); 
		
		double avg = new RestaurantDao().selectReviewRatingAvg(restNo, conn);
		
		close(conn);
		return avg;
	}
	
	public ArrayList<AdminRestaurant> adminSelectRestList() {
		
		Connection conn = getConnection();
		
		ArrayList<AdminRestaurant> list = new RestaurantDao().adminSelectRestList(conn);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<AdminRestaurant> adminSelectRestList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<AdminRestaurant> list = new RestaurantDao().adminSelectRestList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Category> adminSelectCategory() {
		
		Connection conn = getConnection();
		
		ArrayList<Category> clist = new RestaurantDao().adminSelectCategory(conn);
		
		close(conn);
		
		return clist;
	}
	
	public ArrayList<TV> adminSelectTv() {
		
		Connection conn = getConnection();
		
		ArrayList<TV> tlist = new RestaurantDao().adminSelectTv(conn);
		
		close(conn);
		
		return tlist;
	}
	
	public ArrayList<Attachment> adminSelectAttatchment(int restNo){
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new RestaurantDao().adminSelectAttatchment(conn, restNo);
		
		close(conn);
		
		return list;
		
	}
	
	public AdminRestaurant adminSelectRestaurant(int restNo) {
		
		Connection conn = getConnection();
		
		AdminRestaurant ar = new RestaurantDao().adminSelectRestaurant(conn, restNo);
		
		close(conn);
		
		return ar;
	}
	
	public ArrayList<Menu> adminSelectRestaurantMenu(int restNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Menu> list = new RestaurantDao().adminSelectRestaurantMenu(conn, restNo);
		
		close(conn);
		
		return list;
	}
	
	
	public ArrayList<AdminRequestRestaurant> adminSelectRestRequest(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<AdminRequestRestaurant> list = new RestaurantDao().adminSelectRestRequest(conn, pi);
		
		close(conn);
		
		return list;
		
	}
	
	public ArrayList<AdminUpdateRestaurant> adminSelectRestChange(PageInfo pi) {
			
			Connection conn = getConnection();
			
			ArrayList<AdminUpdateRestaurant> list = new RestaurantDao().adminSelectRestChange(conn, pi);
			
			close(conn);
			
			return list;
		}
	
	public int adminInsertRestaurant(AdminRestaurant ar, Menu m1, Menu m2, Menu m3, Time t, ArrayList<Attachment> list) {
		
		Connection conn = getConnection();
		
		int result1 = new RestaurantDao().adminInsertRestaurant(conn, ar);
		int result2 = new RestaurantDao().adminInsertAttachment(conn, list);
		int result3 = new RestaurantDao().adminInsertMenu1(conn, m1);
		int result4 = new RestaurantDao().adminInsertMenu2(conn, m2);
		int result5 = new RestaurantDao().adminInsertMenu3(conn, m3);
		int result6 = new RestaurantDao().adminInsertTime(conn, t);
		
		if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result6 > 0 && result6 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2 * result3 * result4 * result5 * result6;
		
	}
	
	public int adminUpdateRestaurant(AdminRestaurant ar, ArrayList<Attachment> list) {
		
		Connection conn = getConnection();
		
		int result1 = new RestaurantDao().adminUpdateRestaurant(conn, ar);
		int result2 = 1;
		
		if(!list.isEmpty()) {
			
			result2 = new RestaurantDao().adminUpdateAttachment(conn, list);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;
		
	}
	
	public int adminUpdateRestaurant(AdminRestaurant ar) {
		
		Connection conn = getConnection();
		
		int result = new RestaurantDao().adminUpdateRestaurant(conn, ar);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	
	public int adminUpdateMenu1(Menu m1) {
		
		Connection conn = getConnection();
		
		int result = new RestaurantDao().adminUpdateMenu1(conn, m1);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int adminUpdateMenu2(Menu m2) {
			
			Connection conn = getConnection();
			
			int result = new RestaurantDao().adminUpdateMenu1(conn, m2);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			return result;
		}
	
	public int adminUpdateMenu3(Menu m3) {
		
		Connection conn = getConnection();
		
		int result = new RestaurantDao().adminUpdateMenu1(conn, m3);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int adminUpdateTime(Time t) {
		
		Connection conn = getConnection();
		
		int result = new RestaurantDao().adminUpdateTime(conn, t);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new RestaurantDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public int selectChangeListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new RestaurantDao().selectChangeListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public int selectRequestListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new RestaurantDao().selectRequestListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
}
