package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pojo.Contato;
import com.example.pojo.Endereco;

@SpringBootApplication
public class JaxbApplication {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		//SpringApplication.run(JaxbApplication.class, args);
System.out.println("testando");
		Endereco endereco = new Endereco("Rua Moraes", 40, "Centro", "Rio de Janeiro", "20000-000");

		Contato contato = new Contato("Marco Maciel", "M", 34, endereco);
		
		JAXBContext context = JAXBContext.newInstance("com.example.pojo");
		
		//saída 1 – console

        Marshaller m = context.createMarshaller();

        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        m.marshal(contato, System.out);

 

        //saída 2 – arquivo

        File f = new File("src/contato.xml");

        Marshaller m2 = context.createMarshaller();

        m2.marshal(contato, new FileOutputStream(f));       
	}

}
