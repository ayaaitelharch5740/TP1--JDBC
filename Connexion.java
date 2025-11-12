/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author ORIGINAL SHOP
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connexion {
    private static Connexion instance;
    private final Connection conn;

    // Informations de connexion
    private static final String URL  = "jdbc:mysql://localhost:3306/atelier1?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    // Constructeur privé pour le Singleton
    private Connexion() throws SQLException {
        try {
            // Chargement explicite du driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(" Driver MySQL non trouvé dans le classpath", e);
        }

        // Connexion à la base
        conn = DriverManager.getConnection(URL, USER, PASS);
        conn.setAutoCommit(true);
        System.out.println(" Connexion établie avec succès à la base de données.");
    }

    // Méthode d’accès Singleton
    public static synchronized Connexion getInstance() throws SQLException {
        if (instance == null || instance.conn.isClosed()) {
            instance = new Connexion();
        }
        return instance;
    }

    // Getter pour la connexion
    public Connection getConnection() {
        return conn;
    }
}
