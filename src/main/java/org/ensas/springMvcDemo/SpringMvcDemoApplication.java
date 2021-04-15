package org.ensas.springMvcDemo;

import java.util.Date;

import org.ensas.springMvcDemo.dao.PatientRepository;
import org.ensas.springMvcDemo.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcDemoApplication implements CommandLineRunner{

	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"hassan",new Date(),false));
		patientRepository.save(new Patient(null,"hanane",new Date(),true));
		patientRepository.save(new Patient(null,"mohamed",new Date(),false));
		
		patientRepository.findAll().forEach(p->{
			System.out.println(p);
		});
	}

}
