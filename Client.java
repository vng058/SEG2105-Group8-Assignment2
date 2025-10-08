import java.util.*; // you may have to import this in other places

public class Client{
    private List<BankAccount> accounts;
    private AgeGroup ageGroup;
    private boolean isStudent;
    private boolean isExternal;
    private BusinessType businessType;
    
    public Client(BusinessType businessType, boolean isStudent, boolean isExternal){ // constructor if ageGroup is adult
        this.ageGroup = AgeGroup.ADULT;
        this.businessType = businessType;
        this.isStudent = isStudent;
        this.isExternal = isExternal;
        this.accounts = new ArrayList<BankAccount>(); 
    }
     
    public Client(boolean isStudent, boolean isExternal){ // constructor if ageGroup is minor
        this.businessType = BusinessType.NONE;
        this.ageGroup = AgeGroup.MINOR;
        this.isStudent = isStudent;
        this.isExternal = isExternal;
        this.accounts = new ArrayList<BankAccount>(); 
        
    }

    public void removeBankAccount(String id){
        for(int i=0; i<accounts.size(); i++){
            if (accounts.get(i).getId() == id){
                accounts.remove(i);
            }
        }
    }

    /* IMPLEMENT THE METHODS BELOW
    public void makeSavingsAccount(){  //this is the general template for each method (SUBJECT TO CHANGE)
        Client client = this
        SavingsAccount account = SavingsAccount(client);    
        accounts.add(account); 
    }
    public void makeCheckingAccount(){} -> allows client to make a new checking account
    public void makeInvestmentAccount(){}
    public void makeLoanAccount(){}

    */

    public int getTotalLoyaltyPoints(){ 
        int totalLoyaltyPoints = 0;
        for(int i=0; i<accounts.size(); i++){
            totalLoyaltyPoints += accounts.get(i).getLoyaltyPoints();
        }
        return totalLoyaltyPoints;
    }
    
}