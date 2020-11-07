package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MainApp {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);

		User user1 = new User("Ivan", "Petrov", "petrov58@mail.ru");
		User user2 = new User("John", "Silver", "silver777@gmail.com");
		User user3 = new User("Elon", "Musk", "elonmusk@yandex.ru");

		Car car1 = new Car("Lada", 2101);
		Car car2 = new Car("BMW", 7);
		Car car3 = new Car("Tesla", 333);

		user1.setCar(car1);
		user2.setCar(car2);
		user3.setCar(car3);

		userService.add(user1);
		userService.add(user2);
		userService.add(user3);

		List<User> users = userService.listUsers();
		users.stream().forEach(System.out::println);
		User user = userService.getUserByCar("Tesla", 333);
		System.out.println(user);
		context.close();
	}
}
