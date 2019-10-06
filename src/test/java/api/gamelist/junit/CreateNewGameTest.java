package api.gamelist.junit;

import common.BaseTest;
import common.db.blog.BlogSimple;
import features.api.gamelist.CreateNewGameApi;
import io.restassured.response.Response;
import models.features.gamelist.Game;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CreateNewGameTest extends BaseTest {

    private CreateNewGameApi createNewGame = new CreateNewGameApi();
    private Game gameInput = new Game();
    private BlogSimple blogSimple = new BlogSimple();

    @Test
    public void test_create_game_success(){
        gameInput.setId(10);
        gameInput.setAuthor("Donald");
        gameInput.setTitle("Serenity Demo");

        Response response = createNewGame.createNewGame(gameInput);
        softAssertImpl.assertThat("Response code must be 200", response.statusCode(), 200);
        softAssertImpl.assertThat("Text response must be like : Game created with id",response.getBody().asString().contains("Game created with id"), true);
        softAssertImpl.assertAll();
        response.prettyPrint();

    }

    @Test
    public void test_connect_db() throws Exception {
        List<Map<String, Object>> dbResult = blogSimple.getAllUserInfo();
        System.out.println(dbResult.get(0).get("username").toString());


    }

}
