package com.meusestudos.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.meusestudos.curso.entities.Category;
import com.meusestudos.curso.entities.Order;
import com.meusestudos.curso.entities.OrderItem;
import com.meusestudos.curso.entities.Payment;
import com.meusestudos.curso.entities.Product;
import com.meusestudos.curso.entities.User;
import com.meusestudos.curso.entities.enums.OrderStatus;
import com.meusestudos.curso.repositories.CategoryRepository;
import com.meusestudos.curso.repositories.OrderItemRepository;
import com.meusestudos.curso.repositories.OrderRepository;
import com.meusestudos.curso.repositories.ProductRepository;
import com.meusestudos.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository; // interface que extends JpaRepository
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); // instanciar os objetos
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID,u1);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));// salva no banco virtual

		orderRepository.saveAll(Arrays.asList(o1));
		
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		
		p1.getCategories().add(cat2);
		p1.getCategories().add(cat3);
		p2.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2));
	
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"),o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
	}

}
