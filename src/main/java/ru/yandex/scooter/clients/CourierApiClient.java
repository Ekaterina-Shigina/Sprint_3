package ru.yandex.scooter.clients;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.scooter.entity.Courier;

import static io.restassured.RestAssured.given;

public class CourierApiClient extends BaseClient{

    private static final String COURIER_URL = "/api/v1/courier/";


    @Step("Создание курьера Post /api/v1/courier")
    public Response createClient(Courier courier){
        return given()
                .spec(requestSpec())
                .body(courier)
                .when()
                .post(COURIER_URL);
    }

    @Step("Авторизация курьера Post /api/v1/courier/login . Получение его Id")
    public Response getIdCourier(Courier courier){
        return given()
                .spec(requestSpec())
                .body(courier)
                .when()
                .post(COURIER_URL + "login/");
    }

    @Step("Удаление курьера Delete /api/v1/courier/:id ")
    public Response deleteClient(int courierId){
        return given()
                .spec(requestSpec())
                .when()
                .delete(COURIER_URL + courierId);
    }


}
