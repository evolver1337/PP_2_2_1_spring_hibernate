package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Jon", "Week", "jon@week.com");
      User user2 = new User("Belle", "Oukland", "belle@oukland.com");
      User user3 = new User("Ron", "Makdonald", "weasley@macdonald.com");
      User user4 = new User("Shon", "Wiliam", "shon@wiliam.com");

      Car car1 = new Car("Toyota", 1705);
      Car car2 = new Car("Subaru", 1337);
      Car car3 = new Car("Audi", 7);
      Car car4 = new Car("BMW", 550);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }

      System.out.println(userService.getUserByCar("Toyota", 1705));

      context.close();
   }
}
