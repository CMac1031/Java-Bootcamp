public class InheritanceDemo {
    public static void main(String[] args) {
        // TODO: base-type array holding SavingsAccount(100) and CurrentAccount(100)
        Account[] accounts = {
                new SavingsAccount(100),
                new CurrentAccount(100).
                new FrozenAccount(100)
        };

        for (Account account : accounts) {
            // Runtime type chooses the overridden method.
            boolean ok = account.withdraw(20.00);
            System.out.printf("%s withdraw=%s balance=%.2f%n",
                    account.getAccountType(), _____, account.getBalance());
        }
    }
}