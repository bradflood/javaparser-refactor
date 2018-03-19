@Stateless
public class AccountBean implements Account
{
     @Resource private DataSource accountDB;
 
     public@Stateless
     public class AccountBean implements Account
     {
          @Resource private DataSource accountDB;
      
          public void setAccountDeposit(int customerId,
                                           double deposit) {
            //...
            Connection conn = accountDB.getConnection();
            //...
          }
       //...
     } void setAccountDeposit(int customerId,
                                      double deposit) {
       //...
       Connection conn = accountDB.getConnection();
       //...
     }
  //...
}