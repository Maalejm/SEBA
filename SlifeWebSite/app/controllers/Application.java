package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index(int confirm) {
    	
    	List<Ad> latestAds = Ad.find("order by createDate desc").fetch(9);
    	List<Question> latestQuestions = Question.find("order by id desc").fetch(9);
    	List<RentOffer> latestRooms = RentOffer.find("order by id desc").fetch(9);
    	List<SaleOffer> latestOffers = SaleOffer.find("order by id desc").fetch(9);
    	
        render(latestAds,latestQuestions,latestRooms,latestOffers,confirm);
    }
    
    
   
public static void aboutus() {
    	
    	
        render();
    }


public static void contactus() {
 	
 	
     render();
 }

    
    
    public static boolean checkLogin(){
		
    	String username=session.get("username");
    	        
    	   if(username==null || username.equals("") )
    		  return false;
    	   
         return true;
    	} 
    	
    public static int getFontSize(int count,int min, int max){
		int fontsize=1;
        float di=((max-min)/30);
		
		if (di==0)
			di=1;
		
		fontsize=(int) (10+(count-min)/di);
		
		return fontsize;
	} 
    
    

}