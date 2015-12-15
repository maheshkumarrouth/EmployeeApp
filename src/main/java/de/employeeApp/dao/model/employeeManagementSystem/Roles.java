package de.employeeApp.dao.model.employeeManagementSystem;
// Generated 14 Dec, 2015 9:31:24 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Roles generated by hbm2java
 */
public class Roles  implements java.io.Serializable {


     private Integer id;
     private String action;
     private Date lastUpdated;

    public Roles() {
    }

	
    public Roles(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public Roles(String action, Date lastUpdated) {
       this.action = action;
       this.lastUpdated = lastUpdated;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAction() {
        return this.action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    public Date getLastUpdated() {
        return this.lastUpdated;
    }
    
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }




}


