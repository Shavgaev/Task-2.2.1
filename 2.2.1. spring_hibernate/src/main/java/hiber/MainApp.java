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
        User user1 = new User("Zhenya", "Shavgaev", "shavgaev@mail.ru");
        User user2 = new User("Semen", "Semenov", "semenov@mail.ru");
        User user3 = new User("Ivan", "Petrov", "petrov@mail.ru");
        User user4 = new User("Katya", "Bochkareva", "bochkareva@mail.ru");
        Car car1 = new Car("Audi", 4);
        Car car2 = new Car("Volvo", 8);
        Car car3 = new Car("Bmw", 3);
        Car car4 = new Car("Omoda", 1);
        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        List a = userService.getUserByCar("Audi", 4);
        System.out.println(a);
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
