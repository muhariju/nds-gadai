package id.co.nds.gadai;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GadaiApplication {
    static final Logger logger = LogManager.getLogger(GadaiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GadaiApplication.class, args);
	}

}
