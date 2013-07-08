

package models;

import play.db.jpa.*;
import play.data.validation.*;

import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class SaleOffer extends Model {


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
    
    @Required
    public String image;
    
    @Required
    public float price;
    
    @Required
    public int isSold;
    @ManyToOne
    public Student SoldBy;
    
    
    
  
   
    
}
