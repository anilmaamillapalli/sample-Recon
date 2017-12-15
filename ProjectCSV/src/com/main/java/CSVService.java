package com.main.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.csvreader.CsvReader;
import com.main.bean.Employees;

public class CSVService {

	
	public List<Employees> getEmpInfo(CsvReader  empData) throws IOException{
		
		List<Employees> lEmp= new ArrayList<Employees>();
		empData.readHeaders();
	    
		while(empData.readRecord()){
			Employees emp= new Employees();
			
		emp.setFirstName(empData.get("FirstName"));
		emp.setMiddelName(empData.get("MiddleName"));
		emp.setLastName(empData.get("LastName"));
		emp.setCountry(empData.get("Country"));
		emp.setState(empData.get("State"));
		emp.setCity(empData.get("City"));
		String x=empData.get("Zip");
			int y=Integer.parseInt(x);
			emp.setZip(y);
			lEmp.add(emp);
		}
		empData.close();
		return lEmp;
	}
	
	
	public static void main(String[] args) throws IOException{
		
		CsvReader data= new CsvReader("E:/OIMRelatedCode/ProjectCSV/Employee.csv");
		CSVService cvcS= new CSVService();
				
		cvcS.read(data);
		//List<Employees> emp=cvcS.getEmpInfo(data);
	/*	Iterator itr=	emp.iterator();
	
	
	while(itr.hasNext()){
	Employees e1=(Employees)itr.next();
	System.out.println("First Name :"+e1.getFirstName());
	System.out.println("Middle Name:"+e1.getMiddelName());
	System.out.println("Last Name:"+e1.getLastName());
	System.out.println("Country :"+e1.getCountry());
	System.out.println("State :"+e1.getState());
	System.out.println("City :"+e1.getCity());
	System.out.println("Zip :"+e1.getZip());
	System.out.println("----------------------------");
	}
	*/	
		
	}
	
	
	
	
	public void read(CsvReader doc) throws IOException{
		
	System.out.println(doc.getCurrentRecord());
	System.out.println(doc.skipLine());
	System.out.println(doc.readHeaders());
	System.out.println(doc.getHeaderCount());
	}
		
}

