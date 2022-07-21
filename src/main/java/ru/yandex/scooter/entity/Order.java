package ru.yandex.scooter.entity;

import java.util.Date;
import java.util.List;

public class Order {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private List<String> color;
    private Boolean cancelled;
    private Boolean finished;
    private Boolean inDelivery;
    private String courierFirstName;
    private String createdAt;
    private String updatedAt;
    private Integer status;
    private Integer courierId;
    private Integer track;


    public Order(String firstName, String lastName, String address, String metroStation, String phone,
                 int rentTime, String deliveryDate, String comment, List<String> color, Boolean cancelled,
                 Boolean finished, Boolean inDelivery, String courierFirstName, String createdAt, String updatedAt,
                 Integer status, Integer courierId, Integer track) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
        this.cancelled = cancelled;
        this.finished = finished;
        this.inDelivery = inDelivery;
        this.courierFirstName = courierFirstName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.courierId = courierId;
        this.track = track;
    }
    public Order(){

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public int getRentTime() {
        return rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public List<String> getColor() {
        return color;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isInDelivery() {
        return inDelivery;
    }

    public String getCourierFirstName() {
        return courierFirstName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setInDelivery(boolean inDelivery) {
        this.inDelivery = inDelivery;
    }

    public void setCourierFirstName(String courierFirstName) {
        this.courierFirstName = courierFirstName;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", metroStation='" + metroStation + '\'' +
                ", phone='" + phone + '\'' +
                ", rentTime=" + rentTime +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", comment='" + comment + '\'' +
                ", color=" + color +
                ", cancelled=" + cancelled +
                ", finished=" + finished +
                ", inDelivery=" + inDelivery +
                ", courierFirstName='" + courierFirstName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", status=" + status +
                ", courierId=" + courierId +
                ", track=" + track +
                '}';
    }
}

