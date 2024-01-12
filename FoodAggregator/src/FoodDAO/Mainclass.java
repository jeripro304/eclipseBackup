package FoodDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		ItemDAO d =new ItemDAO(); 
		boolean flag=true;
		while (flag) {
			System.out.println("********************************");
			System.out.println("1.Add items in the database");
			System.out.println("2.Bulk copy");
			System.out.println("3.Items from the database based on type");
			System.out.println("4.Items from the database based on price");
			System.out.println("5.To Exit");
			System.out.print("Enter your choice : ");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the line : ");
				String line=sc.next();
				String sep[]=line.split(",");
				Double price=new Double(sep[1]);
				Item item=new Item(sep[0],price,sep[2]);
				//System.out.println(item);
				d.addItem(item);
				break;
			case 2:
				System.out.print("Enter the number of items to be added  : ");
				int n=sc.nextInt();
				List<Item> itemList =new ArrayList<>();
				for (int i=0;i<n;i++) {
					System.out.print("enter the line : ");
					String newline=sc.next();
					String se[]=newline.split(",");
					Double costt=new Double(se[1]);
					itemList.add(new Item(se[0],costt,se[2]));
					
				}
				d.bulkCopy(itemList);
				break;
			case 3:
				System.out.print("Enter the type to search for : ");
				String find=sc.next();
				List<Item> Typelist=d.findItem(find);
				if(Typelist.isEmpty())
				{
					System.out.println("There is no type availabe of"+find);
				}
				else
				{
					System.out.format("%-20s %-5s %s\n","Name","Price","Type");
					for(Item i:Typelist)
					{
						System.out.format("%-20s %-5s %s\n",i.getName(),i.getPrice(),i.getType());
					}
				}
				break;
			case 4:
				System.out.print("Enter the price to search :  ");
				Double find_price=sc.nextDouble();
				List<Item> pri=d.findItem_price(find_price);
				if (pri.isEmpty()) {
					System.out.println("There is no type available of in this price :"+find_price);
				}else {
					System.out.format("%-20s %-5s %s\n","Name","Price","Type");
					for(Item i:pri) {
						System.out.format("%-20s %-5s %s\n", i.getName(),i.getPrice(),i.getType());
					}
				}
				break;
			case 5:
				flag=false;
				System.exit(0);
				
			default :
				System.out.println("Invalid Choice");
			}
			
			
		}
		
		

	}

}
