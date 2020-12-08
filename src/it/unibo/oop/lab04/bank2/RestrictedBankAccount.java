package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount {

    private static final double TAX_OPERATIONS = 0.1;

    public RestrictedBankAccount(final int userID, final double balance) {
        super(userID, balance);
    }

    /**
     * @param value
     * @return call to superclass
     */
    protected boolean isWithdrawAllowed(final double value) {
        return super.getBalance() >= value;
    }

    /**
     * @return call to superclass
     */
    protected double computeFee() {
        return super.getNTransactions() * TAX_OPERATIONS + MANAGEMENT_FEE;
    }
}
