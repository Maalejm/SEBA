package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class Question extends Model {


	@Required
	@ManyToOne
    public Student student;
    
	@Required
	@ManyToOne
    public Category category;
    
	@Required
    public String question;
    
  
   
    
}
