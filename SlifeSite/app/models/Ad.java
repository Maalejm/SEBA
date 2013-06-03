package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import java.awt.image.BufferedImage;
import java.math.*;

@Entity
public class Ad extends Model {


    @Required
    @MaxSize(250)
    public String headline;
    
    @Required
    public String description;
    
   
    @Required
    public int studentid;
    
    @Required
    public int category;
    
    public Blob image;
    
    @Required
    @MaxSize(20)
    public String createDate;
    
   
    
}
