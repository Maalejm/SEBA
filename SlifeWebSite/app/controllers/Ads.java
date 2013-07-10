package controllers;

import play.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;

 

import play.mvc.*;
import play.data.validation.*;
import play.db.jpa.GenericModel.JPAQuery;

import java.math.BigInteger;
import java.util.*;


import javax.persistence.EntityManager;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import controllers.casino.Secure;



import models.*;

public class Ads  extends Application {

	
	
	
	
 
	
	
	public static void index(int success,String id) {
	        List<Ad> ads = Ad.all().fetch();
	        List<Category> cats = Category.find("categorytype_id=?1 order by id","1").fetch();
	        
	        EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Application.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
	        boolean logedIn=Application.checkLogin();
	        render(ads,cats,fonts,min,max,success,id,logedIn);
	    }
	 
	 public static void newAd( ){
		 
		 List<Category> cats = Category.find("categorytype_id=?1","1").fetch();
		 EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Application.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
	     boolean logedIn=Application.checkLogin();
		 render(fonts,min,max,cats,logedIn);
	 }
	 
	 public static void viewAd(String id){
		
		 Ad ad= Ad.findById(Long.parseLong(id));
		 List<Category> cats = Category.find("categorytype_id=?1 order by id","1").fetch();
		 
		 EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Application.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
	        boolean logedIn=Application.checkLogin();
		 render(ad,fonts,min,max,cats,logedIn);	
	}
	 
	 public static void deleteAd(String id){
			
		 Ad ad= Ad.findById(Long.parseLong(id));
		 ad.delete();
		 Ads.myAds();
	}
	 
	 
	 public static void createAd(@Valid Ad ad,File photo) throws IOException{
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   //get current date time with Date()
		 Date date = new Date();
		 ad.createDate=dateFormat.format(date);
		 ad.student =  Student.findById(1l);
		 //ad.category=Category.findById(ad.category.id);
     	 File d= new File(Play.applicationPath.getAbsolutePath()+"/public/img/ads");
			// if(d.exists()){
     	String suffix = FilenameUtils.getExtension(photo.getName());
	    File o=File.createTempFile("ad-", "."+suffix, d);
			 
			 InputStream input = new FileInputStream(photo);
			 OutputStream output = new FileOutputStream(o);
		ad.image=o.getName();	 
			 
			 ad.save();
			 try {
				    IOUtils.copy(input, output);
				} finally {
				    IOUtils.closeQuietly(output);
				    IOUtils.closeQuietly(input);
				}
		
	  
	  Ads.index(1,ad.category.id.toString());
	  
		  
	      
	 }
	 public static void list(String search, int category, Integer size, Integer page, int firstPage, int lastPage) {
	        List<Ad> ads = null;
	        
	        List<Category> cats = Category.find("categorytype_id=?1","1").fetch();
	        
	        EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Application.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
	        
	        int pagesCount=0;
	        int adCount=0;

	        page = page != null ? page : 1;
	        if(search.trim().length() == 0) {
	        	Long l=null;
	        	if(category==0){
	        	
	        		ads = Ad.find("order by createDate desc").fetch(page, size);
		            l= Ad.count();
	        	}else{
	        		
		        
		            ads = Ad.find(" category_id=?1 order by createDate desc",category).fetch(page, size);
		            l= Ad.count(" category_id=?1 ",category);
	        		
	        	}
	            
	            Long l2=(l/10);
	            
	            adCount=Integer.valueOf(l.intValue());
	            if ((l%10)>0) l2=(long) (Math.floor(l2)+1);
	            pagesCount=Integer.valueOf(l2.intValue());
	            
	        } else {
	            search = search.toLowerCase();
	            Long l= null;
	            if(category==0){
	            ads = Ad.find("(lower(headline) like ?1 OR lower(description) like ?2)", "%"+search+"%", "%"+search+"%").fetch(page, size);
	            l= Ad.count("(lower(headline) like ?1 OR lower(description) like ?2)", "%"+search+"%", "%"+search+"%");
	            }else {
	            ads = Ad.find(" category_id=?1 and (lower(headline) like ?2 OR lower(description) like ?3)",category, "%"+search+"%", "%"+search+"%").fetch(page, size);
	            l= Ad.count("category_id=?1 and (lower(headline) like ?2 OR lower(description) like ?3)",category, "%"+search+"%", "%"+search+"%");
	             }
	            
	            Long l2=(l/10);
	            adCount=Integer.valueOf(l.intValue());
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
	        render(ads, search, size, page,pagesCount,firstPage,lastPage,cats,fonts,logedIn,adCount);
	    }
	 
	 
	 public static void myAds() {
	        List<Ad> ads = null;
	        
	        
	        Integer size=10;
	        Integer page=1;
	        int firstPage=1;
	        int lastPage=10;
	        
	        List<Category> cats = Category.find("categorytype_id=?1","1").fetch();
	        
	        EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from Ad as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Application.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
	        
	        int pagesCount=0;
	        int adsCount=0;
	       
	        String username=session.get("username");
	        
	        if(username==null || username.equals("") )
				try {
					Secure.login();
				} catch (Throwable e) {
					
					e.printStackTrace();
				}
	        
	        Student s=(Student) Student.find("email",username).fetch(1).get(0);
            Long userid=s.id;
	        page = page != null ? page : 1;
	        
	        	Long l=null;
	        	
	        	
	        ads = Ad.find("student_id=?  order by createDate desc",userid).fetch(page, size);
		    l= Ad.count("student_id=?  order by createDate desc",userid);
	        	
	            
	            Long l2=(l/10);
	            if ((l%10)>0) l2=(long) (Math.floor(l2)+1);
	            pagesCount=Integer.valueOf(l2.intValue());
	            
	            adsCount=Integer.valueOf(l.intValue());
	        
	        
	        
	        
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
	        render(ads, adsCount, size, page,pagesCount,firstPage,lastPage,cats,fonts,username,logedIn);
	    }
	 public static void getImage(long id) {
  	   //final Ad ad = Ad.findById(id);
  	   //notFoundIfNull(ad);
  	   //response.setContentTypeIfNotSet(ad.image.type());
  	   //renderBinary(ad.image.get());
  	
  	  
  	}
}
