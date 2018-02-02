import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean done = false;

		ArrayList<Car> carGarage = new ArrayList<>();
		carGarage.add(new Car("Nikolai", "Model S", 2017, 54999.90));
		carGarage.add(new Car("Fourd", "Escapade", 2017, 31999.90));
		carGarage.add(new Car("Chewie", "Vette", 2017, 44989.95));
		carGarage.add(new UsedCar("Hyonda", "Prior", 2015, 14795.50, 35987.6));
		carGarage.add(new UsedCar("Toyta", "Camry", 1999, 3555.50, 111952.9));
		carGarage.add(new UsedCar("Benz", "Motorwagen", 1885, 2590660.8, 167.4));
		do {
			int j = 1;
			for (Car i : carGarage) {
				System.out.print(j + ")");
				System.out.println(i);
				j++;
			}
			System.out.println(j + ")" + "Quit");
			int buyCarNum = Validator.getInt(scan, "Which car would you like to buy?: ", 1, j);
			if (buyCarNum == j) {
				System.out.println("Have a great day!");
				done = true;
			} else {
				System.out.println(carGarage.get(buyCarNum - 1));
				System.out.println("To confirm purchase enter \"y\"");
				String confirm = scan.nextLine();
				if (confirm.equalsIgnoreCase("y")) {
					System.out.println("Excellent! Our finance department will be in touch shortly.");
					carGarage.remove(buyCarNum - 1);
				} else {
					continue;
				}
			}
		} while (!done);

	}
}
