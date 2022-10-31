package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Categories;
import models.CategoriesDao;
import static models.EmployeesDao.rol_user;
import views.SystemView;

public class CategoriesController implements ActionListener, MouseListener, KeyListener {

    private Categories category;
    private CategoriesDao categoryDao;
    private SystemView views;
    String rol = rol_user;
    DefaultTableModel model = new DefaultTableModel();

    public CategoriesController(Categories category, CategoriesDao categoryDao, SystemView views) {
        this.category = category;
        this.categoryDao = categoryDao;
        this.views = views;
        //boton de registrar categoria
        this.views.btn_register_category.addActionListener(this);
        //boton de modificar categoria
        this.views.btn_update_category.addActionListener(this);
        //boton de eliminar categoria
        this.views.btn_delete_category.addActionListener(this);
        this.views.categories_table.addMouseListener(this);
        this.views.txt_search_category.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btn_register_category) {
            if (views.txt_category_name.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                category.setName(views.txt_category_name.getText().trim());

                if (categoryDao.registerCategoryQuery(category)) {
                    cleanTable();
                    cleanFields();
                    listAllCategories();
                    JOptionPane.showMessageDialog(null, "Categoria registrada con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar categoria");
                }
            }
        } else if (e.getSource() == views.btn_update_category) {
            if (views.txt_category_id.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila para continuar");
            } else {
                if (views.txt_category_id.getText().equals("") || views.txt_category_name.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    category.setId(Integer.parseInt(views.txt_category_id.getText()));
                    category.setName(views.txt_category_name.getText().trim());

                    if (categoryDao.updateCategoryQuery(category)) {
                        cleanTable();
                        cleanFields();
                        views.btn_register_category.setEnabled(true);
                        listAllCategories();
                        JOptionPane.showMessageDialog(null, "Categoria modificada con éxito");
                    }
                }

            }
        } else if (e.getSource() == views.btn_delete_category) {
            int row = views.categories_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una categoria para eliminar");

            } else {
                int id = Integer.parseInt(views.categories_table.getValueAt(row, 0).toString());
                int question = JOptionPane.showConfirmDialog(null, "¿ En realidad quieres eliminar esta categoria ? ");

                if (question == 0 && categoryDao.deleteCategoryQuery(id) != false) {
                    cleanTable();
                    cleanFields();
                    views.btn_register_category.setEnabled(true);
                    listAllCategories();
                    JOptionPane.showMessageDialog(null, "Categoria eliminada con éxito");
                    
                }
            }
        }
    }

//Listar categorias
    public void listAllCategories() {
        if (rol.equals("Administrador")) {
            List<Categories> list = categoryDao.listCategoriesQuery(views.txt_search_category.getText());
            model = (DefaultTableModel) views.categories_table.getModel();
            Object[] row = new Object[2];
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getName();
                model.addRow(row);
            }
            views.categories_table.setModel(model);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == views.categories_table){
            int row = views.categories_table.rowAtPoint(e.getPoint());
            views.txt_category_id.setText(views.categories_table.getValueAt(row, 0).toString());
            views.txt_category_name.setText(views.categories_table.getValueAt(row, 1).toString());
            views.btn_register_category.setEnabled(false);
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
        if (e.getSource() == views.txt_search_category);
        //Limpiar tabla
        cleanTable();
        //Listar categorias
        listAllCategories();
    }

    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    public void cleanFields() {
        views.txt_category_id.setText("");
        views.txt_category_name.setText("");
    }
}