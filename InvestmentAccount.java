public class InvestmentAccount extends BankAccount {
    private String accountNickname;

    public InvestmentAccount(Client client, String nickname) {
        super(client);
        this.accountNickname = nickname;
    }

    public String getAccountNickname() { return accountNickname; }
    public void setAccountNickname(String nickname) { this.accountNickname = nickname; }
}
