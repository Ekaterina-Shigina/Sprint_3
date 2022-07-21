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
import static org.junit.Assert.assertNotNull;

public class LoginCourierTests {

    private CourierApiClient client;

    Faker faker = new Faker();
    Random random = new Random();

    String login = faker.name().username();
    String password = faker.name().firstName()+random.nextInt(100);
    String firstName = faker.name().firstName();


    @Before
    public void setUp(){
        client = new CourierApiClient();

    }

    @Test
    @DisplayName("Авторизация с валидными данными")
    @Description("Авторизация с валидными даннымим. Код ответа 200")
    public void authenticationCourierTest(){

        //создание курьера перед тестом
        final Courier courier = new Courier(
                login,
                password,
                firstName

        );
        client.createClient(courier)
                .then()
                .statusCode(201);

        //аутентификация
        int id = client.getIdCourier(courier)
                .then()
                .statusCode(200)
                .extract()
                .path("id");

        assertNotNull(id);

    }

    @Test
    @DisplayName("Авторизация с пустым паролем")
    @Description("Авторизация с пустым паролем. Код ответа 400")
    public void authenticationNullPasswordCourierTest(){

        final Courier courier = new Courier(login, "", null);

        String message = client.getIdCourier(courier)
                .then()
                .statusCode(400)
                .extract()
                .path("message");

        assertEquals(message,"Недостаточно данных для входа");
    }

    @Test
    @DisplayName("Авторизация с невалидными данными")
    @Description("Авторизация с невалидными данными. Код ответа 404")
    public void authenticationUnCorrectLoginCourierTest(){

        final Courier courier = new Courier("dsafsd", "dafasfasf", null);

        String message = client.getIdCourier(courier)
                .then()
                .statusCode(404)
                .extract()
                .path("message");

        assertEquals(message,"Учетная запись не найдена");
    }

    @Test
    @DisplayName("Авторизация без передачи пароля")
    @Description("Авторизация без передачи пароля. Код ответа 504")
    public void authenticationNullCourierTest(){

        final Courier courier = new Courier(login, null, null);

        client.getIdCourier(courier)
                .then()
                .statusCode(504);
    }


}
