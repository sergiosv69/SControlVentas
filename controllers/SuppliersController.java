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
import static models.EmployeesDao.rol_user;
import models.Suppliers;
import models.SuppliersDao;
import views.SystemView;


public class SuppliersController implements ActionListener, MouseListener, KeyListener{
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
        this.views.suppliers_table.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //registrar proveedores
        if(e.getSource()== views.btn_register_suppliers){
            if(views.txt_suppliers_id.getText().equals("")
                || views.txt_suppliers_name.getText().equals("")
                || views.txt_suppliers_description.getText().equals("")
              //|| views.txt_suppliers_ruc.getText().equals("")
                || views.txt_suppliers_address.getText().equals("")
                || views.txt_suppliers_telephone.getText().equals("")
                || views.txt_suppliers_email.getText().equals("")
                || views.cmb_suppliers_city.getSelectedItem().equals("")){
                
                JOptionPane.showMessageDialog(null, "todos los campos son obligatorios");
         
            }else{
                //Realizar insersion
                supplier.setName(views.txt_suppliers_id.getText().trim());
                supplier.setDescription(views.txt_suppliers_name.getText().trim());
                supplier.setDescription(views.txt_suppliers_description.getText().trim());
             // supplier.setDescription(views.txt_suppliers_ruc.getText().trim());
                supplier.setAddress(views.txt_suppliers_address.getText().trim());
                supplier.setTelephone(views.txt_suppliers_telephone.getText().trim());
                supplier.setEmail(views.txt_suppliers_email.getText().trim());
                supplier.setCity(views.cmb_suppliers_city.getSelectedItem().toString());
                
                if(suppliersDao.registerSupplierQuery(supplier)){
                  JOptionPane.showMessageDialog(null, "Proveedor registrado con exito");  
                }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar el proveedor");
                }    
            }            
        
        }
    }

       
                    
    public void listAllSuppliers(){
    //listar proveedores 
        if(rol.equals("Administrador")){
            List<Suppliers> list = suppliersDao.listSuppliersQuery(views.txt_search_suppliers.getText());
            model = (DefaultTableModel) views.suppliers_table.getModel();
            Object[] row = new Object[7];
            for(int i = 0; i < list.size(); i++){
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getName();
                row[2] = list.get(i).getDescription();                
                row[3] = list.get(i).getAddress();
                row[4] = list.get(i).getTelephone();
                row[5] = list.get(i).getEmail();
                row[6] = list.get(i).getCity();
                model.addRow(row);                
            }
            views.suppliers_table.setModel(model);
            
        }
    }        

    @Override
    public void mouseClicked(MouseEvent e) {
         
        if(e.getSource() == views.suppliers_table){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
