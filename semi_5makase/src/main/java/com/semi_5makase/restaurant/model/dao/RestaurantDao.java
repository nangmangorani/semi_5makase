package com.semi_5makase.restaurant.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.semi_5makase.common.JDBCTemplate.*;

import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.restaurant.model.vo.Favorite;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.Restaurant;
import com.semi_5makase.restaurant.model.vo.Review;

public class RestaurantDao {
	
private Properties prop = new Properties();
	
	public RestaurantDao() {
		
		String filePath = RestaurantDao.class.getResource("/db/sql/restaurant-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int increaseRestaurantView(int restNo, Connection conn) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseRestaurantView");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return count;
	}
	
	/** 음식점 세부정보 조회 메소드
	 * @param restNo 음식점 번호
	 * @param conn
	 * @return
	 */
	public Restaurant selectRestaurantDetail(int restNo, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Restaurant rest = null;
		
		String sql = prop.getProperty("selectRestaurantDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rest = new Restaurant(rset.getInt("REST_NO"),
									  rset.getString("REST_NAME"),
									  rset.getString("REST_ADDRESS"),
									  rset.getString("REST_PHONE"),
									  rset.getString("PARKING"),
									  rset.getString("INTRO"),
									  rset.getInt("REST_VIEWS"),
									  rset.getString("OPENING_TIME"),
									  rset.getString("REST_TIME"),
									  rset.getString("BREAK_TIME")
									  );
				
//				rest = new Restaurant();
//				rest.setRestNo(rset.getInt("REST_NO"));
//				rest.setRestName(rset.getString("REST_NAME"));
//				rest.setRestAddress(rset.getString("REST_ADDRESS"));
//				rest.setRestPhone(rset.getString("REST_PHONE"));
//				rest.setParking(rset.getString("PARKING"));
//				rest.setIntro(rset.getString("INTRO"));
//				rest.setRestViews(rset.getInt("REST_VIEWS"));
//				rest.setOpeningTime(rset.getString("OPENING_TIME"));
//				rest.setRestTime(rset.getString("REST_TIME"));
//				rest.setBreakTime(rset.getString("BREAK_TIME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rest;
	}
	
	/** 메뉴 리스트 조회하는 메소드
	 * @param restNo
	 * @param conn
	 * @return
	 */
	public ArrayList<Menu> selectMenuList(int restNo, Connection conn){
		
		ArrayList<Menu> list = new ArrayList<Menu>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMenuList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Menu(rset.getInt("REST_NO"),
								  rset.getInt("FILE_no"),
								  rset.getString("MENU"),
								  rset.getString("PRICE"),
								  rset.getInt("MENU_GRADE")
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
	
	
	/** 특정 음식점의 즐겨찾기 수를 조회하는 메소드 
	 * @param restNo
	 * @param conn
	 * @return
	 */
	public int selectFavoriteCount(int restNo, Connection conn) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFavoriteCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	
	public int selectLikesCount(int reviewNo, Connection conn) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLikesCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	
	/** 특정 유저가 해당 음식점의 즐겨찾기 여부를 확인하는 메소드
	 * @param memNo
	 * @param restNo
	 * @param conn
	 * @return
	 */
	public int checkFavoriteRestaurant(int memNo, int restNo, Connection conn) {
		
		int favor = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkFavorite");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, restNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				favor = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return favor;
	}
	
	public int checkReviewLikes(int memNo, int reviewNo, Connection conn) {
		
		int likes = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkLikes");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				likes = rset.getInt("count");
			}
			
			System.out.println("좋아요 : " + likes);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return likes;
		
	}
	
	
	/** 특정 음식점의 리뷰 총 개수를 조회하는 메소드
	 * @param restNo
	 * @param conn
	 * @return
	 */
	public int selectReviewCount(int restNo, Connection conn) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	
	/** 해당 음식점 리뷰의 평균 점수를 조회하는 메소드
	 * @param restNo
	 * @param conn
	 * @return
	 */
	public double selectReviewRatingAvg(int restNo, Connection conn) {
		
		double avg = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewRatingAvg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				avg = rset.getDouble("avg");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return avg;
	}
	
	/** 해당 음식점의 즐겨찾기를 삭제(취소) 하는 메소드
	 * @param memNo
	 * @param restNo
	 * @param conn
	 * @return
	 */
	public int deleteFavoriteRestaurant(int memNo, int restNo, Connection conn) {
		
		int del = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteFavoriteRestaurant");
		
		System.out.println("m" + memNo);
		System.out.println("r" + restNo);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, restNo);
			
			del = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return del;
	}
	
	public int deleteLikes(int memNo, int reviewNo, Connection conn) {
		
		int del = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteLikes");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, reviewNo);
			
			del = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return del;
	}
	
	/** 해당 음식점의 즐겨찾기를 등록(찜) 하는 메소드
	 * @param memNo
	 * @param restNo
	 * @param conn
	 * @return
	 */
	public int insertFavoriteRestaurant(int memNo, int restNo, Connection conn) {
		
		int put = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertFavoriteRestaurant");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, restNo);
			
			put = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return put;
	}
	
	public int insertLikes(int memNo, int reviewNo, Connection conn) {
		
		int put = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertLikes");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, reviewNo);
			
			put = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return put;
	}
	
	public String selectNickName(int memNo, Connection conn) {
		
		String nickName = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNickName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				nickName = rset.getString("NICKNAME");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return nickName;
	}
	
	public int insertReview(Review rv, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rv.getRestNo());
			pstmt.setString(2, rv.getReviewContent());
			pstmt.setInt(3, rv.getRating());
			pstmt.setInt(4, rv.getMemNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
public int insertAttachmentList(ArrayList<Attachment> list, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachmentList");
		
		try {
			for(Attachment at : list) { // at = list.get(0), at = list.get(1) ...
				// 미완성
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setString(4, at.getCategory());
				
				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Review> selectReviewList(int restNo, Connection conn){
		
		ArrayList<Review> rvList = new ArrayList<Review>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Review rv = new Review();
				rv.setReviewNo(rset.getInt("REVIEW_NO"));
				rv.setReviewContent(rset.getString("REVIEW_CONTENT"));
				rv.setRating(rset.getInt("RATING"));
				rv.setNickName(rset.getString("NICKNAME"));
				rv.setMemNo(rset.getInt("MEM_NO"));
				
				rvList.add(rv);
				
				System.out.println(rv);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rvList;
	}

	public ArrayList<Attachment> selectReviewAttachment(int reviewNo, Connection conn) {
		
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewAttachment2");
				
		try {
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setInt(1, reviewNo);
			
			rset=pstmt.executeQuery();

			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFilePath(rset.getString("REVIEWIMGS"));
				at.setRefBoardNo(rset.getInt("REVIEW_NO"));
				list.add(at);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int updateRestaurant(int memNo, String update, int restNo, String closed, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateRestaurant");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, update);
			pstmt.setInt(2, restNo);
			pstmt.setInt(3, memNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}
	
	public int insertReport(int memNo, int susNo, String report, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, susNo);
			pstmt.setString(3, report);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
		
	}
	
}
