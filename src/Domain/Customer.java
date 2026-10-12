package Domain;

public class Customer extends Person {
    private String phone;
    private String address;

    public Customer() { super(); }

    public Customer(int id, String name, String gender, int age, String phone, String address) {
        super(id, name, gender, age);
        this.phone = phone;
        this.address = address;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Customer{id=" + getId() + ", name='" + getName() + "', gender='" + getGender() + "', age=" + getAge() + ", phone='" + phone + "', address='" + address + "'}";
    }
}