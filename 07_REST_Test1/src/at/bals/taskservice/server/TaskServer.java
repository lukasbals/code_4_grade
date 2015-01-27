package at.bals.taskservice.server;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class TaskServer {
	public static void main(String[] args) throws IllegalArgumentException,
			IOException {
		HttpServer server = HttpServerFactory.create("http://localhost:8081/");
		server.start();
	}
}
