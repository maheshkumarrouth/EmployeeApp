package de.employeeapp.dao.model.employeeManagementSystem;
// Generated 10 Dec, 2015 5:02:24 PM by Hibernate Tools 4.3.1



/**
 * EmployeeXLoginId generated by hbm2java
 */
public class EmployeeXLoginId  implements java.io.Serializable {


     private int id;
     private int employeeId;

    public EmployeeXLoginId() {
    }

    public EmployeeXLoginId(int id, int employeeId) {
       this.id = id;
       this.employeeId = employeeId;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EmployeeXLoginId) ) return false;
		 EmployeeXLoginId castOther = ( EmployeeXLoginId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getEmployeeId()==castOther.getEmployeeId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getEmployeeId();
         return result;
   }   


}


