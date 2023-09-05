package com.semi_5makase.restaurant.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.semi_5makase.common.JDBCTemplate.*;

import com.semi_5makase.common.model.vo.Attachment;
import com.semi_5makase.common.model.vo.PageInfo;
import com.semi_5makase.restTemp.RestaurantTemp;
import com.semi_5makase.restaurant.model.vo.AdminRequestRestaurant;
import com.semi_5makase.restaurant.model.vo.AdminRestaurant;
import com.semi_5makase.restaurant.model.vo.AdminUpdateRestaurant;

import com.semi_5makase.restaurant.model.vo.Category;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.Restaurant;
import com.semi_5makase.restaurant.model.vo.TV;
import com.semi_5makase.restaurant.model.vo.Time;
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
								  rset.getInt("FILE_NO"),
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
	
	public ArrayList<Restaurant> selectMainTvRestInfo(Connection conn) {
		
		ArrayList<Restaurant> tvList = new ArrayList<Restaurant>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMainTvRestInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				tvList.add(new Restaurant(rset.getString("REST_NAME"),
										  rset.getString("ADDRESS"),
										  rset.getString("TV_NAME"),
										  rset.getString("CATEGORY_NAME"),
										  rset.getDouble("AVG")
										  ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("TV리스트" + tvList);
		
		return tvList;
		
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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rest;
	}
	

	
	
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
			close(pstmt);
		}
		return count;
	}
	
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
			close(pstmt);
		}
		return count;
	}
	
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
			close(pstmt);
		}
		return avg;
	}
	
	public ArrayList<AdminRestaurant> adminSelectRestList(Connection conn){
		
		ArrayList<AdminRestaurant> list = new ArrayList<AdminRestaurant>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminSelectRestList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new AdminRestaurant(rset.getInt("rest_no"),
											 rset.getString("rest_name"),
											 rset.getString("rest_address"),
											 rset.getString("rest_phone"),
											 rset.getString("category_name"),
											 rset.getString("status")
											 ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return list;
		
		
	}
	
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
	
	public ArrayList<AdminRestaurant> adminSelectRestList(Connection conn, PageInfo pi){
		
		ArrayList<AdminRestaurant> list = new ArrayList<AdminRestaurant>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminSelectRestListPaging");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new AdminRestaurant(rset.getInt("rest_no"),
											 rset.getString("rest_name"),
											 rset.getString("rest_address"),
											 rset.getString("rest_phone"),
											 rset.getString("category_name"),
											 rset.getString("status")
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
	
	public ArrayList<Category> adminSelectCategory(Connection conn){
			
			ArrayList<Category> clist = new ArrayList<Category>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("adminSelectCategory");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					clist.add(new Category(rset.getInt("category_no"),
										  rset.getString("category_name")
										  ));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return clist;
		}
	
	public ArrayList<TV> adminSelectTv(Connection conn){
		
		ArrayList<TV> tlist = new ArrayList<TV>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminSelectTv");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				tlist.add(new TV(rset.getInt("tv_no"),
								rset.getString("tv_name")
								));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return tlist;
	}
	
	public AdminRestaurant adminSelectRestaurant(Connection conn, int restNo) {
		
		AdminRestaurant ar = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminSelectRestaurant");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ar = new AdminRestaurant(rset.getInt("rest_no"),
										 rset.getString("category_name"),
										 rset.getString("tv_name"),
										 rset.getString("rest_name"),
										 rset.getString("rest_address"),
										 rset.getString("rest_phone"),
										 rset.getString("parking"),
										 rset.getString("intro"),
										 rset.getString("status"),
										 rset.getString("opening_time"),
										 rset.getString("rest_time"),
										 rset.getString("break_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return ar;
	}

	public ArrayList<Menu> adminSelectRestaurantMenu(Connection conn, int restNo){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminSelectRestaurantMenu");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Menu(rset.getInt("rest_no"),
								rset.getString("menu"),
								rset.getString("price"),
								rset.getInt("menu_grade")
								));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return list;
		
	}
		
		ArrayList<Menu> list = new ArrayList<Menu>();
	
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
	
	public ArrayList<AdminRequestRestaurant> adminSelectRestRequest(Connection conn, PageInfo pi) {
		
		ArrayList<AdminRequestRestaurant> list = new ArrayList<AdminRequestRestaurant>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectRestRequestPaging");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new AdminRequestRestaurant(rset.getInt("rtemp_no"),
													rset.getString("rtemp_name"),
													rset.getString("rtemp_info")
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
	
	public ArrayList<AdminUpdateRestaurant> adminSelectRestChange(Connection conn, PageInfo pi) {
		
		ArrayList<AdminUpdateRestaurant> list = new ArrayList<AdminUpdateRestaurant>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectRestChangePaging");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new AdminUpdateRestaurant(rset.getInt("update_no"),
													rset.getString("update_content"),
													rset.getInt("rest_no"),
													rset.getString("rest_name")
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
	
	public ArrayList<Attachment> adminSelectAttatchment(Connection conn, int restNo) {
		
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectAttatchment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, restNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setChangeName(rset.getString("change_name"));
				at.setFilePath(rset.getString("file_path"));
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
	
	
	public int adminInsertRestaurant(Connection conn, AdminRestaurant ar) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adminInsertRestaurant");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ar.getRestName());
			pstmt.setString(2, ar.getRestAddress());
			pstmt.setString(3, ar.getRestPhone());
			pstmt.setString(4, ar.getParking());
			pstmt.setString(5, ar.getIntro());
			pstmt.setString(6, ar.getStatus());
			pstmt.setString(7, ar.getCategory());
			pstmt.setString(8, ar.getTv());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int adminInsertAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adminInsertAttachment2");
		System.out.println(result + "#########");
		try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				
				result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int adminInsertAttachment(Connection conn, ArrayList<Attachment> list) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adminInsertAttachment");
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
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int adminInsertAttachment1(Connection conn, Attachment at1) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adminInsertAttachment1");
		try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at1.getOriginName());
				pstmt.setString(2, at1.getChangeName());
				pstmt.setString(3, at1.getFilePath());
				
				result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int adminInsertMenu1(Connection conn, Menu m1) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("adminInsertMenu1");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m1.getMenu());
				pstmt.setString(2, m1.getPrice());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
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
	
	
	public int adminInsertMenu2(Connection conn, Menu m2) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminInsertMenu2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m2.getMenu());
			pstmt.setString(2, m2.getPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
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
	
public int adminInsertMenu3(Connection conn, Menu m3) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminInsertMenu3");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m3.getMenu());
			pstmt.setString(2, m3.getPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

public int adminInsertTime(Connection conn, Time ar3) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("adminInsertTime");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, ar3.getOpenTime());
		pstmt.setString(2, ar3.getRestTime());
		pstmt.setString(3, ar3.getBreakTime());
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	return result;
}

public int adminUpdateRestaurant(Connection conn, AdminRestaurant ar) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("adminUpdateRestaurant");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, ar.getRestName());
		pstmt.setString(2, ar.getCategory());
		pstmt.setString(3, ar.getTv());
		pstmt.setString(4, ar.getRestAddress());
		pstmt.setString(5, ar.getRestPhone());
		pstmt.setString(6, ar.getParking());
		pstmt.setString(7, ar.getIntro());
		pstmt.setString(8, ar.getStatus());
		pstmt.setInt(9, ar.getRestNo());
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	return result;
}

public int adminUpdateAttachment(Connection conn, ArrayList<Attachment> list) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("adminUpdateAttachment");
	
	try {
		for(Attachment at : list) {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getRefBno());
			
			result = pstmt.executeUpdate();
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	return result;
}

public int adminUpdateMenu1(Connection conn, Menu m1) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("adminUpdateMenu1");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, m1.getMenu());
		pstmt.setString(2, m1.getPrice());
		pstmt.setInt(3, m1.getMenuGrade());
		pstmt.setInt(4, m1.getRestNo());
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	return result;
}

public int adminUpdateMenu2(Connection conn, Menu m2) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminUpdateMenu2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m2.getMenu());
			pstmt.setString(2, m2.getPrice());
			pstmt.setInt(3, m2.getMenuGrade());
			pstmt.setInt(4, m2.getRestNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

public int adminUpdateMenu3(Connection conn, Menu m3) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("adminUpdateMenu3");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, m3.getMenu());
		pstmt.setString(2, m3.getPrice());
		pstmt.setInt(3, m3.getMenuGrade());
		pstmt.setInt(4, m3.getRestNo());
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	return result;
}

public int adminUpdateTime(Connection conn, Time ar3) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("adminUpdateTime");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, ar3.getOpenTime());
		pstmt.setString(2, ar3.getRestTime());
		pstmt.setString(3, ar3.getBreakTime());
		pstmt.setInt(4, ar3.getRestNo());
		
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

public int selectChangeListCount(Connection conn) {
	
	int listCount = 0;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = prop.getProperty("selectChangeListCount");
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
			at.setRefBno(rset.getInt("REF_BNO"));
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
			list.setRefBno(rset.getInt("REF_BNO"));
							
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


public int selectRequestListCount(Connection conn) {
	
	int listCount = 0;
	
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = prop.getProperty("selectRequestListCount");
	
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
		System.out.println("selectOptionList 시작");
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		String sql = prop.getProperty("selectOptionList");

		
		System.out.println(searchVal + "##" +  locationVal);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + searchVal + "%");
			pstmt.setString(2, "%" + searchVal + "%");
			pstmt.setString(3, "%" + locationVal + "%");
			pstmt.setInt(4, categoryVal);
			pstmt.setInt(5, tvVal);
			pstmt.setInt(6, ageVal);
			pstmt.setInt(7, ageVal2);
			
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
					at.setRefBno(rset.getInt("REVIEW_NO"));
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

	
	
}
