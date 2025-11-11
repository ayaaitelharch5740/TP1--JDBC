/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author ORIGINAL SHOP
 */
import service.EmployeService;
import entities.Employe;

public class TestEmploye {
    public static void main(String[] args) {
        EmployeService svc = new EmployeService();
        try {
            Employe e = new Employe("Maroanin", "Technicien");
            svc.createEmploye(e);
            System.out.println("Employé créé : ID=" + e.getId());

            svc.listEmployes().forEach(emp ->
                System.out.printf("%d : %s [%s]%n", emp.getId(), emp.getNom(), emp.getPoste()));

            e.setPoste("Superviseur");
            System.out.println("Mise à jour OK ? " + svc.updateEmploye(e));

            System.out.println("Suppression OK ? " + svc.deleteEmploye(e));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
