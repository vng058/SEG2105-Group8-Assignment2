public class SavingsAccount extends BankAccount {
    private float interestRate;
    private String accountNickname;

    public SavingsAccount(Client client, float interestRate, String nickname) {
        super(client);
        this.interestRate = interestRate;
        this.accountNickname = nickname;
    }

    public float getInterestRate() { return interestRate; }
    public void setInterestRate(float r) { this.interestRate = r; }

    public String getAccountNickname() { return accountNickname; }
    public void setAccountNickname(String nickname) { this.accountNickname = nickname; }
}
