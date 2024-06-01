package com.projectcreationhelper.projectcreationhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class ProjectCreationHelperApplication {
	private final Logger logger = Logger.getLogger(ProjectCreationHelperApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ProjectCreationHelperApplication.class, args);
	}

	@EventListener({ApplicationReadyEvent.class})
	void applicationReadyEvent() {
		logger.log(Level.INFO, "Application started... launching browser now");
		browse("http://localhost:8080/swagger-ui/index.html");
	}

	public void browse(String url) {
		if(Desktop.isDesktopSupported()){
			Desktop desktop = Desktop.getDesktop();

			try {
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				logger.log(Level.WARNING, e.getMessage());
			}
		}else{
			Runtime runtime = Runtime.getRuntime();

			try {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e) {
				logger.log(Level.WARNING, e.getMessage());
			}
		}
	}
}
