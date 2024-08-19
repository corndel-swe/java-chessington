package com.corndel.chessington;

import io.javalin.Javalin;
import io.javalin.http.ContentType;
import io.javalin.http.staticfiles.Location;

public class Main {

  // @Override
  // public void start(Stage primaryStage) throws Exception {
  //   Board board = Board.forNewGame();
  //   Game game = new Game(board);
  //   Parent chessBoard = new ChessApp(game);
  //   primaryStage.setTitle("Chessington");
  //   Scene scene = new Scene(new Group());
  //   primaryStage.setScene(scene);
  //   scene.setRoot(chessBoard);
  //   primaryStage.show();
  // }

  public static void main(String[] args) {
    var app = Javalin.create(config -> config.staticFiles.add("/static", Location.CLASSPATH));
    app.get(
        "/",
        ctx -> {
          ctx.contentType(ContentType.TEXT_HTML);
          var inputStream = Main.class.getResourceAsStream("/html/index.html");
          ctx.result(inputStream);
        });
    app.get("/board-data", ctx -> {});
    app.post("/select-piece", ctx -> {});
    app.post("/move-piece", ctx -> {});
    app.start(8080);
  }
}
