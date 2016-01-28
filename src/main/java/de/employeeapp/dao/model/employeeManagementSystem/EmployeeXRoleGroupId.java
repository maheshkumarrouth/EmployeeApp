package de.employeeapp.dao.model.employeeManagementSystem;
// Generated 14 Jan, 2016 3:14:25 PM by Hibernate Tools 4.3.1



/**
 * EmployeeXRoleGroupId generated by hbm2java
 */
public class EmployeeXRoleGroupId  implements java.io.Serializable {


     private int empId;
     private int groupId;

    public EmployeeXRoleGroupId() {
    }

    public EmployeeXRoleGroupId(int empId, int groupId) {
       this.empId = empId;
       this.groupId = groupId;
    }
   
    public int getEmpId() {
        return this.empId;
    }
    
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public int getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EmployeeXRoleGroupId) ) return false;
		 EmployeeXRoleGroupId castOther = ( EmployeeXRoleGroupId ) other; 
         
		 return (this.getEmpId()==castOther.getEmpId())
 && (this.getGroupId()==castOther.getGroupId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getEmpId();
         result = 37 * result + this.getGroupId();
         return result;
   }   


}


