package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class HirewheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HirewheelsApplication.class, args);
		BookingDao bookingDao = context.getBean(BookingDao.class);
		LocationDao locationDao = context.getBean(LocationDao.class);
		VehicleDao vehicleDao = context.getBean(VehicleDao.class);
		UsersDao usersDao = context.getBean(UsersDao.class);
		CityDao cityDao = context.getBean(CityDao.class);
		FuelTypeDao fuelTypeDao = context.getBean(FuelTypeDao.class);
		RoleDao roleDao = context.getBean(RoleDao.class);

		City city = new City();
		city.setCityName("Kharghar");
		city = cityDao.save(city);

		Role role1 = new Role();
		Role role2 = new Role();
		role1.setRoleName("User");
		role2.setRoleName("Admin");
		role1 = roleDao.save(role1);
		role2 = roleDao.save(role2);



		FuelType fuelType = new FuelType();
		fuelType.setFuelType("Diesel");

		fuelType = fuelTypeDao.save(fuelType);

		Location mumbai = new Location();
		mumbai.setLocationName("MUMBAI");
		mumbai.setAddress("Chunabhhatti");
		mumbai.setPincode(231124);
		mumbai.setCity(city);


		mumbai = locationDao.save(mumbai);

		Vehicle car = new Vehicle();
		car.setVehicleModel("Sedan");
		car.setVehicleNumber(01);
		car.setColor("Blue");
		car.setAvailabilityStatus(true);
		car.setFuelType(fuelType);
		car.setVehicleImgUrl("ababab");
        car.setLocation(mumbai);
		car = vehicleDao.save(car);

		Users users1 = new Users();
		users1.setFirstName("Deepender");
		users1.setLastName("Goyal");
		users1.setEmail("dp@gmail.com");
		users1.setPassword("zomato");
		users1.setMobileNo(9999489489l);
		users1.setWalletMoney(500);
		users1.setRole(role2);

		users1 = usersDao.save(users1);

		Users users2 = new Users();
		users2.setFirstName("Larry");
		users2.setLastName("Page");
		users2.setEmail("lp@gmail.com");
		users2.setPassword("google");
		users2.setMobileNo(9943486789l);
		users2.setWalletMoney(500);
		users2.setRole(role1);

		users2 = usersDao.save(users2);

		Users users3 = new Users();
		users3.setFirstName("Sergey");
		users3.setLastName("Brin");
		users3.setEmail("sb@gmail.com");
		users3.setPassword("google");
		users3.setMobileNo(9956489489l);
		users3.setWalletMoney(500);
		users3.setRole(role1);

		users3 = usersDao.save(users3);



		Booking booking1 = new Booking();
		booking1.setPickupDate(LocalDateTime.parse("2016-09-06T12:45:30"));
		booking1.setDropoffDate(LocalDateTime.parse("2016-09-06T12:45:30"));
		booking1.setBookingDate(LocalDateTime.parse("2016-09-06T12:45:30"));
		booking1.setLocation(mumbai);
		booking1.setVehicle(car);
		booking1.setUsers(users1);
		booking1.setAmount(200);
		booking1 = bookingDao.save(booking1);

		System.out.println("**************Cities***********");
		locationDao.findAll().forEach(System.out::println);
		System.out.println("**************Cities***********");
		vehicleDao.findAll().forEach(System.out::println);
		System.out.println("**************Cities***********");
		usersDao.findAll().forEach(System.out::println);


	}

}
