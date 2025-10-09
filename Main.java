public class Main{
    public static void main(String[] args) {
        // We probably want to add some dummy accounts and test them here
        // Should separate the test logic separately - Matt
        test();
    }

    public static void test() {
        // TODO
        // Do some tests here, we should create some objects from bankaccount and clients and
        // see how it should interact - Matt

        Client alice = new Client(BusinessType.INDIVIDUAL, false, false);
        Client bob   = new Client(true, true); // minor, external

        // Alice: multiple accounts (two savings, two checking, one investment, one loan)
        SavingsAccount sa1 = alice.addSavingsAccount(2.2f, "Rainy Day");
        SavingsAccount sa2 = alice.addSavingsAccount(3.0f, "Vacation");
        CheckingAccount ca1 = alice.addCheckingAccount("Daily");
        CheckingAccount ca2 = alice.addCheckingAccount("Bills");
        InvestmentAccount ia = alice.addInvestmentAccount("TFSA");
        LoanAccount la       = alice.addLoanAccount(6.9f);

        // Bob: a couple of accounts
        CheckingAccount cb1 = bob.addCheckingAccount("Spending");
        InvestmentAccount ib = bob.addInvestmentAccount("College");

        // Activity (loyalty points accrue on withdraw)
        ca1.deposit(800);
        ca1.withdraw(120);     // +600 points
        sa1.deposit(1500);
        sa2.withdraw(50);      // +250 points
        ia.withdraw(200);      // +1000 points
        cb1.deposit(300);

        // Summaries
        printClientSummary("Alice", alice);
        printClientSummary("Bob", bob);

        // Remove one of Alice's accounts to test remove-by-id
        String removeId = la.getId();
        alice.removeBankAccount(removeId);
        System.out.println("\nRemoved Alice loan " + removeId);
        printClientSummary("Alice (after removal)", alice);
    }

    private static void printClientSummary(String name, Client client) {
        System.out.println("\n" + name + " accounts (" + client.listAccounts().size() + "):");
        for (BankAccount a : client.listAccounts()) {
            System.out.println("  " + a.getId() + " - " + a.getClass().getSimpleName()
                    + " | balance=" + a.viewBalance()
                    + " | points=" + a.getLoyaltyPoints());
        }
        System.out.println(name + " total points = " + client.getTotalLoyaltyPoints());
    }
}



