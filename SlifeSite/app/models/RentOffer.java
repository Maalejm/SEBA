
package models;

import play.db.jpa.*;
import play.data.validation.*;

import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class RentOffer extends Model {


	@Required
    public int studentid;
    
	@Required
    public int category;
    
    @Required
    @MaxSize(250)
    public String headline;
    
    @Required
    public String description;
    
    public Blob image;
    
    @Required
    public float pricePerNight;
    
    @Required
    @MaxSize(20)
    public String startDate;
    
    @Required
    @MaxSize(20)
    public String endDate;
    
    
    public int isRented;
    public int IsRentedBy;
    
    
    
  
   
    
}
