package com.resumeuploader.db.dao;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.resumeuploader.db.DbConnector;
import com.resumeuploader.db.model.Resume_maker;



public class ResumeDao {
	Connection con=DbConnector.connect();
	
	public List<Resume_maker> getallRecords(){
		
		List <Resume_maker> resume= new ArrayList<>();
		
		try {
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from resume_maker");
			
			while(rs.next()) {
				Resume_maker r=new Resume_maker();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setEmail(rs.getString("email"));
				r.setContact(rs.getString("contact"));
				r.setAddress(rs.getString("address"));
				r.setJob_location(rs.getString("job_location"));
				r.setExperience(rs.getString("experience"));
				r.setQualification(rs.getString("qualification"));
				r.setJob_type(rs.getNString("job_type"));
				resume.add(r);
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return resume;
		
	}
	
	public Resume_maker searchById(int id) {
		Resume_maker r=null;
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from resume_maker where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			r=new Resume_maker();
			
			rs.next();
			r.setId(rs.getInt("id"));
			r.setName(rs.getString("name"));
			r.setEmail(rs.getNString("email"));
			r.setContact(rs.getString("contact"));
			r.setAddress(rs.getString("address"));
			r.setJob_location(rs.getString("job_location"));
			r.setExperience(rs.getString("experience"));
			r.setQualification(rs.getString("qualification"));
			r.setJob_type(rs.getNString("job_type"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return r;
		
	}
	
	public boolean insertRecord(String name,String email,String contact,String address,
								String job_location,String experience,String qualification,String job_type) {
		String sql="insert into resume_maker (name,email,contact,address,job_location,experience,qualification,job_type) values (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, contact);
			ps.setString(4, address);
			ps.setString(5, job_location);
			ps.setString(6, experience);
			ps.setString(7, qualification);
			ps.setString(8, job_type);
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public boolean deleteRecord(int id) {
		String sql = "delete from resume_maker where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateRecord(Resume_maker res) {
		
		String str="update resume_maker set name=?,email=?,contact=?,address=?,job_location=?,experience=?,qualification=?,job_type=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(str);
			ps.setString(1, res.getName());
			ps.setString(2, res.getEmail());
			ps.setString(3, res.getContact());
			ps.setString(4, res.getAddress());
			ps.setString(5, res.getJob_location());
			ps.setString(6, res.getExperience());
			ps.setString(7, res.getQualification());
			ps.setString(8, res.getJob_type());
			ps.setInt(9, res.getId());
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}	
	
	public Resume_maker createResume(int id) {
		Resume_maker r=null;
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from resume_maker where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			r=new Resume_maker();
			
			rs.next();
			r.setId(rs.getInt("id"));
			r.setName(rs.getString("name"));
			r.setEmail(rs.getNString("email"));
			r.setContact(rs.getString("contact"));
			r.setAddress(rs.getString("address"));
			r.setJob_location(rs.getString("job_location"));
			r.setExperience(rs.getString("experience"));
			r.setQualification(rs.getString("qualification"));
			r.setJob_type(rs.getNString("job_type"));
			
			try {
				FileWriter fw = new FileWriter("C:\\Resume Maker\\Resume.txt");
				
				fw.write("\n################################################\n\n\n");
				fw.write("\nName : "+r.getName());
				fw.write("\nEmail : "+r.getEmail());
				fw.write("\nContact : "+r.getContact());
				fw.write("\nAddress : "+r.getAddress());
				fw.write("\nJob Location : "+r.getJob_location());
				fw.write("\nExperience : "+r.getExperience());
				fw.write("\nQualification : "+r.getQualification());
				fw.write("\nJob Type : "+r.getJob_type());
				fw.write("\n\n\n\n################################################");
				
				fw.close();
				System.err.println("\nHello "+r.getName()+" Your Resume is created as Resume.txt\n");
			}
			catch (Exception e) {
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return r;
	}

}
