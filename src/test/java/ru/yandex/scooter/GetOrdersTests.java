package ru.yandex.scooter;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.scooter.clients.OrderApiClient;
import ru.yandex.scooter.entity.DataOrder;

import java.io.File;
import java.util.List;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class GetOrdersTests {

    private OrderApiClient client;
    Gson gson = new Gson();

   // File schema = new File("schema.json");

    @Before
    public void setUp(){

        client = new OrderApiClient();
    }

    @Test
    @DisplayName("Получение списка всех заказов")
    @Description("Получение списка всех заказов. Код ответа 200")
    public void getOrdersTest(){
      final DataOrder data =
              client.getOrders()
                .then()
                .statusCode(200)
             .extract().as(DataOrder.class);




        assertNotNull(data);
        assertFalse((data.getOrders()).isEmpty());


        //  .assertThat()
        // .body(JsonSchemaValidator.matchesJsonSchema("schema.json"));
       /* String json = gson.toJson(data);*/
        System.out.println(data.getOrders());
    }

}