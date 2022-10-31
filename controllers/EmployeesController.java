package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import models.Employees;
import models.EmployeesDao;
import static models.EmployeesDao.rol_user;
import views.SystemView;
import javax.swing.table.DefaultTableModel;
import static models.EmployeesDao.id_user;

public class EmployeesController implements ActionListener, MouseListener, KeyListener {

    private Employees employee;
    private EmployeesDao employeeDao;
    private SystemView views;
    //Rol
    String rol = rol_user;
    DefaultTableModel model = new DefaultTableModel();  //Para interactuar con la tabla

    //Constructor
    public EmployeesController(Employees employee, EmployeesDao employeeDao, SystemView views) {
        this.employee = employee;
        this.employeeDao = employeeDao;
        this.views = views;
        //Boton de registrar empleado
        this.views.btn_register_employee.addActionListener(this);
        
        //Boton de modificar empleado
        this.views.btn_update_employee.addActionListener(this);
        //Boton de eliminar empleado
        this.views.btn_delete_employee.addActionListener(this);
        //Boton de cancelar
        this.views.btn_cancel_employee.addActionListener(this);
        //Boton de cambiar contraseña
        this.views.btn_modify_data.addActionListener(this);
        //Colocar label en escucha
        this.views.jLabelEmployees.addMouseListener(this);
        this.views.employees_table.addMouseListener(this);
        this.views.txt_search_employee.addKeyListener(this);
        //this.views.txt_search_employee.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btn_register_employee) {
            //verificar si los campos estan vacios
            if (views.txt_employee_id.getText().equals("")
                    || views.txt_employee_fullname.getText().equals("")
                    || views.txt_employee_username.getText().equals("")
                    || views.txt_employee_address.getText().equals("")
                    || views.txt_employee_telephone.getText().equals("")
                    || views.txt_employee_email.getText().equals("")
                    || views.cmb_rol.getSelectedItem().toString().equals("")
                    || String.valueOf(views.txt_employee_password.getPassword()).equals("")) {

                JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios");

            } else {
                //Realizar la inserción   .trim()-> no enviar espacios en blanco
                employee.setId(Integer.parseInt(views.txt_employee_id.getText().trim()));
                employee.setFull_name(views.txt_employee_fullname.getText().trim());
                employee.setUsername(views.txt_employee_username.getText().trim());
                employee.setAddress(views.txt_employee_address.getText().trim());
                employee.setTelephone(views.txt_employee_telephone.getText().trim());
                employee.setEmail(views.txt_employee_email.getText().trim());
                employee.setPassword(String.valueOf(views.txt_employee_password.getPassword()));
                employee.setRol(views.cmb_rol.getSelectedItem().toString());

                if (employeeDao.registerEmployeeQuery(employee)) {
                    cleanTable();
                    cleanFields();
                    listAllEmployees();
                    views.btn_register_employee.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Empleado registrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar un empleado");
                }

            }
            //MODIFICAR EMPLEADO
        } else if (e.getSource() == views.btn_update_employee) {
            if (views.txt_employee_id.equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para continuar");
            } else {
                //Verificar si los campos estan vacios
                if (views.txt_employee_id.getText().equals("")
                        || views.txt_employee_fullname.getText().equals("")
                        || views.cmb_rol.getSelectedItem().toString().equals("")) {

                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    employee.setId(Integer.parseInt(views.txt_employee_id.getText().trim()));
                    employee.setFull_name(views.txt_employee_fullname.getText().trim());
                    employee.setUsername(views.txt_employee_username.getText().trim());
                    employee.setAddress(views.txt_employee_address.getText().trim());
                    employee.setTelephone(views.txt_employee_telephone.getText().trim());
                    employee.setEmail(views.txt_employee_email.getText().trim());
                    employee.setPassword(String.valueOf(views.txt_employee_password.getPassword()));
                    employee.setRol(views.cmb_rol.getSelectedItem().toString());

                    if (employeeDao.updateEmployeesQuery(employee)) {
                        cleanTable();
                        cleanFields();
                        listAllEmployees();
                        views.btn_register_employee.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Datos del empleado modificados con éxito ");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar al empleado ");
                    }
                }

            }

        } else if (e.getSource() == views.btn_delete_employee) {
            //Almacenar la fila seleccionada por el usuario
            int row = views.employees_table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado para eliminar ");
            } else if (views.employees_table.getValueAt(row, 0).equals(id_user)) {
                //No se seleccione a sí mismo
                JOptionPane.showMessageDialog(null, "No puede eliminar al usuario autenticado ");
            } else {
                int id = Integer.parseInt(views.employees_table.getValueAt(row, 0).toString());
                int question = JOptionPane.showConfirmDialog(null, "¿ En realidad quieres eliminar a este empleado ? ");

                if (question == 0 && employeeDao.deleteEmployeeQuery(id) != false) {
                    cleanTable();
                    cleanFields();
                    views.btn_register_employee.setEnabled(true);
                    views.txt_employee_password.setEnabled(true);
                    listAllEmployees();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito ");
                }
            }

        }else if(e.getSource() == views.btn_cancel_employee){
            cleanFields();
            views.btn_register_employee.setEnabled(true);
            views.txt_employee_password.setEnabled(true);
            views.txt_employee_id.setEnabled(true);
            
        }else if(e.getSource() == views.btn_modify_data){
            //Recolectar información de las cajas de password
            String password = String.valueOf(views.txt_password_modify.getPassword());
            String confirm_password = String.valueOf(views.txt_password_modify_confirm.getPassword());
            //Verificar si las cajas de texto estan vacias
            if(!password.equals("") && !confirm_password.equals("")){
                //Verificar que las contraseñas sean iguales
                if(password.equals(confirm_password)){
                    employee.setPassword(String.valueOf(views.txt_password_modify.getPassword()));
                    //Validar que todo salio bien
                    if(employeeDao.updateEmployeePassword(employee) != false){
                        JOptionPane.showMessageDialog(null, "Contraseña modificada con éxito");
                    }else{
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar la contraseña");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
            
            
        }
    }

    //Listar todos los empleados
    public void listAllEmployees() {
        if (rol.equals("Administrador")) {
            List<Employees> list = employeeDao.listEmployeesQuery(views.txt_search_employee.getText());
            model = (DefaultTableModel) views.employees_table.getModel();
            Object[] row = new Object[7];
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getFull_name();
                row[2] = list.get(i).getUsername();
                row[3] = list.get(i).getAddress();
                row[4] = list.get(i).getTelephone();
                row[5] = list.get(i).getEmail();
                row[6] = list.get(i).getRol();
                model.addRow(row);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.employees_table) {
            int row = views.employees_table.rowAtPoint(e.getPoint());

            views.txt_employee_id.setText(views.employees_table.getValueAt(row, 0).toString());
            views.txt_employee_fullname.setText(views.employees_table.getValueAt(row, 1).toString());
            views.txt_employee_username.setText(views.employees_table.getValueAt(row, 2).toString());
            views.txt_employee_address.setText(views.employees_table.getValueAt(row, 3).toString());
            views.txt_employee_telephone.setText(views.employees_table.getValueAt(row, 4).toString());
            views.txt_employee_email.setText(views.employees_table.getValueAt(row, 5).toString());
            views.cmb_rol.setSelectedItem(views.employees_table.getValueAt(row, 6).toString());

            //Desabilitar botones
            views.txt_employee_id.setEditable(false);
            views.txt_employee_password.setEnabled(false);
            views.btn_register_employee.setEnabled(false);
        }else if(e.getSource() == views.jLabelEmployees){
            //Solo para administrador
            if(rol.equals("Administrador")){
                views.jTabbedPane1.setSelectedIndex(3);
                //Limpiar tabla
                cleanTable();
                //Limpiar campos
                cleanFields();
                //listar empleados
                listAllEmployees();
            }else{
                //si no es admi
                views.jTabbedPane1.setEnabledAt(3, false);
                views.jLabelEmployees.setEnabled(false);
                JOptionPane.showMessageDialog(null, "No tienes permiso de administrador para acceder a esta vista");
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txt_search_employee) {
            cleanTable();
            listAllEmployees();
        }
    }

    //Limpiar Campos 
    public void cleanFields() {
        views.txt_employee_id.setText("");
        views.txt_employee_id.setEditable(true);
        views.txt_employee_fullname.setText("");
        views.txt_employee_username.setText("");
        views.txt_employee_address.setText("");
        views.txt_employee_telephone.setText("");
        views.txt_employee_email.setText("");
        views.txt_employee_password.setText("");
        views.cmb_rol.setSelectedIndex(0);
    }

    //Metodo para limpiar la tabla
    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }
}
