package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.util.List;

@SpringBootApplication
public class HirewheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HirewheelsApplication.class, args);
		UsersDao usersDao = context.getBean(UsersDao.class);

		Users users1 = new Users();
		users1.setFirstName("Dhirubhai");
		users1.setLastName("Ambani");
		users1.setPassword("password");
		users1.setWalletMoney(150);
		users1.setEmail("c1@gmail.com");
		users1.setMobileNo(998497369);

		Users users2 = new Users();
		users2.setFirstName("RatanJi");
		users2.setLastName("Tata");
		users2.setPassword("password");
		users2.setWalletMoney(180);
		users2.setEmail("c2@gmail.com");
		users2.setMobileNo(998497360 );

		Users users3 = new Users();
		users3.setFirstName("Narayan");
		users3.setLastName("Murthy");
		users3.setPassword("password");
		users3.setWalletMoney(150);
		users3.setEmail("c3@gmail.com");
		users3.setMobileNo(998497361);

		Users users4 = new Users();
		users4.setFirstName("Ritesh");
		users4.setLastName("Agarwal");
		users4.setPassword("password");
		users4.setWalletMoney(120);
		users4.setEmail("c4@gmail.com");
		users4.setMobileNo(998497362);

		Users users5 = new Users();
		users5.setFirstName("Trishneet");
		users5.setLastName("Arora");
		users5.setPassword("password");
		users5.setWalletMoney(150);
		users5.setEmail("c5@gmail.com");
		users5.setMobileNo(998497363);

		usersDao.saveAll(List.of(users1, users2, users3, users4, users5));
       //movieDao.saveAll(List.of(movie1, movie2, movie3, movie4, movie5));


		System.out.println("*************find by first name*************");
		usersDao.findByFirstName("RatanJi")
				.forEach(users -> System.out.println(users.getFirstName()));

		System.out.println("*************find by first name and last name*************");
		usersDao.findByFirstNameOrLastName("Narayan", "")
				.forEach(users -> System.out.println(users.getFirstName()));

		System.out.println("*************find by email*************");
		usersDao.findByEmail(
				"c5@gmail.com")
				.forEach(users -> System.out.println(users.getFirstName()));

		System.out.println("*************find by mobile no *************");
		usersDao.findByMobileNo(998497362)
				.forEach(users -> System.out.println(users.getFirstName()));




	}

}
