package com.project.be.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.be.model.order.ProductOrder;
import com.project.be.model.account.Account;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String avatar;

    private String birthday;

    private String email;

    private String firstName;

    private String lastName;

    private String idCard;

    private String phone;

    private Integer deleteStatus;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Address> addressSet;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userType_id", referencedColumnName = "id")
    private UserType userType;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Set<ProductOrder> productOrderSet;

    public User() {
    }

    public User(Integer id, String avatar, String email,
                String firstName, String lastName, String idCard, String phone, Account account) {
        this.id = id;
        this.avatar = avatar;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.phone = phone;
        this.account = account;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Set<ProductOrder> getProductOrderSet() {
        return productOrderSet;
    }

    public void setProductOrderSet(Set<ProductOrder> productOrderSet) {
        this.productOrderSet = productOrderSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
