package ru.yandex.scooter;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.scooter.clients.OrderApiClient;
import ru.yandex.scooter.entity.Order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class AddOrderTests {

    private OrderApiClient client;

    Faker faker = new Faker();
    Date date = new Date();
    Random random = new Random();

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String address = faker.address().fullAddress();
    private String metroStation = faker.address().state();
    private String phone = faker.phoneNumber().phoneNumber();
    private int rentTime = random.nextInt(30);
    private String deliveryDate = new SimpleDateFormat("yyyy-MM-dd").format(date);;
    private String comment = "комментарий";

    private int trackID;


    @Before
    public void setUp(){

        client = new OrderApiClient();
    }

    private final List<String> color;
    private final int statusCode;

    public AddOrderTests(List<String> color, int statusCode) {
        this.color = color;
        this.statusCode = statusCode;
    }


    @Parameterized.Parameters(name = "Iteration #{index} -> color = {0}")
    public static Object[][] getColor(){
        return new Object[][]{
                {List.of("BLACK"),201},
                {List.of("GREY"),201},
                {List.of("BLACK","GREY"),201},
                {List.of(),201}
        };
    }


    @Test
    @DisplayName("Создание заказа с валидными данными")
    @Description("Создание заказа с валидыми данными. Код ответа 201")
    public void addOrderOneColorValidTest(){
        Order order = new Order(firstName,
                lastName,
                address,
                metroStation,
                phone,
                rentTime,
                deliveryDate,
                comment,
                color,
        null, null, null, null, null, null, null, null,null);

        trackID = client.createOrder(order)
                .then()
                .statusCode(statusCode)
                .extract()
                .path("track");

        assertNotNull(trackID);
    }

    @After
    public void cancelledOrder(){
        client.cancelledOrder(trackID)
                .then()
                .statusCode(200);
    }

}
