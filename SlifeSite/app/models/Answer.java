package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class Answer extends Model {


	@Required
    public int studentid;
    
	@Required
    public int questionid;
    
	@Required
    public String answer;
    
    public int rating;  
    public int ratingCount;
    
   
    
}
