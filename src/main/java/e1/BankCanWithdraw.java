package e1;

public class BankCanWithdraw implements BankAccount{
    private BankAccount base;
    private CanWithdraw canWithdraw;
    public BankCanWithdraw(BankAccount base, CanWithdraw canWithdraw){
        this.base = base;
        this.canWithdraw = canWithdraw;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.canWithdraw.check(amount, this.getBalance())){
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
