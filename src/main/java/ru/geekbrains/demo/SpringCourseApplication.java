package ru.geekbrains.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class SpringCourseApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringCourseApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringCourseApplication.class);
		List<Product> ProductRepository = (List<Product>) context.getBean("ProductRepository");

		while (true) {
		Cart cart = new Cart();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String text = reader.readLine();

		if (text.contains("showAll")) {

			for (int i = 0; i < ProductRepository.size(); i++) {
				System.out.println(ProductRepository.get(i).toString());
			}
		}

		if (text.contains("print")) {
			int id = Integer.parseInt(text.replaceAll("print ", ""));

			if (id < ProductRepository.size() || id > 0) {
				System.out.println(ProductRepository.get(id).toString());
			} else {
				System.out.println("Введен неверный индекс");
			}
		}

		if (text.contains("put")) {
			int id = Integer.parseInt(text.replaceAll("put ", ""));

			if (id < ProductRepository.size() || id > 0) {
				cart.put(ProductRepository.get(id));
			} else {
				System.out.println("Введен неверный индекс");
			}
		}

		if (text.contains("delete")) {
			int id = Integer.parseInt(text.replaceAll("delete ", ""));

			if (id < ProductRepository.size() || id > 0) {
				cart.delete(ProductRepository.get(id));
			} else {
				System.out.println("Введен неверный индекс");
			}
		}

		if (text.equals("inCart")) {
			cart.inCart();
		}

		if (text.contains("newCart")) {
			cart.clear();
			System.out.println("Создана новая корзина");
		}
	}

	}

	@Bean
	public List<Product> ProductRepository() {
		return List.of(new Product(1, "dress", 10000),
				       new Product(2, "skirt", 4000),
				       new Product(3, "shirt", 2000),
				       new Product(4, "hat", 1500),
				       new Product(5, "shoes", 5000));
	}




}
