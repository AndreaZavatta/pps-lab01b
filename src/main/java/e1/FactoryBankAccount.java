package e1;

public class FactoryBankAccount {
    public static BankAccount getBankCanWithdrawSimple(){
        return new BankCanWithdraw(new CoreBankAccount(), (amount, balance) -> amount > balance);
    }

    public static BankAccount getBankCanWithdrawFiftyEurosInDebt(){
        return new BankCanWithdraw(new CoreBankAccount(), (amount, balance) -> amount + 50 > balance);
    }

    public static BankAccount getBankAccountWithOneFee(){
        return new BankWithFee(new CoreBankAccount(), 1);
    }

    public static BankAccount getSilverBankAccount(){
        return new BankWithFee(new BankCanWithdraw(new CoreBankAccount(), (amount, balance) -> amount > balance), 1);
    }

    public static BankAccount getGoldBankAccount(){
        return new BankWithFee(new BankCanWithdraw(new CoreBankAccount(), (amount, balance) -> amount - 500 > balance), 0);
    }
}
