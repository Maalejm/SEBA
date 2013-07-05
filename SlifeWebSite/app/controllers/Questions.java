package controllers;

import play.*;
import java.util.Date;
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



import models.*;

public class Questions  extends Application {

	
	
	
	public static int getFontSize(int count,int min, int max){
		int fontsize=1;
        float di=((max-min)/30);
		
		if (di==0)
			di=1;
		
		fontsize=(int) (10+(count-min)/di);
		
		return fontsize;
	} 
 
	
	
	public static void index(int success,String id) {
	
		
		
	
		List<Question> questions = Question.all().fetch();
	    List<Category> cats = Category.find("categorytype_id=?1 order by id","3").fetch();
	 
	
	    EntityManager entityManager = play.db.jpa.JPA.em();
	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by maxCount").getResultList();
	    int min= bCounts.get(0).intValue();
	    int max=bCounts.get(bCounts.size()-1).intValue();
	    bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by category_id ").getResultList();
	    List<String> fonts=new ArrayList<String>();
	    
	    for (int i=0;i<bCounts.size();i++) {
	    	BigInteger count= bCounts.get(i);
	    	int x= Questions.getFontSize(count.intValue(),min,max);
	    	fonts.add(String.valueOf(x));
	     	  
	    }
	       
	    render(questions,cats,fonts,min,max,success,id);
	
	}
	
	 
	 
	 public static void newQuestion( ){
	
		 List<Category> cats = Category.find("categorytype_id=?1","1").fetch();
		 EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Questions.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
	        
		 render(fonts,min,max,cats);
	

	 
	 }
	 
	 public static void viewQuestion(String id){
		
		 Question question= Question.findById(Long.parseLong(id));
		 List<Category> cats = Category.find("categorytype_id=?1 order by id","1").fetch();
		 
		 EntityManager entityManager = play.db.jpa.JPA.em();
		 
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Questions.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
			
		 render(question,fonts,min,max,cats);	
	
	}
	 
	 
	 public static void createQuestion(@Valid Question question,File photo) throws IOException{
		
		 question.student =  Student.findById(1l);
		 //ad.category=Category.findById(ad.category.id);
     	
		 question.save();
			 
	  Questions.index(1,question.category.id.toString());
	  
		  
	      
	 }
	 public static void list(String search, int category, Integer size, Integer page, int firstPage, int lastPage) {
	     
		 
		 List<Question> questions = null;
	        
	        List<Category> cats = Category.find("categorytype_id=?1","1").fetch();
	        
	        EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by category_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Questions.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
	        
	        int pagesCount=0;

	        page = page != null ? page : 1;
	        if(search.trim().length() == 0) {
	        	Long l=null;
	        	if(category==0){
	        	
	        		questions = Question.find("order by id desc").fetch(page, size);
		            l= Question.count();
	        	}else{
	        		
		        
	        		questions = Question.find(" category_id=?1 order by createDate desc",category).fetch(page, size);
		            l= Question.count(" category_id=?1 ",category);
	        		
	        	}
	            
	            Long l2=(l/10);
	            if ((l%10)>0) l2=(long) (Math.floor(l2)+1);
	            pagesCount=Integer.valueOf(l2.intValue());
	            
	        } else {
	        	search = search.toLowerCase();
	            Long l= null;
	            if(category==0){
	            questions = Question.find("(lower(category.name) like ?1 OR lower(question) like ?2)", "%"+search+"%", "%"+search+"%").fetch(page, size);
	            l= Question.count("(lower(category.name) like ?1 OR lower(question) like ?2)", "%"+search+"%", "%"+search+"%");
	            }else {
	            questions = Question.find(" category_id=?1 and (lower(category.name) like ?2 OR lower(question) like ?3)",category, "%"+search+"%", "%"+search+"%").fetch(page, size);
	            l= Question.count("category_id=?1 and (lower(category.name) like ?2 OR lower(question) like ?3)",category, "%"+search+"%", "%"+search+"%");
	             }
	            
	            Long l2=(l/10);
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
		           if(firstPage<1) {
		        	   firstPage=1;
		   	           lastPage=10;
		           }
		        	
		        }
	        
	        if(lastPage>pagesCount)
	        	lastPage=pagesCount;
	       
	        render(questions, search, size, page,pagesCount,firstPage,lastPage,cats,fonts);
	    }
	  	  
  	}

