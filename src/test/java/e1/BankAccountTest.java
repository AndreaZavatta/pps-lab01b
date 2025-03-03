package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount account;

    @Test
    public void testInitiallyEmpty() {
        this.account = FactoryBankAccount.getSilverBankAccount();
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account = FactoryBankAccount.getSilverBankAccount();
        this.account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account = FactoryBankAccount.getSilverBankAccount();
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account = FactoryBankAccount.getSilverBankAccount();
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

    @Test
    public void testGoldBankAccountShouldThrowException(){
        this.account = FactoryBankAccount.getGoldBankAccount();
        this.account.deposit(1000);
        this.account.withdraw(1400);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(200));
    }

    @Test
    public void testGoldBankAccountNoTransactionFee(){
        this.account = FactoryBankAccount.getGoldBankAccount();
        this.account.deposit(1000);
        this.account.withdraw(700);
        assertEquals(300, this.account.getBalance());
    }

    @Test
    public void testBronzeBankAccountShouldThrowException(){
        this.account = FactoryBankAccount.getBronzeBankAccount();
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

    @Test
    public void testBronzeBankAccountWithoutTransactionFee(){
        this.account = FactoryBankAccount.getBronzeBankAccount();
        this.account.deposit(1000);
        this.account.withdraw(50);
        assertEquals(950, this.account.getBalance());
    }

    @Test
    public void testGoldBankAccountWithTransactionFee(){
        this.account = FactoryBankAccount.getBronzeBankAccount();
        this.account.deposit(1000);
        this.account.withdraw(150);
        assertEquals(849, this.account.getBalance());
    }



}
