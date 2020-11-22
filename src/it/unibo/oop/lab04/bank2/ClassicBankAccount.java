package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {

    public ClassicBankAccount(final int userID, final double balance) {
        super(userID, balance);
    }

    //metodo astratto implementato, transazione sempre possibile
    protected boolean isWithdrawAllowed(double value) {
        return true;
    }

    //metodo astratto implementato, pago solo una costante
    protected double computeFee() {
        return MANAGEMENT_FEE;
    }

}
