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

import com.semi_5makase.common.model.PageInfo;
import com.semi_5makase.restaurant.model.vo.AdminRestaurant;
import com.semi_5makase.restaurant.model.vo.AdminUpdateRestaurant;
import com.semi_5makase.restaurant.model.vo.Attachment;
import com.semi_5makase.restaurant.model.vo.Category;
import com.semi_5makase.restaurant.model.vo.Menu;
import com.semi_5makase.restaurant.model.vo.Restaurant;
import com.semi_5makase.restaurant.model.vo.TV;
import com.semi_5makase.restaurant.model.vo.Time;

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
										 rset.getString("menu"),
										 rset.getInt("price"),
										 rset.getInt("menu_grade"),
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
		
		ArrayList<Menu> list = new ArrayList<Menu>();
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
								rset.getInt("price"),
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
	
	public ArrayList<AdminRestaurant> adminSelectRestRequest(Connection conn) {
		
		ArrayList<AdminRestaurant> list = new ArrayList<AdminRestaurant>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectRestRequest");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<AdminUpdateRestaurant> adminSelectRestChange(Connection conn) {
		
		ArrayList<AdminUpdateRestaurant> list = new ArrayList<AdminUpdateRestaurant>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectRestChange");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
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
	
	public int adminInsertMenu1(Connection conn, Menu m1) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminInsertMenu1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m1.getMenu());
			pstmt.setInt(2, m1.getPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int adminInsertMenu2(Connection conn, Menu m2) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("adminInsertMenu2");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m2.getMenu());
				pstmt.setInt(2, m2.getPrice());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}

	public int adminInsertMenu3(Connection conn, Menu m3) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adminInsertMenu3");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m3.getMenu());
			pstmt.setInt(2, m3.getPrice());
			
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
				pstmt.setInt(4, at.getRefBoardNo());
				
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
			pstmt.setInt(2, m1.getPrice());
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
				pstmt.setInt(2, m2.getPrice());
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
			pstmt.setInt(2, m3.getPrice());
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
	
}
