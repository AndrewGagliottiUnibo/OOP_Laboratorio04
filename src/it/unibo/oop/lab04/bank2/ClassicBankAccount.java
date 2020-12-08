package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {

    public ClassicBankAccount(final int userID, final double balance) {
        super(userID, balance);
    }

    /**
     * @param value
     * @return always true
     */
    protected boolean isWithdrawAllowed(final double value) {
        return true;
    }

    /**
     * @return fee
     */
    protected double computeFee() {
        return MANAGEMENT_FEE;
    }

}
