package model;

/**
 * 人员类，与Address（家庭/本地）、BankAccount为1对1关系，使用int/boolean基本类型
 */
public class Person {
    // 核心属性：名、姓、年龄(INT)、婚姻状态(BOOLEAN)
    private String firstName;
    private String lastName;
    private int age;
    private boolean isMarried;
    
    // 1对1关联：家庭地址、本地地址、银行账户
    private Address homeAddress;
    private Address localAddress;
    private BankAccount bankAccount;

    // 无参构造器
    public Person() {
        // 初始化关联对象，避免空指针
        this.homeAddress = new Address();
        this.localAddress = new Address();
        this.bankAccount = new BankAccount();
    }

    // 全参构造器
    public Person(String firstName, String lastName, int age, boolean isMarried, Address homeAddress, Address localAddress, BankAccount bankAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
        this.homeAddress = homeAddress;
        this.localAddress = localAddress;
        this.bankAccount = bankAccount;
    }

    // Getter & Setter
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public boolean isMarried() { return isMarried; }
    public void setMarried(boolean married) { isMarried = married; }
    public Address getHomeAddress() { return homeAddress; }
    public void setHomeAddress(Address homeAddress) { this.homeAddress = homeAddress; }
    public Address getLocalAddress() { return localAddress; }
    public void setLocalAddress(Address localAddress) { this.localAddress = localAddress; }
    public BankAccount getBankAccount() { return bankAccount; }
    public void setBankAccount(BankAccount bankAccount) { this.bankAccount = bankAccount; }
}