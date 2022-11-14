package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import models.DynamicCombobox;
import static models.EmployeesDao.rol_user;
import models.Suppliers;
import models.SuppliersDao;
import views.SystemView;

public class SuppliersController implements ActionListener, MouseListener, KeyListener {

    private Suppliers supplier;
    private SuppliersDao suppliersDao;
    private SystemView views;
    String rol = rol_user;

    DefaultTableModel model = new DefaultTableModel();

    public SuppliersController(Suppliers supplier, SuppliersDao supplierDao, SystemView views) {
        this.supplier = supplier;
        this.suppliersDao = supplierDao;
        this.views = views;
        //boton de registro proveedores
        this.views.btn_register_suppliers.addActionListener(this);
        //boton modificar
        this.views.btn_update_suppliers.addActionListener(this);
        //boton eliminar
        this.views.btn_delete_suppliers.addActionListener(this);
        //Boton de cancelar 
        this.views.btn_cancel_suppliers.addActionListener(this);
        this.views.suppliers_table.addMouseListener(this);
        this.views.txt_search_suppliers.addKeyListener(this);
        this.views.jLabelSuppliers.addMouseListener(this);
        getSupplierName();
    }

//registrar proveedores
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btn_register_suppliers) {
            if (views.txt_suppliers_name.getText().equals("")
                    || views.txt_suppliers_description.getText().equals("")
                    //|| views.txt_suppliers_ruc.getText().equals("")
                    || views.txt_suppliers_address.getText().equals("")
                    || views.txt_suppliers_telephone.getText().equals("")
                    || views.txt_suppliers_email.getText().equals("")
                    || views.cmb_suppliers_city.getSelectedItem().equals("")) {

                JOptionPane.showMessageDialog(null, "todos los campos son obligatorios");
            } else {
                //Realizar insersion
                supplier.setName(views.txt_suppliers_name.getText().trim());
                supplier.setDescription(views.txt_suppliers_description.getText().trim());
                // supplier.setDescription(views.txt_suppliers_ruc.getText().trim());
                supplier.setAddress(views.txt_suppliers_address.getText().trim());
                supplier.setTelephone(views.txt_suppliers_telephone.getText().trim());
                supplier.setEmail(views.txt_suppliers_email.getText().trim());
                supplier.setCity(views.cmb_suppliers_city.getSelectedItem().toString());

                if (suppliersDao.registerSupplierQuery(supplier)) {
                    cleanTable();
                    cleanFields();
                    listAllSuppliers();                    
                    JOptionPane.showMessageDialog(null, "Proveedor registrado con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar el proveedor");
                }
            }
            //modificar tabla
        } else if (e.getSource() == views.btn_update_suppliers) {
            if (views.txt_suppliers_id.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila para continuar");
            } else {
                if (views.txt_suppliers_name.getText().equals("")
                        || views.txt_suppliers_address.getText().equals("")
                        || views.txt_suppliers_telephone.getText().equals("")
                        || views.txt_suppliers_email.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "todos los campos son obligatorios");

                } else {

                    supplier.setName(views.txt_suppliers_name.getText().trim());
                    supplier.setDescription(views.txt_suppliers_description.getText().trim());
                    supplier.setAddress(views.txt_suppliers_address.getText().trim());
                    supplier.setTelephone(views.txt_suppliers_telephone.getText().trim());
                    supplier.setEmail(views.txt_suppliers_email.getText().trim());
                    supplier.setCity(views.cmb_suppliers_city.getSelectedItem().toString());
                    supplier.setId(Integer.parseInt(views.txt_suppliers_id.getText()));

                    if (suppliersDao.updateSupplierQuery(supplier)) {
                        //limpiar tabla
                        cleanTable();
                        //limpiar campos
                        cleanFields();
                        listAllSuppliers();
                        views.btn_register_suppliers.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Datos el proveedor modificados con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar los campos del proveedor");
                    }
                }
            }
            //eliminar proveedor
        } else if (e.getSource() == views.btn_delete_suppliers) {
            int row = views.suppliers_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Selecciona un proveedor para eliminar");
            } else {
                int id = Integer.parseInt(views.suppliers_table.getValueAt(row, 0).toString());
                int question = JOptionPane.showConfirmDialog(null, "¿en realidad quieres eliminar este proveedor?");
                if (question == 0 && suppliersDao.deleteSupplierQuery(id) != false) {
                    //limpiar tabla
                    cleanTable();
                    //limpiar campos
                    cleanFields();
                    //listar proveedores
                    listAllSuppliers();
                    JOptionPane.showMessageDialog(null, "proveedor para eliminado con éxito");
                }
            }
        } else if (e.getSource() == views.btn_cancel_suppliers) {
            cleanFields();
            views.btn_register_suppliers.setEnabled(true);
        }
    }

    //listar proveedores                
    public void listAllSuppliers() {
        if (rol.equals("Administrador")) {
            List<Suppliers> list = suppliersDao.listSuppliersQuery(views.txt_search_suppliers.getText());
            model = (DefaultTableModel) views.suppliers_table.getModel();
            Object[] row = new Object[7];
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getName();
                row[2] = list.get(i).getDescription();
                row[3] = list.get(i).getTelephone();
                row[4] = list.get(i).getAddress();
                row[5] = list.get(i).getEmail();
                row[6] = list.get(i).getCity();
                model.addRow(row);
            }
            views.suppliers_table.setModel(model);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == views.suppliers_table) {
            int row = views.suppliers_table.rowAtPoint(e.getPoint());
            views.txt_suppliers_id.setText(views.suppliers_table.getValueAt(row, 0).toString());
            views.txt_suppliers_name.setText(views.suppliers_table.getValueAt(row, 1).toString());
            views.txt_suppliers_description.setText(views.suppliers_table.getValueAt(row, 2).toString());
            views.txt_suppliers_address.setText(views.suppliers_table.getValueAt(row, 3).toString());
            views.txt_suppliers_telephone.setText(views.suppliers_table.getValueAt(row, 4).toString());
            views.txt_suppliers_email.setText(views.suppliers_table.getValueAt(row, 5).toString());
            views.cmb_suppliers_city.setSelectedItem(views.suppliers_table.getValueAt(row, 6).toString());
            //desabilitar botones
            views.btn_register_suppliers.setEnabled(false);
            views.txt_suppliers_id.setEnabled(false);
        } else if (e.getSource() == views.jLabelSuppliers) {
            if (rol.equals("Administrador")) {
                views.jTabbedPane1.setSelectedIndex(4);
                //limpiar tabla
                cleanTable();
                //limpiar campos
                cleanFields();
                //listar proveedores
                listAllSuppliers();
            } else {
                views.jTabbedPane1.setEnabledAt(4, false);
                views.jLabelSuppliers.setEnabled(false);
                JOptionPane.showMessageDialog(null, "no tienes privilegio de Administrador para acceder a esta vista");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txt_search_suppliers) {
            //Lispiar table
            cleanTable();
            //Listar proveedor
            listAllSuppliers();
        }

    }

    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    public void cleanFields() {

        views.txt_suppliers_id.setText("");
        views.txt_suppliers_id.setEditable(true);
        views.txt_suppliers_name.setText("");
        views.txt_suppliers_description.setText("");
        views.txt_suppliers_address.setText("");
        views.txt_suppliers_telephone.setText("");
        views.txt_suppliers_email.setText("");
        views.cmb_suppliers_city.setSelectedIndex(0);
    }

    //Metodo para mostrar el nombre del proveedor
    public void getSupplierName() {
        List<Suppliers> list = suppliersDao.listSuppliersQuery(views.txt_search_suppliers.getText());
        for (int i = 0; i < list.size(); i++) {
            int id = list.get(i).getId();
            String name = list.get(i).getName();
            views.cmb_purchase_supplier.addItem(new DynamicCombobox(id, name));
        }
    }
}
