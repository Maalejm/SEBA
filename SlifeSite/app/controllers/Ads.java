package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Ads  extends Application {

	 public static void index() {
	        List<Ad> ads = Ad.all().fetch();
	        render(ads);
	    }

	 public static void list(String search, Integer size, Integer page) {
	        List<Ad> ads = null;
	        page = page != null ? page : 1;
	        if(search.trim().length() == 0) {
	            ads = Ad.all().fetch(page, size);
	        } else {
	            search = search.toLowerCase();
	            ads = Ad.find("lower(headline) like ?1 OR lower(description) like ?2", "%"+search+"%", "%"+search+"%").fetch(page, size);
	        }
	        render(ads, search, size, page);
	    }
	 
	 public static void getImage(long id) {
  	   final Ad ad = Ad.findById(id);
  	   notFoundIfNull(ad);
  	   response.setContentTypeIfNotSet(ad.image.type());
  	   renderBinary(ad.image.get());
  	
  	  
  	}
}
