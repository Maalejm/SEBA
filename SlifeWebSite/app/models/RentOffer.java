
package models;

import play.db.jpa.*;
import play.data.validation.*;

import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class RentOffer extends Model {


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
    public float pricePerNight;
    
    @Required
    @MaxSize(20)
    public String startDate;
    
    @Required
    @MaxSize(20)
    public String endDate;
    
    
    public int isRented;
    @ManyToOne
    public Student IsRentedBy;
    
    




  
   
    
}
