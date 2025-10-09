public class LoanAccount extends BankAccount {
    private float interestRate;

    public LoanAccount(Client client, float interestRate) {
        super(client);
        this.interestRate = interestRate;
    }

    public float getInterestRate() { return interestRate; }
    public void setInterestRate(float r) { this.interestRate = r; }
}
