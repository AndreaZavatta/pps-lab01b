package e1;

    public class BankWithFee implements BankAccount{

        private BankAccount base;
        private StrategyFee fee;

        public BankWithFee(BankAccount base, StrategyFee fee){
            this.base = base;
            this.fee = fee;
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
            base.withdraw(this.fee.getFee(amount));
        }
}
