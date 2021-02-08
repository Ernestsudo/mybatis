package com.bjpowernode.daomain;

public class OrderMessage {
    private int id;
    private String customName;
    private String customAddress;
    private String createTime;
    private double TotalPrice;
    public OrderMessage() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCustomName() {
        return customName;
    }
    public void setCustomName(String customName) {
        this.customName = customName;
    }
    public String getCustomAddress() {
        return customAddress;
    }
    public void setCustomAddress(String customAddress) {
        this.customAddress = customAddress;
    }
    public Object getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public double getTotalPrice() {
        return TotalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }
    @Override
    public String toString() {
        return "OrderMessage{" +
                "id=" + id +
                ", customerName='" + customName + '\'' +
                ", customerAddress='" + customAddress + '\'' +
                ", createTime='" + createTime + '\'' +
                ", TotalPrice=" + TotalPrice +
                '}';
    }
}
