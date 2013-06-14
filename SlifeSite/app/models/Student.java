

package models;

import play.db.jpa.*;
import play.data.validation.*;

import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class Student extends Model {


	@Required
    @MaxSize(50)
    public String firstName;
    
	@Required
    @MaxSize(50)
    public String lastName;
    
	@Required
    @MaxSize(20)
    public String birthDate; 
	
	@Required
    public String address;
	
	@Required
    public String email;
	
    public String image;
   
}

