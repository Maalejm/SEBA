package controllers;


import play.mvc.Controller;
import models.Ad;
import models.Category;
import models.RentOffer;
import models.SaleOffer;
import models.Student;
import play.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;

import play.mvc.*;
import play.data.validation.*;


import java.math.BigInteger;
import java.util.*;

import javax.persistence.EntityManager;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import controllers.casino.Secure;

public class SaleOffers extends Controller {
	
	
	public static void index(int success,String id) {
		
       
		List<Ad> ads = Ad.all().fetch();
        List<Category> cats = Category.find("categorytype_id=?1 order by id","4").fetch();
        
        EntityManager entityManager = play.db.jpa.JPA.em();
 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by maxCount").getResultList();
        int min= bCounts.get(0).intValue();
        int max=bCounts.get(bCounts.size()-1).intValue();
        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by category_id ").getResultList();
        List<String> fonts=new ArrayList<String>();
        for (int i=0;i<bCounts.size();i++) {
     	   BigInteger count= bCounts.get(i);
     	   int x= Application.getFontSize(count.intValue(),min,max);
     	   fonts.add(String.valueOf(x));
     	  
     	}
        boolean logedIn=Application.checkLogin();
        render(ads,cats,fonts,min,max,success,id,logedIn);
	        
       
    }
	
	public static String getSortByField(int sortBy){
		
		String sortByField="price";
		switch(sortBy){
		case 1:
			sortByField="price";
			break;
		case 2:
			sortByField="price desc";
			break;
		case 3:
			sortByField="id desc";
			break;
		
		
		}
		
		
		return sortByField;
		
		
		
	}
	public static void newOffer(){
		
		
		
		
        List<Category> cats = Category.find("categorytype_id=?1 order by id","4").fetch();
        
        EntityManager entityManager = play.db.jpa.JPA.em();
 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by maxCount").getResultList();
        int min= bCounts.get(0).intValue();
        int max=bCounts.get(bCounts.size()-1).intValue();
        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by category_id ").getResultList();
        List<String> fonts=new ArrayList<String>();
        for (int i=0;i<bCounts.size();i++) {
     	   BigInteger count= bCounts.get(i);
     	   int x= Application.getFontSize(count.intValue(),min,max);
     	   fonts.add(String.valueOf(x));
     	  
     	}
        boolean logedIn=Application.checkLogin();
        render(cats,fonts,min,max,logedIn);
	}
	
	public static void deleteOffer(String id){
		
		SaleOffer ad= SaleOffer.findById(Long.parseLong(id));
		 ad.delete();
		 SaleOffers.myOffers();
	}
	
  public static void processBuyOffer(String firstname, String lastname, String cardNo, String expirDate, String securityCode, String ofid ){
	  
	  
	  String user =session.get("username");	
	  Student	stu=  Student.find("email",user).first();
	  Long id=Long.parseLong(ofid);
	  SaleOffer off=SaleOffer.findById(id);
	  off.SoldBy=stu;
	  off.isSold=1;
	  off.save();
	  
	  SaleOffers.index(1, "0");
	  
  }
  public static void buyOffer(String id){
		
		
		
		
        List<Category> cats = Category.find("categorytype_id=?1 order by id","4").fetch();
        
        EntityManager entityManager = play.db.jpa.JPA.em();
 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by maxCount").getResultList();
        int min= bCounts.get(0).intValue();
        int max=bCounts.get(bCounts.size()-1).intValue();
        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by category_id ").getResultList();
        List<String> fonts=new ArrayList<String>();
        for (int i=0;i<bCounts.size();i++) {
     	   BigInteger count= bCounts.get(i);
     	   int x= Application.getFontSize(count.intValue(),min,max);
     	   fonts.add(String.valueOf(x));
     	  
     	}
        boolean logedIn=Application.checkLogin();
        render(cats,fonts,min,max,logedIn,id);
	}
	
public static void createOffer(@Valid SaleOffer of,File photo) throws IOException{
		
	String user =session.get("username");	
	 of.student=  Student.find("email",user).first();
	 of.SoldBy= of.student;
	 of.isSold=0;
	 
	 //ad.category=Category.findById(ad.category.id);
 	 File d= new File(Play.applicationPath.getAbsolutePath()+"/public/img/trade");
		// if(d.exists()){
 	String suffix = FilenameUtils.getExtension(photo.getName());
    File o=File.createTempFile("tr-", "."+suffix, d);
		 
		 InputStream input = new FileInputStream(photo);
		 OutputStream output = new FileOutputStream(o);
	of.image=o.getName();
	 
		 
		 
		 of.save();
		 try {
			    IOUtils.copy(input, output);
			} finally {
			    IOUtils.closeQuietly(output);
			    IOUtils.closeQuietly(input);
			}
	
  
  SaleOffers.index(1,of.category.id.toString());
		
	}
	
	
	public static void search(){
		
		render();
		
	}
	
	
public static void myOffers(){
		
	
 List<SaleOffer> offers = null;
 

 
 List<Category> cats = Category.find("categorytype_id=?1 order by id","4").fetch();
 
 EntityManager entityManager = play.db.jpa.JPA.em();
    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by maxCount").getResultList();
 int min= bCounts.get(0).intValue();
 int max=bCounts.get(bCounts.size()-1).intValue();
 bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by category_id ").getResultList();
 List<String> fonts=new ArrayList<String>();
 for (int i=0;i<bCounts.size();i++) {
	   BigInteger count= bCounts.get(i);
	   int x= Application.getFontSize(count.intValue(),min,max);
	   fonts.add(String.valueOf(x));
	  
	}
 
 
 

 String username=session.get("username");
 
 if(username==null || username.equals("") )
		try {
			Secure.login();
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
 
 Student s=(Student) Student.find("email",username).fetch(1).get(0);
 Long userid=s.id;
 
 	

 	
 		offers = SaleOffer.find("student_id=? order by id desc",userid).fetch();
    	int offerCount= offers.size();
 	
     
     
 
    	render(offers, offerCount,cats,fonts);
	}

public static void mySales(){
	
	
 List<SaleOffer> offers = null;
 
 
 List<Category> cats = Category.find("categorytype_id=?1 order by id","4").fetch();
 
 EntityManager entityManager = play.db.jpa.JPA.em();
    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by maxCount").getResultList();
 int min= bCounts.get(0).intValue();
 int max=bCounts.get(bCounts.size()-1).intValue();
 bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by category_id ").getResultList();
 List<String> fonts=new ArrayList<String>();
 for (int i=0;i<bCounts.size();i++) {
	   BigInteger count= bCounts.get(i);
	   int x= Application.getFontSize(count.intValue(),min,max);
	   fonts.add(String.valueOf(x));
	  
	}
 
 
 

 String username=session.get("username");
 
 if(username==null || username.equals("") )
		try {
			Secure.login();
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
 
 Student s=(Student) Student.find("email",username).fetch(1).get(0);
 Long userid=s.id;

 
 	
 	
 	
 offers = SaleOffer.find("soldBy_id=? and isSold=1  order by id desc",userid).fetch();
    int offerCount= SaleOffer.find("soldBy_id=? and isSold=1  order by id desc",userid).fetch().size();
 	
     
     
 
 render(offers, offerCount,cats,fonts);
	
}
	
	 public static void viewOffer(String id){
		 List<Category> cats = Category.find("categorytype_id=?1","4").fetch();
	      
		 SaleOffer of= SaleOffer.findById(Long.parseLong(id));
		 
	        EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Application.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
		
			
		 render(of,fonts,min,max,cats);	
	}
	
	 public static void list(String search, int category, Integer size, Integer page, int firstPage, int lastPage, int sortBy) {
	        List<SaleOffer> sales = null;
	        
	        List<Category> cats = Category.find("categorytype_id=?1","4").fetch();
	        
	        EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from SaleOffer as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Application.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
	        
	        int pagesCount=0;
	        int salesCount=5;

	        page = page != null ? page : 1;
	        if(search.trim().length() == 0) {
	        	Long l=null;
	        	if(category==0){
	        	
	        		sales = SaleOffer.find("order by "+SaleOffers.getSortByField(sortBy)).fetch(page, size);
		            l= SaleOffer.count();
	        	}else{
	        		
		        
	        		sales = SaleOffer.find(" category_id=?1 order by "+SaleOffers.getSortByField(sortBy),category).fetch(page, size);
		            l= SaleOffer.count(" category_id=?1 ",category);
	        		
	        	}
	            
	            Long l2=(l/10);
	            salesCount=Integer.valueOf(l.intValue());
	            if ((l%10)>0) l2=(long) (Math.floor(l2)+1);
	            pagesCount=Integer.valueOf(l2.intValue());
	            
	        } else {
	            search = search.toLowerCase();
	            Long l= null;
	            if(category==0){
	            	sales = SaleOffer.find("(lower(headline) like ?1 OR lower(description) like ?2) order by "+SaleOffers.getSortByField(sortBy), "%"+search+"%", "%"+search+"%").fetch(page, size);
	            l= SaleOffer.count("(lower(headline) like ?1 OR lower(description) like ?2)", "%"+search+"%", "%"+search+"%");
	            }else {
	            	sales = SaleOffer.find(" category_id=?1 and (lower(headline) like ?2 OR lower(description) like ?3) order by "+SaleOffers.getSortByField(sortBy),category, "%"+search+"%", "%"+search+"%").fetch(page, size);
	            l= SaleOffer.count("category_id=?1 and (lower(headline) like ?2 OR lower(description) like ?3)",category, "%"+search+"%", "%"+search+"%");
	             }
	            
	            Long l2=(l/10);
	            salesCount=Integer.valueOf(l.intValue());
	            if ((l%10)>0) l2=(long) (Math.floor(l2)+1);
	            pagesCount=Integer.valueOf(l2.intValue());
	            
	        }
	        
	        
	        
	        if((lastPage-page)<=2){
	           firstPage=page-2;
	           lastPage=page+7;
	           if(lastPage > pagesCount) lastPage=pagesCount;
	        	
	        }else if((page-firstPage)<=2){
		           firstPage=page-7;
		           lastPage=page+2;
		           
		        	
		        }
	        if(firstPage<1) {
	        	   firstPage=1;
	   	           lastPage=10;
	           }
	        if(lastPage>pagesCount)
	        	lastPage=pagesCount;
	        boolean logedIn=Application.checkLogin();
	        render(sales, search, size, page,pagesCount,firstPage,lastPage,cats,fonts,logedIn,salesCount);
	    }
	 

}
