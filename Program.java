package capitulo13ExercicioFixacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner entr = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String nameCliente = entr.nextLine();
		System.out.print("E-mail: ");
		String emailCliente = entr.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthCliente = sdf.parse(entr.next());
		System.out.println("Enter order data: ");
		entr.nextLine();
		System.out.print("Status: ");
		String statusCliente = entr.nextLine();
		
		Date momentOrder = sdf2.parse("20/04/2018 11:25:09");
		
		Order pedido1 = new Order(momentOrder, OrderStatus.valueOf(statusCliente), new Client(nameCliente, emailCliente, birthCliente));
		
		System.out.println("How many items to this order?");
		int quant = entr.nextInt();
		
		for (int i=1; i<=quant; i++) {
			System.out.println("Enter #" + i + " item data:");
			entr.nextLine();
			System.out.print("Product name: ");
			String nameProduct = entr.nextLine();
			System.out.print("Product price: ");
			double priceProduct = entr.nextDouble();
			System.out.print("Quantity: ");
			int quantProduct = entr.nextInt();
			OrderItem order = new OrderItem(quantProduct, priceProduct , new Product(nameProduct, priceProduct));
			pedido1.addItem(order);
		}
		
		System.out.println(pedido1);
	}
}
