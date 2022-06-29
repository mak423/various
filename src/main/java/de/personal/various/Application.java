package de.personal.various;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;

import com.google.common.base.Stopwatch;
@SpringBootApplication(exclude = BatchAutoConfiguration.class)
public class Application implements CommandLineRunner {


	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
	}

	/**
	 * The program can be run in 2 ways.
	 * 1. With Command Line Arguments to a JAR file (or using Program Arguments in Eclipse).
	 * 2. Using the configuration json files for specific features managed in the application.properties.
	 */
	@Override
	public void run(String... args) throws Exception {
		Stopwatch stopwatch = Stopwatch.createStarted();
	}
}