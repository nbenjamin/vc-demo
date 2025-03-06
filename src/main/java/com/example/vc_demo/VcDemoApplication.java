package com.example.vc_demo;

import id.walt.crypto.keys.KeyType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VcDemoApplication {

	public static void main(String[] args) {
		KeyType keyType = KeyType.Ed25519;
		SpringApplication.run(VcDemoApplication.class, args);
	}

}
