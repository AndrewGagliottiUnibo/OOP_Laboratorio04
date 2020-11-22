package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount {

    private static final double TAX_OPERATIONS = 0.1;

    //costruttore
    public RestrictedBankAccount(final int userID, final double balance) {
        super(userID, balance);
    }

    //metodo astratto implementato, transazione possibile se balance >= value
    protected boolean isWithdrawAllowed(double value) {
        return super.getBalance() >= value;
    }

    //metodo astratto implementato, pago le operazioni e una tassa fissa
    protected double computeFee() {
        return (super.getNTransactions() * TAX_OPERATIONS) + MANAGEMENT_FEE;
    }
}
