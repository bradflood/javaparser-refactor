
public class AccountBean implements javax.ejb.SessionBean {
 
     SessionContext ctx;
     DataSource accountDB;
 
     public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
     }
 
     public void ejbCreate() {
          accountDB = (DataSource)ctx.lookup("jdbc/accountDB");
 
     }
     public void ejbActivate() { }
     public void ejbPassivate() { }
     public void ejbRemove() { }

     public void setAccountDeposit(int empId,
                                      double deposit) {
       //...
       Connection conn = accountDB.getConnection();
       //...
     }
  //...
}