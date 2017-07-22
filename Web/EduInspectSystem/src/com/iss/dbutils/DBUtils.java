package com.iss.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DBUtils {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Connection getConn() {
		return conn;
	}

	public DBUtils() {
		try {
			Properties properties = new Properties();
			properties.load(this.getClass().getResourceAsStream("../config/jdbcConfig.properties"));
			String driverClassName = properties.getProperty("driverClassName");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			// System.out.println(driverClassName + "," + url + "," + username + "," +
			// password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean cud(String cudSql, Object... obj) {
		try {
			pstmt = conn.prepareStatement(cudSql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			int size = pstmt.executeUpdate();
			if (size > 0)
				return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<List<String>> selectDBListList(String sql, Object... obj) {
		try {
			List<List<String>> list = new ArrayList<List<String>>();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
				List tempList = new ArrayList();
				list.add(i, tempList);
			}
			while (rs.next()) {
				for (int i = 0; i < columnCount; i++) {
					list.get(i).add(rs.getString(i + 1));
				}
			}
			return list;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public List<Map<String, Object>> selectDBListMap(String sql, String nameArray[], Object... obj) {
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map map = new LinkedHashMap();
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					map.put(nameArray[i], rs.getString(i + 1));
				}
				list.add(map);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

	public List<Map<String, Object>> selectDBListMapCC(String sql, Object... obj) {
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			rs = pstmt.executeQuery();
			Map map = new LinkedHashMap();
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				map.put(rs.getString(2), rs.getString(1));
			}
			list.add(map);
			return list;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public List<Map<String, Object>> selectDBListMapSorce(String sql, Object... obj) {
		try {
			int j = 1;
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map map = new LinkedHashMap();
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					map.put(String.valueOf(j++), rs.getString(i + 1));
				}
				list.add(map);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

	public List<Map<String, Object>> selectDB(String sql, Object... obj) {
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map map = new LinkedHashMap();
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					map.put(rsmd.getColumnName(i + 1), rs.getString(i + 1));
				}
				list.add(map);
			}
			return list;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public int getPageCount(String sql, int pagesize) {
		int pageCount = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pageCount = (int) Math.ceil((double) rs.getInt(1) / pagesize);
			}
			return pageCount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageCount;
	}

	///////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * public DBUtils() { Properties properties = new Properties(); try {
	 * properties.load(this.getClass().getResourceAsStream("jdbcConfig.properties"))
	 * ; String diverClassName = properties.getProperty("mysql_driver"); String url
	 * = properties.getProperty("mysql_url"); String username =
	 * properties.getProperty("mysql_username"); String password =
	 * properties.getProperty("mysql_password"); Class.forName(diverClassName); conn
	 * = DriverManager.getConnection(url, username, password); } catch (IOException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * }
	 */

	public List<Map<String, Object>> selectInfo(String sql, Object... objects) {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				pstmt.setObject(i + 1, objects[i]);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new LinkedHashMap<>();
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					map.put(rsmd.getColumnName(i + 1), rs.getString(i + 1));
				}
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int editInfo(String sql, Object... objects) {
		int count;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				pstmt.setObject(i + 1, objects[i]);
			}
			count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
public static void main(String[] args) {
	DBUtils dUtils=new DBUtils();
	String sql="select * from tb_inspection_record limit ?,?";
	List  list=dUtils.selectDB(sql, 0,10);
	System.out.println(list);
}
}
