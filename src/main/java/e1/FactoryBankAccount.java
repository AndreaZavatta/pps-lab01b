package e1;

public class FactoryBankAccount {
    public static BankAccount getBankCanWithdrawSimple(){
        return new BankCanWithdraw(new CoreBankAccount(), (amount, balance) -> amount > balance);
    }

    public static BankAccount getBankCanWithdrawFiftyEurosInDebt(){
        return new BankCanWithdraw(new CoreBankAccount(), (amount, balance) -> amount + 50 > balance);
    }

    public static BankAccount getBankAccountWithOneFee(){
        return new BankWithFee(new CoreBankAccount(), amount -> amount + 1);
    }

    public static BankAccount getSilverBankAccount(){
        return new BankWithFee(new BankCanWithdraw(new CoreBankAccount(), (amount, balance) -> amount > balance), amount -> amount + 1);
    }

    public static BankAccount getGoldBankAccount(){
        return new BankWithFee(new BankCanWithdraw(new CoreBankAccount(), (amount, balance) -> amount - 500 > balance), amount -> amount);
    }

    public static BankAccount getBronzeBankAccount(){
        return new BankWithFee(new BankCanWithdraw(new CoreBankAccount(), (amount, balance) -> amount > balance), FactoryBankAccount::bronzeAccountFee);
    }

    private static int bronzeAccountFee(int amount) {
        return amount < 100 ? amount : amount +1;
    }
}
