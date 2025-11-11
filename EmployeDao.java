/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ORIGINAL SHOP
 */
import entities.Employe;
import util.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeDao implements IDao<Employe> {
    @Override
    public Employe findById(int id) throws Exception {
        String sql = "SELECT * FROM employe WHERE id=?";
        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("poste"));
                }
                return null;
            }
        }
    }
    @Override
    public List<Employe> findAll() throws Exception {
        String sql = "SELECT * FROM employe";
        List<Employe> list = new ArrayList<>();
        try (Statement st = Connexion.getInstance().getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("poste")));
            }
        }
        return list;
    }
    @Override
    public int insert(Employe e) throws Exception {
        String sql = "INSERT INTO employe(nom,poste) VALUES(?,?)";
        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPoste());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    e.setId(keys.getInt(1));
                    return e.getId();
                }
            }
            return -1;
        }
    }
    @Override
    public boolean update(Employe e) throws Exception {
        String sql = "UPDATE employe SET nom=?, poste=? WHERE id=?";
        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPoste());
            ps.setInt(3, e.getId());
            return ps.executeUpdate() == 1;
        }
    }
    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM employe WHERE id=?";
        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}
