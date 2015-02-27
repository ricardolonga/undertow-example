package br.com.ricardolonga.undertow;

import io.undertow.Undertow;
import io.undertow.server.RoutingHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.util.Headers;

public class App {
    public static void main(final String[] args) {
        Undertow.builder()
                .addHttpListener(8080, "localhost")
//                .setHandler(new PathHandler().addExactPath("/", handler -> {
//                    handler.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
//                    handler.getResponseSender().send("Hello World");
//                }).addExactPath("/teste", handler -> {
//                    handler.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
//                    handler.getResponseSender().send("Hello Teste");
//                }))
                .setHandler(new RoutingHandler().get("/", handler -> {
                    handler.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    handler.getResponseSender().send("Hello Teste");
                }))
                .build()
                .start();
        
    }
}