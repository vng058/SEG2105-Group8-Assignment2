public class CheckingAccount extends BankAccount {
    private String accountNickname;

    public CheckingAccount(Client client, String nickname) {
        super(client);
        this.accountNickname = nickname;
    }

    public String getAccountNickname() { return accountNickname; }
    public void setAccountNickname(String nickname) { this.accountNickname = nickname; }
}
