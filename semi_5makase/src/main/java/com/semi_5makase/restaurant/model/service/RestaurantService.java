package com.semi_5makase.restaurant.model.service;

import static com.semi_5makase.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.restaurant.model.dao.RestaurantDao;
import com.semi_5makase.restaurant.model.vo.Favorite;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.Restaurant;
import com.semi_5makase.restaurant.model.vo.Review;

public class RestaurantService {
	
	public int increaseRestaurantView(int restNo) {
		
		Connection conn = getConnection();
		
		int count = new RestaurantDao().increaseRestaurantView(restNo, conn);
		
		if(count > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
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
	
	public int selectLikesCount(int reviewNo) {
		
		Connection conn = getConnection(); 
		
		int likes = new RestaurantDao().selectLikesCount(reviewNo, conn);
		
		close(conn);
		return likes;
	}
	
	public int checkFavoriteRestaurant(int memNo, int restNo) {
		
		Connection conn = getConnection();
		
		int favor = new RestaurantDao().checkFavoriteRestaurant(memNo, restNo, conn);
		
		close(conn);
		return favor;
		
	}
	
	public int checkReviewLikes(int memNo, int reviewNo) {
		
		Connection conn = getConnection();
		
		int likes = new RestaurantDao().checkReviewLikes(memNo, reviewNo, conn);
		
		close(conn);
		return likes;
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
	
	public int deleteLikes(int memNo, int reviewNo) {
		
		Connection conn = getConnection();
		
		int del = new RestaurantDao().deleteLikes(memNo, reviewNo, conn);
		
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
	
	public int insertLikes(int memNo, int reviewNo) {
		
		Connection conn = getConnection();
		
		int put = new RestaurantDao().insertLikes(memNo, reviewNo, conn);
		
		if(put>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return put;
	}
	
	public String selectNickName(int memNo) {
		
		Connection conn = getConnection();
		
		String nickName = new RestaurantDao().selectNickName(memNo, conn);
		
		close(conn);
		return nickName;
		
	}
	
	public int insertReview(Review rv, ArrayList<Attachment> list) {
		
		Connection conn = getConnection();
		
		int result1 = new RestaurantDao().insertReview(rv, conn);
		int result2 = 1;
		
		if(list != null) {
			result2 = new RestaurantDao().insertAttachmentList(list, conn);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1 * result2;
	}

	public ArrayList<Review> selectReviewList(int restNo){
		
		Connection conn = getConnection();
		
		ArrayList<Review> rvList = new RestaurantDao().selectReviewList(restNo, conn);
		
		close(conn);
		return rvList;
		
	}

	public ArrayList<Attachment> selectReviewAttachment(int reviewNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new RestaurantDao().selectReviewAttachment(reviewNo, conn);
		
		close(conn);
		return list;
	}
	
	public ArrayList<Attachment> selectReviewAttachment() {
		int reviewNo = 0;
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new RestaurantDao().selectReviewAttachment(reviewNo, conn);
		
		close(conn);
		return list;
	}
	
	public int updateRestaurant(int memNo, String update, int restNo, String closed) {
		
		Connection conn = getConnection();
		
		int result = new RestaurantDao().updateRestaurant(memNo, update, restNo, closed, conn);
		
		if(result > 0) {
			commit(conn);			
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int insertReport(int memNo, int susNo, String report) {
		Connection conn = getConnection();
		
		int result = new RestaurantDao().insertReport(memNo, susNo, report, conn);
		
		if(result > 0) {
			commit(conn);			
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
