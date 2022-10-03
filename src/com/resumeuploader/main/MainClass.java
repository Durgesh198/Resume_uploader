package com.resumeuploader.main;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import java.util.Scanner;


import com.resumeuploader.db.dao.ResumeDao;
import com.resumeuploader.db.model.Resume_maker;

public class MainClass {

	public static void main(String[] args) throws IOException {
		
		 int id;
		 String name;
		 String email;
		 String contact;
		 String address;
		 String job_location;
		 String experience;
		 String qualification;
		 String job_type;
		
		Scanner scan=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ResumeDao rDao=new ResumeDao();
		
		while(true) {
			System.out.println("1.Create New Reusme");
			System.out.println("2.Update Existing Resume");
			System.out.println("3.Delete Existing Resume");
			System.out.println("4.Search By ID");
			System.out.println("5.Display All Resumes");
			System.out.println("6.Make a Txet File Of Your Resume");
			System.out.println("7.Exit");
			
			int choice=scan.nextInt();
			if(choice==7) {
				System.out.println("Bye Bye.....!!!");
				break;
			}
			else {
				switch (choice) {
				case 1: System.out.print("Enter Name: ");
				name=br.readLine();
				System.out.print("Enter Email: ");
				email=br.readLine();
				System.out.print("Enter Contact No: ");
				contact=br.readLine();
				System.out.print("Enter Address: ");
				address=br.readLine();
				System.err.println("(Note: Name of city where you searching for a job..!!!)");
				System.out.print("Enter Job Location: ");
				job_location=br.readLine();
				System.err.println("(Note: Experience if any or fresher...!!!)");
				System.out.print("Enter Your Experience: ");
				experience=br.readLine();
				System.out.print("Highest Qualification: ");
				qualification=br.readLine();
				System.out.print("Enter Job Type: ");
				job_type=br.readLine();
				
				boolean result=rDao.insertRecord(name, email, contact, address, job_location, experience, qualification, job_type);
				
				if(result) {
					System.out.println("Record Inserted Successfully...!!!\n");
					
					List <Resume_maker> showId=rDao.getallRecords();
					int i=0;
					for(Resume_maker re: showId) {
						if(i++ == showId.size() - 1){
					        System.err.println(re.getName()+" Your ID is: "+re.getId()+"\n");
					    }
					}
					
				}
				else {
					System.err.println("Not Inserted..!!!!");
				}
				
					break;
				case 2:System.out.print("Enter the ID of the Resume:");
		 		 id = scan.nextInt();
		 		 Resume_maker res=rDao.searchById(id);
		 		System.out.println("What do you want to Update..??");
				System.out.println("1.Name");
				System.out.println("2.Email");
				System.out.println("3.Contact");
				System.out.println("4.Address");
				System.out.println("5.Job Location");
				System.out.println("6.Experience");
				System.out.println("7.Qualification");
				System.out.println("8.Job Type");
				
				int update=scan.nextInt();
				
				switch(update) {
						
				case 1:System.out.print("Enter New Name: ");
				name=br.readLine();
				res.setName(name);
				break;
				
				case 2:System.out.print("Enter New Email: ");
				email=br.readLine();
				res.setEmail(email);
				break;
				
				case 3:System.out.print("Enter New Contact: ");
				contact=br.readLine();
				res.setContact(contact);
				break;
				
				case 4:System.out.print("Enter New Address: ");
				address=br.readLine();
				res.setAddress(address);
				break;
				
				case 5:System.out.print("Enter New Job Location: ");
				job_location=br.readLine();
				res.setJob_location(job_location);
				break;
				
				case 6:System.out.print("Enter New Experience: ");
				experience=br.readLine();
				res.setExperience(experience);
				break;
				
				case 7:System.out.print("Enter New Qualification: ");
				qualification=br.readLine();
				res.setQualification(qualification);
				break;
				
				case 8:System.out.print("Enter New Job Type: ");
				job_type=br.readLine();
				res.setJob_type(job_type);
				break;
				
				
				}
		 		 
		 		result = rDao.updateRecord(res);
				if(result)
					System.out.println("Updated Successfully");
				else
					System.out.println("Not Updated");
						
					
					break;
				case 3:System.out.print("Enter the ID of the Resume:");
		 		 id = scan.nextInt();	
			 		result = rDao.deleteRecord(id);
					if(result)
						System.err.println("\nDeleted Successfully\n");
					else
						System.err.println("Not Deleted,You Entered Wrong ID..!!"); 
					
					break;
				case 4: System.out.println("Enter ID to Fetch Records:");
				id=scan.nextInt();
				Resume_maker client=rDao.searchById(id);
				if(client.getId()!=0)
					System.out.println(client);
					break;
				case 5:
					
										
					
					List<Resume_maker> resume=rDao.getallRecords();
					for(Resume_maker re: resume) {
						
						System.out.println(re);
						
						
					}
					
					break;
					
				case 6:System.out.println("Enter ID to Create Resume:");
				id=scan.nextInt();
				Resume_maker rConvert=rDao.createResume(id);
				

					break;
				
				default:
					System.out.println("Invalid Choice...!!!!");
					break;
				}
			}
		}
	}

}
