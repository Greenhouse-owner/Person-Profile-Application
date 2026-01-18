package model;

/**
 * 地址类，包含家庭/本地地址的属性，满足至少5个属性要求
 */
public class Address {
    // 属性：街道、城市、州、邮编(INT)、门牌号(INT)、国家（6个属性）
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private int houseNumber;
    private String country;

    // 无参构造器（Swing绑定常用）
    public Address() {}

    // 全参构造器
    public Address(String street, String city, String state, int zipCode, int houseNumber, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.houseNumber = houseNumber;
        this.country = country;
    }

    // Getter & Setter（必须实现，用于UI数据传递）
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public int getZipCode() { return zipCode; }
    public void setZipCode(int zipCode) { this.zipCode = zipCode; }
    public int getHouseNumber() { return houseNumber; }
    public void setHouseNumber(int houseNumber) { this.houseNumber = houseNumber; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    // 重写toString，方便查看面板显示
    @Override
    public String toString() {
        return houseNumber + " " + street + ", " + city + ", " + state + ", " + zipCode + ", " + country;
    }
}
