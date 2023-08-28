package com.semi_5makase.restaurant.model.service;

import static com.semi_5makase.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi_5makase.restaurant.model.dao.RestaurantDao;
import com.semi_5makase.restaurant.model.vo.Favorite;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.Restaurant;

public class RestaurantService {
	
	public int increaseRestaurantView(int restNo) {
		
		Connection conn = getConnection();
		
		int count = new RestaurantDao().increaseRestaurantView(restNo, conn);
		
		if(count > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return count;
	}
	
	
	public Restaurant selectRestaurantDetail(int restNo) {
		
		Connection conn = getConnection(); 
		
		// 음식점번호, 이름, 주소, 전화번호, 주차, 소개, 메뉴, 조회수, 영업시간 조회
		Restaurant rest = new RestaurantDao().selectRestaurantDetail(restNo, conn);
		
		close(conn);
		return rest;
	}
	
	public ArrayList<Menu> selectMenuList(int restNo){
		
		Connection conn = getConnection();
		
		ArrayList<Menu> list = new RestaurantDao().selectMenuList(restNo, conn);
		
		close(conn);
		return list;
	}
	
	public int selectFavoriteCount(int restNo) {
		
		Connection conn = getConnection(); 
		
		int favor = new RestaurantDao().selectFavoriteCount(restNo, conn);
		
		close(conn);
		return favor;
	}
	
	public int checkFavoriteRestaurant(int memNo, int restNo) {
		
		Connection conn = getConnection();
		
		int favor = new RestaurantDao().checkFavoriteRestaurant(memNo, restNo, conn);
		
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
	
	public int deleteFavoriteRestaurant(int memNo, int restNo) {
		
		Connection conn = getConnection();
		
		int del = new RestaurantDao().deleteFavoriteRestaurant(memNo, restNo, conn);
		
		if(del>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return del;
		
	}
	
	public int insertFavoriteRestaurant(int memNo, int restNo) {
		
		Connection conn = getConnection();
		
		int put = new RestaurantDao().insertFavoriteRestaurant(memNo, restNo, conn);
		
		if(put>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return put;
		
	}
	
}
