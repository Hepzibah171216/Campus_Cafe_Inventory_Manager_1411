// Main.java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // reading input: provided for you
        Product[] products = new Product[10];  // an array with room for 10 products
        int count = 0;                         // how many products are stored so far
        int choice;
        do {
            System.out.println("\n--- Campus Cafe Inventory ---");
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Total stock value");
            System.out.println("4. Average price");
            System.out.println("5. Restock a product");
            System.out.println("6. Duplicate a product");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();   // clears the leftover newline after nextInt()
            if (choice < 0 || choice > 6) {
                System.out.println("Invalid choice, try again.");
            }
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    if(count==10){
                        System.out.println("Product array is full.");
                    }
                    else if(price<=0 || quantity<0){
                        System.out.println("Invalid price or quantity");
                    }
                    else{
                         products[count] =new Product(name,price,quantity);
                         count++;
                         System.out.println("Product added succesfully");
                    }
                  
                    // TODO: if the array is full (count is 10), print a message
                    // TODO: else if price <= 0 or quantity < 0, print an error message
                    // TODO: otherwise create the Product with the parameterized
                    //       constructor, store it at products[count] and increase count
                    break;
                case 2:
                    if(count==0){
                        System.out.println("No products available");
                    }
                    else{
                        for(int i =0; i<count; i++){
                              System.out.print((i+1) +". ");
                              products[i].display();
                        }
                    }
                              
                    // TODO: if count is 0 print a message, otherwise loop from 0 to
                    //       count - 1 and call display() on each product
                    //       (print the number i + 1 before each one)
                    break;
                case 3:
                    if(count==0){
                        System.out.println("No products available");
                    }
                    else{
                        double total =0;
                        for(int i=0;i<count;i++){
                            total+= products[i].stockValue();
                        }
                        System.out.println("Total stock value: "+total);
                    }
                    break;
                case 4:
                    if(count==0){
                        System.out.println("No products available.");
                    }
                    else{
                        double sum=0;

                        for(int i=0;i<count;i++){
                            sum+=products[i].price;
                        }
                        double average = sum/count;
                        System.out.println("Average price: "+average);
                        System.out.println("Rounded down: "+(int)average);
                    break;
                case 5:
                    System.out.print("Product number: ");
                    int num = sc.nextInt();
                    System.out.print("Quantity to add: ");
                    int extra = sc.nextInt();
                    sc.nextLine();
                    
                    if(num<1 || num>count || extra<=0){
                        System.out.println("Invalid product number or quantity.");
                    }
                    else{
                        products[num - 1].quantity+ =extra;
                        System.out.println("Product restocked successfully.");
                    }
                    break;
                case 6:
                    System.out.print("Product number: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    if(n<1 ||n>count){
                        System.out.println("Invalid product number.");
                    }
                    else if(count==10){
                        System.out.println("Product array is full.");
                    }
                    else{
                          Product copy = new Product(products[n-1]);
                          copy.name = copy.name+ " (copy)";
                          products[count] = copy;
                          count++;
                          System.out.println("Product duplicated successfully.");
                    }
                  break;
                
                case 0:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (choice != 0);
        System.out.println("Products created in total: " + Product.totalProducts);
    }
}
