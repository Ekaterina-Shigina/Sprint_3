package ru.yandex.scooter;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.scooter.clients.CourierApiClient;
import ru.yandex.scooter.entity.Courier;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddCourierTests {

    private CourierApiClient client;
    private int courierId;

    Faker faker = new Faker();
    Random random = new Random();

    String login = faker.name().username();
    String password = faker.name().firstName()+random.nextInt(100);
    String  firstName = faker.name().firstName();

    @Before
    public void setUp(){
        client = new CourierApiClient();
    }


    //тест падает из-за того, что приходит сообщение отличное от сообщения в документации
    @Test
    @DisplayName("Созданеи курьера с дублирующими данными")
    @Description("Создание курьера с дублирующими данными. Код ответа 409")
    public void addDoubleCourierTest(){

        final Courier courier = new Courier(
                login,
                password,
                firstName

        );
        //подготовка данных
        client.createClient(courier)
                .then()
                .statusCode(201)
                .extract()
                .path("ok");

        //тест
        String message = client.createClient(courier)
                .then()
                .statusCode(409)
                .extract()
                .path("message");

        assertEquals(message, "Этот логин уже используется");


    }

    @Test
    @DisplayName("Созданеи курьера пустыми данными")
    @Description("Создание курьера с пустыми данными. Код ответа 400")
    public void addCourierNullTest(){
        final Courier courier = new Courier(null, null,null);

        String message = client.createClient(courier)
                .then()
                .statusCode(400)
                .extract()
                .path("message");

        assertEquals(message, "Недостаточно данных для создания учетной записи");

    }

    @Test
    @DisplayName("Созданеи курьера с валидными данными")
    @Description("Создание курьера. Код ответа 201")
    public void addCourierValidTest(){
        final Courier courier = new Courier(
                login,
                password,
                firstName

        );
        boolean statusResponse = client.createClient(courier)
                .then()
                .statusCode(201)
                .extract()
                .path("ok");

        assertTrue("Курьер не создан", statusResponse);

        courierId = client.getIdCourier(courier)
                .then()
                .extract()
                .path("id");

        //сделала здесь, тк если вынести в @After, то будет запускаться после каждого теста, если сделать @AfterClass, то методы нужно делать статичными
        client.deleteClient(courierId)
                .then()
                .statusCode(200);

    }





}
