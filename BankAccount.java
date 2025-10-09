import java.util.*;

public abstract class BankAccount{
    protected String id; //id -> gives the client that this a bank account belongs to
    protected Client client; // bc every bank account is associated with ONE client
    protected double balance;
    protected int loyaltyPoints;

    protected static final int EARNING_RATE = 5; // -> means 5 loyalty points per dollar spent

    public BankAccount(Client client){
        this.client = client;
        this.id = generateId();
        this.balance = 0;
        this.loyaltyPoints = 0;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){ // or using bank account to purchase something
        loyaltyPoints += (int)Math.round(EARNING_RATE *amount); // -> means +5 loyalty points per dollar spent
        balance -= amount;
    }

    public String getId(){
        return id;
    }
    public int getLoyaltyPoints(){
        return loyaltyPoints;
    }
    public double viewBalance(){
        return balance;
    }

    public String generateId(){
        Random rand = new Random();
        // StringBuilder for time efficiency - Matt
        StringBuilder idStr = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            char letter = (char)('A' + rand.nextInt(26)); // generates a combo containing 4 random letters
            idStr.append(letter); // add onto the ID str
        }

        for (int i = 0; i < 4; i++) {
            char num = (char)('0' + rand.nextInt(10)); // generates a combo containing 4 random ints
            idStr.append(num); // add onto ID str, now the str = [4 letters][4 numbers]
        }
        
        return idStr.toString();
    }

}
