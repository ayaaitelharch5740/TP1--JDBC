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
import service.MachineService;
import service.EmployeService;
import entities.Machine;
import entities.Employe;
import java.util.List;

public class TestMachine {
    public static void main(String[] args) {
        MachineService mSvc = new MachineService();
        EmployeService eSvc = new EmployeService();
        try {
            Employe e = new Employe("Maroanin", "Technicien");
            eSvc.createEmploye(e);

            Machine m = new Machine("TourneuseX", "Usinage", e);
            mSvc.createMachine(m);
            System.out.println("Machine créée ID=" + m.getId());

            List<Machine> machines = mSvc.listMachines();
            machines.forEach(machine ->
                System.out.printf("%d : %s [%s] → Employé=%s (%d)%n",
                    machine.getId(), machine.getNom(), machine.getType(),
                    machine.getEmploye().getNom(), machine.getEmploye().getId()));

            m.setNom("TourneuseX-Pro");
            m.setType("Usinage avancé");
            System.out.println("Update OK ? " + mSvc.updateMachine(m));

            System.out.println("Delete OK ? " + mSvc.deleteMachine(m));
            eSvc.deleteEmploye(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
