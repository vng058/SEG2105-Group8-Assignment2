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
        // We're iterating backwards here, since if we remove the index of accounts as we iterate,
        // we induce bugs where we can skip iterations - Matt
        // If we care about speed, we can accounts into a hashmap for constant time access - Matt
        for (int i = accounts.size() - 1; i >= 0; i--) {
            // Need equals instead for strings - Matt
            if (accounts.get(i).getId().equals(id)) {
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
        for (BankAccount account : accounts) {
            totalLoyaltyPoints += account.getLoyaltyPoints();
        }
        return totalLoyaltyPoints;
    }
    // === Add methods that CREATE and ADD accounts (Part 2 "add") ===
    public SavingsAccount addSavingsAccount(float interestRate, String nickname) {
        SavingsAccount a = new SavingsAccount(this, interestRate, nickname); // uses existing ctor
        accounts.add(a);
        return a;
    }

    public CheckingAccount addCheckingAccount(String nickname) {
        CheckingAccount a = new CheckingAccount(this, nickname);
        accounts.add(a);
        return a;
    }

    public InvestmentAccount addInvestmentAccount(String nickname) {
        InvestmentAccount a = new InvestmentAccount(this, nickname);
        accounts.add(a);
        return a;
    }

    public LoanAccount addLoanAccount(float interestRate) {
        LoanAccount a = new LoanAccount(this, interestRate);
        accounts.add(a);
        return a;
    }




    // === List all associated objects (Part 2 "list") ===
    public java.util.List<BankAccount> listAccounts() {
        return java.util.Collections.unmodifiableList(accounts);
    }

}