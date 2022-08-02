package ru.yandex.scooter.clients;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.scooter.entity.Order;

import static io.restassured.RestAssured.given;

public class OrderApiClient extends BaseClient {
    private static final String ORDER_URL = "/api/v1/orders/";


    @Step("Создание заказа Post /api/v1/orders")
    public Response createOrder(Order order){
        return given()
                .spec(requestSpec())
                .body(order)
                .when()
                .post(ORDER_URL);

    }

    @Step("Отмена заказа Put /api/v1/orders/cancel")
    public Response cancelledOrder(int trackId){
        return given()
                .spec(requestSpec())
                .when()
                .put(ORDER_URL + "cancel/?track="+trackId);
    }

    @Step("Получение списка заказов без фильтрации Get /api/v1/orders")
    public Response getOrders(){
        return given()
                .spec(requestSpec())
                .when()
                .get(ORDER_URL);
    }


}
