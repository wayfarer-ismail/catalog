import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.EOFException;
import java.util.Map;
import java.util.HashMap;

public class DatabaseManager {
	// Replace below paths with your full path to users.txt and carts.txt in the project database folder.
	private final String USERS_PATH = "D:\\Documents\\apache-tomcat-9.0.64\\webapps\\catalog\\WEB-INF\\database\\users.txt";
	private final String CARTS_PATH = "D:\\Documents\\apache-tomcat-9.0.64\\webapps\\catalog\\WEB-INF\\database\\carts.txt";


	public Map<String, User> getUsers() {
		try{
			File usersDb = new File(this.USERS_PATH);
			
			if (usersDb.isFile() && usersDb.length() != 0L) {
				FileInputStream fis = new FileInputStream(usersDb);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Map<String, User> users = (Map<String, User>) ois.readObject();
				ois.close();
				return users;
			}
		} catch (FileNotFoundException e) {
			System.out.println("FAILED TO FIND SAVED DATA.");
		} catch (IOException e) {
			System.out.println("FAILED TO SAVE DATA.");
		} catch (Exception e) {
			System.out.println("UNEXPECTED ERROR OCCURED.");
		}
		return new HashMap<>();
	}
	
	public Map<String, Map<CartItem, Integer>> getUserCarts() {
		try{
			File cartsDb = new File(this.CARTS_PATH);
			
			if (cartsDb.isFile() && cartsDb.length() != 0L) {
				FileInputStream fis = new FileInputStream(cartsDb);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Map<String, Map<CartItem, Integer>> userCarts = (Map<String, Map<CartItem, Integer>>) ois.readObject();
				ois.close();
				return userCarts;
			}
		} catch (FileNotFoundException e) {
			System.out.println("FAILED TO FIND SAVED DATA.");
		} catch (IOException e) {
			System.out.println("FAILED TO SAVE DATA.");
		} catch (Exception e) {
			System.out.println("UNEXPECTED ERROR OCCURED.");
		}
		return new HashMap<>();
	}
	
	
	public void writeUsers(Map<String, User> users) {
		try {
			File usersDb = new File(this.USERS_PATH);
			
			if(usersDb.isFile() && usersDb.length() != 0L) {
				usersDb.delete();
				usersDb.createNewFile();
			}
			
			FileOutputStream fos = new FileOutputStream(usersDb);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			
			oos.flush();
			oos.close();
		} catch (IOException e) {
			System.out.println("ERROR SAVING DATA");
		} catch (Exception e) {
			System.out.println("UNEXPECTED ERROR OCCURED.");
		}
	}
	
	public void writeUserCarts(Map<String, Map<CartItem, Integer>> userCarts) {
		try {
			File cartsDb = new File(this.CARTS_PATH);
			
			if(cartsDb.isFile() && cartsDb.length() != 0L) {
				cartsDb.delete();
				cartsDb.createNewFile();
			}
			
			FileOutputStream fos = new FileOutputStream(cartsDb);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userCarts);
			
			oos.flush();
			oos.close();
		} catch (IOException e) {
			System.out.println("ERROR SAVING DATA");
		} catch (Exception e) {
			System.out.println("UNEXPECTED ERROR OCCURED.");
		}
	}
}