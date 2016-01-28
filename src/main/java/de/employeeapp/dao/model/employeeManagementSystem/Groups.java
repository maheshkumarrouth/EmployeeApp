package de.employeeapp.dao.model.employeeManagementSystem;
// Generated 14 Jan, 2016 3:14:25 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Groups generated by hbm2java
 */
public class Groups  implements java.io.Serializable {


     private Integer id;
     private String groupName;
     private Integer groupType;
     private Date lastUpdated;

    public Groups() {
    }

	
    public Groups(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public Groups(String groupName, Integer groupType, Date lastUpdated) {
       this.groupName = groupName;
       this.groupType = groupType;
       this.lastUpdated = lastUpdated;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public Integer getGroupType() {
        return this.groupType;
    }
    
    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }
    public Date getLastUpdated() {
        return this.lastUpdated;
    }
    
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }




}


