package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {
    /**
     * 
     */
    private static final double TAX_PAYMENT = 0.1;

    /**
     * calls superclass constructor.
     * @param usrID
     * @param balance
     */
    public ExtendedStrictBankAccount(final int usrID, final double balance) {
        super(usrID, balance);
    }

    /**
     * compute taxes.
     * @param usrID
     */
    @Override
    public void computeManagementFees(final int usrID) {
        final double taxAmount = MANAGEMENT_FEE + (super.getNTransactions() * TAX_PAYMENT);
        if (super.checkUser(usrID) && this.isWithdrawAllowed(taxAmount)) {
            super.setBalance(super.getBalance() - taxAmount);
            super.resetTransactions();
        }
    }

    /**
     * @param amount
     * @return true if is possible to withdraw
     */
    private boolean isWithdrawAllowed(final double amount) {
        return super.getBalance() > amount;
    }

    /**
     * @param usrID
     * @param amount
     */
    @Override
    public void withdraw(final int usrID, final double amount) {
        if (this.isWithdrawAllowed(amount)) {
            super.withdraw(usrID, amount);
        }
    }

    /**
     * @param usrID
     * @param amount
     */
    @Override
    public void withdrawFromATM(final int usrID, final double amount) {
        if (this.isWithdrawAllowed(amount)) {
            super.withdrawFromATM(usrID, amount + ATM_TRANSACTION_FEE);
        }
    }
}
