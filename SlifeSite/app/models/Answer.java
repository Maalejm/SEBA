package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class Answer extends Model {


	@Required
	@ManyToOne
    public Student student;
    
	@Required
	@ManyToOne
    public Question question;
    
	@Required
    public String answer;
    
    public int rating;  
    public int ratingCount;
    
   
    
}
