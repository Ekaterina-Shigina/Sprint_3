package ru.yandex.scooter.entity;

import java.util.List;
import java.util.Objects;

public class DataOrder {

    private List<Order> orders;
    private PageInfo pageInfo;
    private List<AvailableStations> availableStations;

    public DataOrder(List<Order> order, PageInfo page, List<AvailableStations> availableStations) {
        this.orders = order;
        this.pageInfo = page;
        this.availableStations = availableStations;
    }

    public DataOrder(){

    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<AvailableStations> getAvailableStations() {
        return availableStations;
    }

    public void setAvailableStations(List<AvailableStations> availableStations) {
        this.availableStations = availableStations;
    }

    @Override
    public String toString() {
        return "DataOrder{" +
                "order=" + orders +
                ", page=" + pageInfo +
                ", availableStations=" + availableStations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataOrder dataOrder = (DataOrder) o;
        return Objects.equals(orders, dataOrder.orders) && Objects.equals(pageInfo, dataOrder.pageInfo) && Objects.equals(availableStations, dataOrder.availableStations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders, pageInfo, availableStations);
    }
}
