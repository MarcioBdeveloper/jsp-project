package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ContactDAO {
	
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/db_contacts?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";


	private Connection connectDataBase() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}


	public void insert(ContactBens contact) {
		String create = "insert into contact (name,fone,email,adress,zip_code) values (?,?,?,?,?)";
		try {
			Connection con = connectDataBase();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getFone());
			pst.setString(3, contact.getEmail());
			pst.setString(4, contact.getAdress());
			pst.setString(5, contact.getZipCode());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public ArrayList<ContactBens> list() {
		ArrayList<ContactBens> contacts = new ArrayList<>();
		String read = "select * from contact order by name";
		try {
			Connection con = connectDataBase();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				String adress = rs.getString(5);
				String zipCode = rs.getString(6);
				contacts.add(new ContactBens(id, name, fone, email, adress, zipCode));
			}
			con.close();
			return contacts;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}


	public void getById(ContactBens contact) {
		String read2 = "select * from contact where id = ?";
		try {
			Connection con = connectDataBase();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contact.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contact.setId(rs.getString(1));
				contact.setName(rs.getString(2));
				contact.setFone(rs.getString(3));
				contact.setEmail(rs.getString(4));
				contact.setAdress(rs.getString(5));
				contact.setZipCode(rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public void update(ContactBens contact) {
		String update = "update contact set name=?,fone=?,email=?,adress=?,zip_code=? where id=?";
		try {
			Connection con = connectDataBase();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getFone());
			pst.setString(3, contact.getEmail());
			pst.setString(4, contact.getAdress());
			pst.setString(5, contact.getZipCode());
			pst.setString(6, contact.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public void deleteById(ContactBens contact) {
		String delete = "delete from contact where id=?";
		try {
			Connection con = connectDataBase();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contact.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
