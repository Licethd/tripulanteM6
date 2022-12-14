package fourteam.http;

import fourteam.http.Exception.HttpException;
import fourteam.swagger.parts.Document;
import fourteam.swagger.parts.Path;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import org.jboss.com.sun.net.httpserver.HttpContext;
import org.jboss.com.sun.net.httpserver.HttpExchange;
import org.jboss.com.sun.net.httpserver.HttpServer;
import org.yaml.snakeyaml.Yaml;

public abstract class Rest {

  private static HashMap<String, Controller> controllers = new HashMap<String, Controller>();

  public static void addController(Class RestController) {
    try {
      Controller controller = new Controller(RestController);
      if (controllers.containsKey(controller.getRoute())) {
        throw new RuntimeException("Controller duplicated: " + controller.getRoute() + "");
      }
      controllers.put(controller.getRoute(), controller);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void start() {
    start(80);
  }

  public static void start(int port) {
    HttpServer server;
    System.setProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.StdErrLog");
    System.setProperty("org.eclipse.jetty.LEVEL", "OFF");
    try {
      server = HttpServer.create(new InetSocketAddress(port), 0);
      HttpContext context = server.createContext("/");
      context.setHandler(Rest::RestHandler);
      server.start();
      System.out.println("Server started on port " + port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void RestHandler(HttpExchange t) throws IOException {
    Response response = new Response();
    StringBuilder sb = new StringBuilder();
    InputStream ios = t.getRequestBody();
    int i;
    while ((i = ios.read()) != -1) {
      sb.append((char) i);
    }
    String data = sb.toString();
    onMessage(t, data, response);
    t.sendResponseHeaders(response.getCode(), response.toString().length());
    OutputStream os = t.getResponseBody();
    os.write(response.toString().getBytes());
    os.close();
  }

  private static void onMessage(HttpExchange t, String data, Response response) {
    String url = t.getRequestURI().toString();
    url = url.split("\\?")[0];
    Controller controller = null;
    for (String key : controllers.keySet()) {
      if (url.contains(key)) {
        controller = controllers.get(key);
        break;
      }
    }
    if (controller == null) {
      try {
        Download.handleRequest(t);
      } catch (IOException e) {
        response.setCode(HttpStatus.BAD_GATEWAY);
        response.setBody("Controller not found");
        e.printStackTrace();
      }
      return;
    }
    try {
      controller.onMessage(t, data, response);
    } catch (
      InstantiationException
      | IllegalAccessException
      | IllegalArgumentException
      | InvocationTargetException
      | NoSuchMethodException
      | SecurityException
      | HttpException e
    ) {
      if (e.getCause() instanceof HttpException) {
        response.setCode(((HttpException) e.getCause()).getCode());
        response.setBody(((HttpException) e.getCause()).getMessage());
      } else {
        response.setBody("Internal server error");
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
  }

  public static void createSwagger() {
    Document doc = new Document();
    for (String key : controllers.keySet()) {
      Controller controller = controllers.get(key);
      String tag = controller.getRoute();
      doc.addTag(tag, key + "_descripcion");
      controller
        .getActions()
        .iterator()
        .forEachRemaining(action -> {
          Path po = action.getPathSwagger(controller, tag);
          doc.addPath(po);
        });
    }
    PrintWriter writer;
    try {
      Yaml yaml = new Yaml();
      writer = new PrintWriter("swagger.yaml", "UTF-8");
      yaml.dump(doc.toHasMap(), writer);
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    // return doc.toJSON().toString();
  }
}
