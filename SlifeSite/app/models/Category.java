
package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class Category extends Model {


	@Required
    public int catid;
    
	@Required
    public String name;
	
	public int pubularity;
    
   
    
}

