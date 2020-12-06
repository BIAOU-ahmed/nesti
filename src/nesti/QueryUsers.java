/**
 * 
 */
package nesti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * @author ahmed
 *
 */
public class QueryUsers extends MyConection {

	public static boolean login(String username, String password) {

		boolean result = false;
		try {

			openConnection();
			String query = "SELECT * FROM `users` WHERE (`UserName`=? or `Email` = ?) AND `Password`=?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, username);
			declaration.setString(2, username);
			declaration.setString(3, password);
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

	public static Users readBy(String username) {
		Users result = null;

		try {

			openConnection();
			String query = "SELECT `UserName`, `Email`, `FirstName`, `LastName`, `City` FROM `users` WHERE (`UserName`=? or `Email` = ?) ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, username);
			declaration.setString(2, username);
			ResultSet resultat = declaration.executeQuery();

			while (resultat.next()) {
				String pseudo = resultat.getString("UserName");
				String email = resultat.getString("Email");
				String firstName = resultat.getString("FirstName");
				String lastName = resultat.getString("LastName");
				String city = resultat.getString("City");
				result = new Users(pseudo, email, firstName, lastName, city);
			}

		} catch (Exception e) {
			System.err.println("Erreur d'affichage de user: " + e.getMessage());
		}

		closeConnection();

		return result;
	}

	public static boolean register(String userName, String email, String password, String firstName, String lastName,
			String city) {
		boolean flag = false;
		if (firstName.isEmpty()) {
			firstName = null;
		}
		if (lastName.isEmpty()) {
			lastName = null;
		}
		if (city.isEmpty()) {
			city = null;
		}

		if (!readByUsername(userName, email)) {
			try {
				openConnection();
				String query = "INSERT INTO `users` (`UserName`, `Email`, `Password`, `FirstName`, `LastName`, `City`) VALUES (?, ?, ?, ?, ?, ?);";
				PreparedStatement declaration = accessDataBase.prepareStatement(query);
				declaration.setString(1, userName);
				declaration.setString(2, email);
				declaration.setString(3, password);
				declaration.setString(4, firstName);
				declaration.setString(5, lastName);
				declaration.setString(6, city);
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

}
