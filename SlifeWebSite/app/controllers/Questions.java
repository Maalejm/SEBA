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

import controllers.casino.Security;



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
	    boolean logedIn=Application.checkLogin();
	    render(questions,cats,fonts,min,max,success,id,logedIn);
	
	}
	
	 
	 
	 public static void newQuestion( ){
	
		 List<Category> cats = Category.find("categorytype_id=?1","3").fetch();
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
	        boolean logedIn=Application.checkLogin();
		 render(fonts,min,max,cats,logedIn);
	
	 }
		 
	 public static void newAnswer( int id){
		 
		 EntityManager entityManager = play.db.jpa.JPA.em();
		 List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from answer as a group by question_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from answer as a group by question_id order by question_id ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Questions.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	   
	        }
	        boolean logedIn=Application.checkLogin();
		render(fonts,min,max,logedIn, id);
		 
	 
	 }
	 
	 public static void viewQuestion(String id){
		
		 Question question= Question.findById(Long.parseLong(id));
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
	        List<Answer> answers = null;
			answers = Answer.find(" question_id=?1 order by id desc",question.id).fetch();
			boolean logedIn=Application.checkLogin();
		 render(question,fonts,min,max,cats,answers,logedIn);	
	
	}
	 
	 
	 public static void viewAnswer(String id){
		 Answer answer= Answer.findById(Long.parseLong(id));
		 Question question= Question.findById(answer.question.id); 
		 boolean logedIn=Application.checkLogin();
		 render(answer,question,logedIn);
	 }
	 

	 
	 public static void createQuestion(@Valid Question question,File photo) throws IOException{
		
		 
		String user =session.get("username");	
		question.student=  Student.find("email",user).first();
		     	
		 question.save();
			 
	  Questions.index(1,question.category.id.toString());
	  
		  
	      
	 }
 
	 public static void createAnswer(@Valid Answer answer) throws IOException{
			
		//create student_id 
		String user =session.get("username");	
		answer.student=  Student.find("email",user).first();
		
		//create question_id 
	
		
		
		 answer.save();
		
		 
	
	 Questions.index(3,"");
	  
		  
	      
	 }
	
	 
	 
	 
	 public static void list(String search, int category, Integer size, Integer page, int firstPage, int lastPage) {
	     
		 
		 List<Question> questions = null;
	        
	        List<Category> cats = Category.find("categorytype_id=?1","3").fetch();
	        
	        EntityManager entityManager = play.db.jpa.JPA.em();
	 	    List<BigInteger> bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by maxCount").getResultList();
	        int min= bCounts.get(0).intValue();
	        int max=bCounts.get(bCounts.size()-1).intValue();
	        bCounts = entityManager.createNativeQuery("select count(*) as maxCount from question as a group by category_id order by maxCount ").getResultList();
	        List<String> fonts=new ArrayList<String>();
	        for (int i=0;i<bCounts.size();i++) {
	     	   BigInteger count= bCounts.get(i);
	     	   int x= Questions.getFontSize(count.intValue(),min,max);
	     	   fonts.add(String.valueOf(x));
	     	  
	     	}
	        
	        int pagesCount=0;
	        int questionCount=0;

	        page = page != null ? page : 1;
	        if(search.trim().length() == 0) {
	        	Long l=null;
	        	if(category==0){
	        	
	        		questions = Question.find("order by id desc").fetch(page, size);
		            l= Question.count();
	        	}else{
	        		
		        
	        		questions = Question.find(" category_id=?1 ",category).fetch(page, size);
		            l= Question.count(" category_id=?1 ",category);
	        		
	        	}
	            
	            Long l2=(l/10);
	            questionCount=Integer.valueOf(l.intValue());
	            if ((l%10)>0) l2=(long) (Math.floor(l2)+1);
	            pagesCount=Integer.valueOf(l2.intValue());
	            
	        } else {
	        	search = search.toLowerCase();
	            Long l= null;
	            if(category==0){
	            questions = Question.find("lower(category_id) like ?1 OR lower(question) like ?2)", "%"+search+"%", "%"+search+"%").fetch(page, size);
	            l= Question.count("lower(category_id) like ?1 OR (lower(question) like ?2)", "%"+search+"%", "%"+search+"%");
	            }else {
	            questions = Question.find(" category_id=?1  and (lower(category_id) like ?2 OR lower(question) like ?3)",category, "%"+search+"%", "%"+search+"%").fetch(page, size);
	            l= Question.count("category_id=?1  and (lower(category_id) like ?2 OR lower(question) like ?3)",category, "%"+search+"%", "%"+search+"%");
	             }
	            
	            Long l2=(l/10);
	            questionCount=Integer.valueOf(l.intValue());
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
	        boolean logedIn=Application.checkLogin();
	        render(questions, search, size, page,pagesCount,firstPage,lastPage,cats,fonts,logedIn,questionCount);
	    }
	  	  
  	}

