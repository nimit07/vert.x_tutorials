package io.vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetServer;
public class HelloWorldVerticle extends AbstractVerticle {

  @Override
  public void start() {
    // Create an TCP server which simply returns "Hello World!" to each request.


  NetServer server = vertx.createNetServer();
  server.connectHandler(socket -> {
  socket.handler(buffer -> {
    System.out.println("I received some bytes: " + buffer.length());
    socket.write("Hello World! ");
  });
});
server.listen(0, "localhost", res -> {
  if (res.succeeded()) {
    System.out.println("Server is now listening on actual port: " + server.actualPort());
  
  } else {
    System.out.println("Failed to bind!");
  }
});
  }
}

