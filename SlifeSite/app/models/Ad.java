package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class Ad extends Model {


	@Required
    @ManyToOne
    public Student student;
    
	@Required
	@ManyToOne
    public Category category;
    
    @Required
    @MaxSize(250)
    public String headline;
    
    @Required
    public String description;
    
    public String image;
    
    @Required
    @MaxSize(20)
    public String createDate;
    
   
    
}
