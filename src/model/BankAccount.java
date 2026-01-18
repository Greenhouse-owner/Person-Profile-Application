package model;

/**
 * 银行账户类，包含至少5个属性，使用double/boolean/int基本类型
 */
public class BankAccount {
    // 属性：账号、账户类型、余额(DOUBLE)、是否激活(BOOLEAN)、支行代码(INT)、利率(DOUBLE)
    private String accountNumber;
    private String accountType;
    private double balance;
    private boolean isActive;
    private int branchCode;
    private double interestRate;

    // 无参构造器
    public BankAccount() {}

    // 全参构造器
    public BankAccount(String accountNumber, String accountType, double balance, boolean isActive, int branchCode, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.isActive = isActive;
        this.branchCode = branchCode;
        this.interestRate = interestRate;
    }

    // Getter & Setter
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public int getBranchCode() { return branchCode; }
    public void setBranchCode(int branchCode) { this.branchCode = branchCode; }
    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    // 重写toString
    @Override
    public String toString() {
        return "Account No: " + accountNumber + ", Type: " + accountType + ", Balance: $" + balance +
               ", Active: " + isActive + ", Branch Code: " + branchCode + ", Interest Rate: " + interestRate + "%";
    }
}
