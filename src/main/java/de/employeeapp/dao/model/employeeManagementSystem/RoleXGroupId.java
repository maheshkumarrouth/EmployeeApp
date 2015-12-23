package de.employeeapp.dao.model.employeeManagementSystem;
// Generated 14 Dec, 2015 9:31:24 PM by Hibernate Tools 4.3.1



/**
 * RoleXGroupId generated by hbm2java
 */
public class RoleXGroupId  implements java.io.Serializable {


     private int roleId;
     private int groupId;

    public RoleXGroupId() {
    }

    public RoleXGroupId(int roleId, int groupId) {
       this.roleId = roleId;
       this.groupId = groupId;
    }
   
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
		 if ( !(other instanceof RoleXGroupId) ) return false;
		 RoleXGroupId castOther = ( RoleXGroupId ) other; 
         
		 return (this.getRoleId()==castOther.getRoleId())
 && (this.getGroupId()==castOther.getGroupId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getRoleId();
         result = 37 * result + this.getGroupId();
         return result;
   }   


}


