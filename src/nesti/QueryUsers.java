/**
 * 
 */
package nesti;

import java.sql.PreparedStatement;
import com.lambdaworks.crypto.SCryptUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * @author ahmed
 *
 */
public class QueryUsers extends MyConection {

	/**
	 * function to check if the user exist or not
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password) {

		boolean result = false;
		try {

			openConnection();
			String query = "SELECT * FROM `users` WHERE (`UserName`=? or `Email` = ?) ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, username);
			declaration.setString(2, username);
//			declaration.setString(3, password);
			ResultSet resultat = declaration.executeQuery();
			if (resultat.next()) {
				 boolean matched = SCryptUtil.check(password, resultat.getString(3));
				 
				result = matched;
				System.out.println(result);
			}
			/* Récupération des données */

		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}

		closeConnection();

		return result;
	}

	/**
	 * this function read a user by username or email
	 * @param username
	 * @param email
	 * @return
	 */
	public static boolean readByUsername(String username, String email) {

		boolean result = false;
		try {

			openConnection();
			String query = "SELECT * FROM `users` WHERE (`UserName`=? or `Email` = ?) ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, username);
			declaration.setString(2, email);
			ResultSet resultat = declaration.executeQuery();
			if (resultat.next()) {
				result = true;
			}
			/* Récupération des données */

		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}

		closeConnection();

		return result;
	}

	/**
	 * this function read by username or email and return the user
	 * @param username
	 * @return the user
	 */
	public static Users readBy(String username) {
		Users result = null;

		try {

			openConnection();
			String query = "SELECT * FROM `users` WHERE (`UserName`=? or `Email` = ?) ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, username);
			declaration.setString(2, username);
			ResultSet resultat = declaration.executeQuery();

			while (resultat.next()) {
				String pseudo = resultat.getString(1);
				String email = resultat.getString(2);
				String firstName = resultat.getString(4);
				String lastName = resultat.getString(5);
				String city = resultat.getString(6);
				String password = resultat.getString(3);
				result = new Users(pseudo,password, email, firstName, lastName, city);
			}

		} catch (Exception e) {
			System.err.println("Erreur d'affichage de user: " + e.getMessage());
		}

		closeConnection();

		return result;
	}

	/**
	 * this function register the new user in the data base
	 * @param newUser
	 * @return
	 */
	public static boolean register(Users newUser) {
		boolean flag = false;


	     String generatedSecuredPasswordHash = SCryptUtil.scrypt(newUser.getPassword(), 16, 16, 16);
	        System.out.println(generatedSecuredPasswordHash);
	        
		if (!readByUsername(newUser.getUserName(), newUser.getEmail())) {
			try {
				openConnection();
				String query = "INSERT INTO `users` (`UserName`, `Email`, `Password`, `FirstName`, `LastName`, `City`) VALUES (?, ?, ?, ?, ?, ?);";
				PreparedStatement declaration = accessDataBase.prepareStatement(query);
				declaration.setString(1, newUser.getUserName());
				declaration.setString(2, newUser.getEmail());
				declaration.setString(3, generatedSecuredPasswordHash);
				declaration.setString(4, newUser.getFirstName());
				declaration.setString(5, newUser.getLastName());
				declaration.setString(6, newUser.getCity());
				int executeUpdate = declaration.executeUpdate();

				flag = (executeUpdate == 1);
			} catch (Exception e) {
				System.err.println("Erreur d'insertion d'utilisateur: " + e.getMessage());
			}
			closeConnection();
		} else {
			JOptionPane.showMessageDialog(null, "This username or email is already taken, Choose another one");
		}

		return flag;
	}
	
	
	/**
	 * this function update the user data 
	 * @param newData
	 * @return
	 */
	public static boolean updateById(Users newData) {
		openConnection();
		boolean success = false;

		try {
			String query = "UPDATE `users` SET  `Email` = ?,  `FirstName` = ?, `LastName` = ?, `City` = ? WHERE `users`.`UserName` = ?; ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, newData.getEmail());
			declaration.setString(2, newData.getFirstName());
			declaration.setString(3, newData.getLastName());
			declaration.setString(4, newData.getCity());
			declaration.setString(5, newData.getUserName());
			int executeUpdate = declaration.executeUpdate();
			success = (executeUpdate == 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return success;
	}
	
	/**
	 * this function update the user password
	 * @param newData
	 * @return
	 */
	public static boolean updatePsw(Users newData) {
		openConnection();
		boolean success = false;
		String generatedSecuredPasswordHash = SCryptUtil.scrypt(newData.getPassword(), 16, 16, 16);
		
		try {
			String query = "UPDATE `users` SET `Password` = ? WHERE `users`.`UserName` = ?; ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, generatedSecuredPasswordHash);
			declaration.setString(2, newData.getUserName());
			
			int executeUpdate = declaration.executeUpdate();
			ChangePassword.user.setPassword(generatedSecuredPasswordHash);
			success = (executeUpdate == 1);
			System.out.println(success);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return success;
	}
	

}
