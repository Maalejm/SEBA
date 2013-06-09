package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class Question extends Model {


	@Required
    public int studentid;
    
	@Required
    public int category;
    
	@Required
    public String question;
    
  
   
    
}
