/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientterrainapp;

import java.sql.Connection;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HP G1
 */
public class Client {

    int id;
    String nom;
    int numeroTelephone;
    String adresse;
    ArrayList terrains;

    public Client() {

    }

    public Client(int id, String nom, int numeroTelephone, String adresse) {
        this.id = id;
        this.nom = nom;
        this.numeroTelephone = numeroTelephone;
        this.adresse = adresse;
        this.terrains = new ArrayList();
    }

  
    // Ajouter un client dans la base de donnee

    public void addClient(Client client) {
        String req = "INSERT INTO client(nom_client, tel_client, adr_client) VALUES (?, ?, ?)";
        Database b = new Database();
        b.chargeDriver();
        try {
            Connection con = b.connectionToBD();
            PreparedStatement stmt = con.prepareStatement(req);
            stmt.setString(1, client.nom);
            stmt.setInt(2, client.numeroTelephone);
            stmt.setString(3, client.adresse);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Customer added successfully.");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
//-------------------------------------------------------------------------
    
    
    public ResultSet getAllProducts() {
        ResultSet resultSet = null;
        String query = "SELECT * FROM client"; // Remplacez "products" par le nom de votre table de produits
        Database b = new Database();
        b.chargeDriver();
        try {
            Connection con = b.connectionToBD();
            PreparedStatement stmt = con.prepareStatement(query);
            resultSet = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
// supprimer un client 
    public void delete(int selectedId) {
        String req = "DELETE FROM `client` where `IdClient`=? ";
        Database b = new Database();
        b.chargeDriver();
        try {
            Connection con = b.connectionToBD();
            PreparedStatement stmt = con.prepareStatement(req);
            stmt.setInt(1, selectedId);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer deleted successfully.");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void update(int selectedId, String nom_client, int tel_client, String adr_client) {
        String req = "UPDATE `client` SET `nom_client`=?,`tel_client`=?,`adr_client`=? where `id_client`=? ";
        Database b = new Database();
        b.chargeDriver();
        try {

            Connection con = b.connectionToBD();
            PreparedStatement stmt = con.prepareStatement(req);
            stmt.setString(1, nom_client);
            stmt.setInt(2, tel_client);
            stmt.setString(3, adr_client);
            stmt.setInt(4, selectedId);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Client updated successfully.");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

    }
    
    
    
}
