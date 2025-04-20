/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientterrainapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author HP G1
 */
public class Terrain extends Database {

    int id;
    String adr_terrain;
    float superficie;
    String nom_vendeur;
    public Client client;

    public Terrain() {
    }

    public Terrain(int id, String adr_terrain, float superficie, String nom_vendeur, Client client) {
        this.id = id;
        this.adr_terrain = adr_terrain;
        this.superficie = superficie;
        this.nom_vendeur = nom_vendeur;
        this.client = client;
    }

    public ResultSet getAllProducts() {
        ResultSet resultSet = null;
        String query = "SELECT * FROM terrain"; // Remplacez "products" par le nom de votre table de produits
        chargeDriver();
        try {
            Connection con = connectionToBD();
            PreparedStatement stmt = con.prepareStatement(query);
            resultSet = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void load(JComboBox<String> comboBox) {
        String query = "SELECT * FROM client";
        chargeDriver();
        try {
            Connection con = connectionToBD();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            comboBox.removeAllItems(); // Clear existing items
            while (rs.next()) {
                String id = rs.getString("id_client");
                comboBox.addItem(id);
            }

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void addTerrain(Terrain terrain) {
        String query = "INSERT INTO `terrain`(`nom_vendeur`, `adr_terrain`, `superficie`, `id_client`) VALUES (?,?,?,?);";
        chargeDriver();
        try {
            Connection con = connectionToBD();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, terrain.nom_vendeur);
            stmt.setString(2, terrain.adr_terrain);
            stmt.setFloat(3, terrain.superficie);
            stmt.setInt(4, terrain.client.id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Terrain added successfully.");

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "ERREUR!!!!!");

        }
    }

    public void updateTerrain(Terrain terrain, int id_terrain) {
        String query = "UPDATE `terrain` SET `nom_vendeur`=?,`adr_terrain`=?,`superficie`=?,`id_client`=? WHERE id_terrain=?;";
        chargeDriver();
        try {
            Connection con = connectionToBD();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, terrain.nom_vendeur);
            stmt.setString(2, terrain.adr_terrain);
            stmt.setFloat(3, terrain.superficie);
            stmt.setInt(4, terrain.client.id);
            stmt.setInt(5, id_terrain);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Terrain updated successfully.");

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "ERREUR!!!!!");

        }
    }

    public void deleteTerrain(int id_terrain) {
        String query = "DELETE FROM `terrain` WHERE id_terrain=?";
        chargeDriver();
        try {
            Connection con = connectionToBD();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id_terrain);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item deleted.");

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "ERREUR!!!!!");

        }
    }

}
