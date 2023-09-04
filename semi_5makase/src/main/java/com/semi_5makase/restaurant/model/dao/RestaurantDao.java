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
import com.semi_5makase.restaurant.model.vo.ReviewNo;

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
				
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rvList;
	}
	
	public Review selectModalReivew(int restNo, int refBno, Connection conn) {
		
		Review rv = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectModalReivew");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			pstmt.setInt(2, refBno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rv = new Review(rset.getInt("REVIEW_NO"),
								rset.getString("REVIEW_CONTENT"),
								rset.getInt("RATING"),
								rset.getString("REVIEW_DATE"),
								rset.getInt("MEM_NO"),
								rset.getString("NICKNAME")
								);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rv;
		
	}
	
	public ArrayList<ReviewNo> selectReviewNoList(int restNo, Connection conn){
		
		ArrayList<ReviewNo> rvNoList = new ArrayList<ReviewNo>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewNoList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {

				rvNoList.add(new ReviewNo(rset.getInt("REVIEW_NO")));			
			}		

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rvNoList;
	}

	public ArrayList<Attachment> selectReviewAttachment(int restNo, Connection conn) {
		
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewAttachment2");
				
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset=pstmt.executeQuery();

			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFilePath(rset.getString("REVIEWIMGS"));
				at.setrefBno(rset.getInt("REVIEW_NO"));
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
	
	public int selectMemNo(int refBno, Connection conn) {
		
		int memNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, refBno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memNo = rset.getInt("MEM_NO");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memNo;
	}
	
	public ArrayList<Attachment> selectProfileAttachment(Connection conn) {
		
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProfileAttachment");
				
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset=pstmt.executeQuery();

			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFilePath(rset.getString("REVIEWIMGS"));
				at.setrefBno(rset.getInt("REF_BNO"));
				list.add(at);
			}
			System.out.println("정상다오" + list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public Attachment selectModalProfile(int refBno, Connection conn) {
		
		Attachment list = new Attachment();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectModalProfile");
				
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, refBno);
			
			rset=pstmt.executeQuery();

			if(rset.next()) {
				list.setFilePath(rset.getString("REVIEWIMGS"));
				list.setrefBno(rset.getInt("REF_BNO"));
								
			}
			
			System.out.println("모프다오" + list);
			
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
	
	public ArrayList<Restaurant> selectRestSearch(Connection conn, String searchVal) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		String sql = prop.getProperty("selectSearchRest");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchVal + "%");
			pstmt.setString(2, "%" + searchVal + "%");
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Restaurant(rset.getInt("rest_no")
										,rset.getInt("category_no")
										,rset.getInt("tv_no")
										,rset.getString("tv_name")
										,rset.getString("rest_name")
										,rset.getString("rest_address")
										,rset.getString("rest_phone")
										,rset.getString("parking")
										,rset.getString("intro")
										,rset.getInt("rest_views")
										,rset.getString("status")
										,rset.getString("category_name")
										,rset.getInt("AVG")
										,rset.getInt("COUNT")
										,rset.getInt("FCOUNT")
										,rset.getString("TITLE_IMG")
										)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		for(int i = 0; i<list.size(); i++) {
			System.out.println("나 여기야ㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑ" + list.get(i).getTitleImg());
		}
		
		return list;
		
	}
	
	//평점 순 정렬
	public ArrayList<Restaurant> ratingList(Connection conn, String searchVal) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Restaurant> ratingList = new ArrayList<Restaurant>();
		String sql = prop.getProperty("ratingList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			System.out.println(searchVal);
			pstmt.setString(1, "%" + searchVal + "%");
			pstmt.setString(2, "%" + searchVal + "%");
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				ratingList.add(new Restaurant(rset.getInt("rest_no")
										,rset.getInt("category_no")
										,rset.getInt("tv_no")
										,rset.getString("tv_name")
										,rset.getString("rest_name")
										,rset.getString("rest_address")
										,rset.getString("rest_phone")
										,rset.getString("parking")
										,rset.getString("intro")
										,rset.getInt("rest_views")
										,rset.getString("status")
										,rset.getString("category_name")
										,rset.getInt("AVG")
										,rset.getInt("COUNT")
										,rset.getInt("FCOUNT")
										)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return ratingList;
		
	}
	
	public ArrayList<Restaurant> viewList(Connection conn, String searchVal) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Restaurant> viewList = new ArrayList<Restaurant>();
		String sql = prop.getProperty("viewList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + searchVal + "%");
			pstmt.setString(2, "%" + searchVal + "%");
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				viewList.add(new Restaurant(rset.getInt("rest_no")
										,rset.getInt("category_no")
										,rset.getInt("tv_no")
										,rset.getString("tv_name")
										,rset.getString("rest_name")
										,rset.getString("rest_address")
										,rset.getString("rest_phone")
										,rset.getString("parking")
										,rset.getString("intro")
										,rset.getInt("rest_views")
										,rset.getString("status")
										,rset.getString("category_name")
										,rset.getInt("AVG")
										,rset.getInt("COUNT")
										,rset.getInt("FCOUNT")
										
										)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return viewList;
		
	}
	

	//카테고리 선택 시 리스트
	public ArrayList<Restaurant> selectCategory(Connection conn, int categoryVal) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		
		String sql = prop.getProperty("selectCategory");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, categoryVal);
			rset = pstmt.executeQuery();
			System.out.println(categoryVal);
			while(rset.next()) {
				list.add(new Restaurant(rset.getInt("rest_no")
										,rset.getInt("category_no")
										,rset.getInt("tv_no")
										,rset.getString("tv_name")
										,rset.getString("rest_name")
										,rset.getString("rest_address")
										,rset.getString("rest_phone")
										,rset.getString("parking")
										,rset.getString("intro")
										,rset.getInt("rest_views")
										,rset.getString("status")
										,rset.getString("category_name")
										,rset.getInt("AVG")
										,rset.getInt("COUNT")
										,rset.getInt("FCOUNT")
										));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//			System.out.println(list.size() +" 카테고리 검색");
//		}
		return list;
		
	}
	
	public ArrayList<Restaurant> selectFavoritList(Connection conn, String searchVal) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectFavoritList");
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchVal + "%");
			pstmt.setString(2, "%" + searchVal + "%");
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Restaurant(rset.getInt("rest_no")
										,rset.getInt("category_no")
										,rset.getInt("tv_no")
										,rset.getString("tv_name")
										,rset.getString("rest_name")
										,rset.getString("rest_address")
										,rset.getString("rest_phone")
										,rset.getString("parking")
										,rset.getString("intro")
										,rset.getInt("rest_views")
										,rset.getString("status")
										,rset.getString("category_name")
										,rset.getInt("AVG")
										,rset.getInt("COUNT")
										,rset.getInt("count1")
										
										));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;		
	}
	
	//사이드 메뉴 옵션 모두 선택 후 조회리스트
	public ArrayList<Restaurant> selectOptionList(Connection conn, String searchVal, int ageVal, int ageVal2, int categoryVal, String locationVal, int tvVal) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		String sql = prop.getProperty("selectOptionList");

		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + searchVal + "%");
			pstmt.setString(2, "%" + locationVal + "%");
			pstmt.setString(3, "%" + searchVal + "%");
			pstmt.setString(4, "%" + locationVal + "%");
			pstmt.setInt(5, categoryVal);
			pstmt.setInt(6, tvVal);
			pstmt.setInt(7, ageVal);
			pstmt.setInt(8, ageVal2);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Restaurant(
							rset.getInt("REST_NO"),
							rset.getInt("CATEGORY_NO"),
							rset.getInt("TV_NO"),
							rset.getString("TV_NAME"),
							rset.getString("REST_NAME"),
							rset.getString("REST_ADDRESS"),
							rset.getString("REST_PHONE"),
							rset.getString("PARKING"),
							rset.getString("INTRO"),
							rset.getInt("REST_VIEWS"),
							rset.getString("STATUS"),
							rset.getString("CATEGORY_NAME"),
							rset.getInt("AVG"),
							rset.getInt("COUNT"),
							rset.getInt("FCOUNT")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("여기야@!#!@#@!#" + list.get(i));
		}
		
		return list;
	}
	
	
	
	// 음식점 등록요청
	
	public int insertRestTemp(Connection conn, RestaurantTemp r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertRestTemp");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getRestName());
			pstmt.setString(2, r.getRestInfo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
		
			
	}
	
	// 음식점 등록요청 시 사진 등록 (attachment)
	public int insertAttachment(Connection conn, ArrayList<Attachment> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
	
		try {
			for(Attachment at : list) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				result = pstmt.executeUpdate();

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
				
		
	}
	
	public String selectRestThumbnail(Connection conn, int restNo){
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectRestThumbnail");
		String fileName = "";
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				fileName = rset.getString("fileName");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return fileName;
	}
	
	public ArrayList<Attachment> selectRestAttachment(Connection conn){
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Attachment> atList = new ArrayList<Attachment>();
		
		String sql = prop.getProperty("selectRestAttachment");
		
		try {
			pstmt= conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				atList.add(new Attachment(rset.getInt("file_no")
										 ,rset.getInt("ref_bno")
										 ,rset.getString("origin_name")
										 ,rset.getString("change_name")
										 ,rset.getString("file_Path")
										 ,rset.getDate("upload_date")
										 ,rset.getString("status")
										 ,rset.getString("category")
										 ,rset.getInt("file_Level")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(atList+"atList213123213");
		return atList;
		
				
	}
	
}
