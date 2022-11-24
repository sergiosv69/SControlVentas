package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Customers;
import models.CustomersDao;
import static models.EmployeesDao.id_user;
import static models.EmployeesDao.rol_user;
import models.Products;
import models.ProductsDao;
import models.Sales;
import models.SalesDao;
import views.Print;
import views.SystemView;

public class SalesController implements KeyListener, ActionListener, MouseListener {

    private Sales sale;
    private SalesDao saleDao;
    private SystemView views;
    private int getIdCustomer = 0;
    private int item = 0;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel temp;

    //Instanciar el modelo de productos
    Products product = new Products();
    ProductsDao productDao = new ProductsDao();
    String rol = rol_user;

    //Instanciar el modelo de clientes
    Customers customer = new Customers();
    CustomersDao customerDao = new CustomersDao();

    public SalesController(Sales sale, SalesDao saleDao, SystemView views) {
        this.sale = sale;
        this.saleDao = saleDao;
        this.views = views;
        //Boton de agregar
        this.views.btn_add_sales_to_buy.addActionListener(this);
        //Boton de comprar
        this.views.btn_confirm_sales.addActionListener(this);
        //boton de eliminar compra
        this.views.btn_remove_sales.addActionListener(this);

        this.views.txt_sales_product_code.addKeyListener(this);
        this.views.txt_sales_client_dni.addKeyListener(this);
        this.views.txt_sales_precio.addKeyListener(this);
        this.views.btn_new_sales.addActionListener(this);
        this.views.jLabelSales.addMouseListener(this);
        this.views.jLabelReports.addMouseListener(this);
        this.views.jLabelSettings.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btn_add_sales_to_buy) {

            //Almacenar la información
            int amount = Integer.parseInt(views.txt_sales_amount.getText());
            String product_name = views.txt_sales_product_name.getText();
            double price = Double.parseDouble(views.txt_sales_precio.getText());
            int sales_id = Integer.parseInt(views.txt_sales_id.getText());
            String customer_name = views.txt_sales_client_name.getText();
            //Verificar si ya se agrego un producto
            if (amount > 0) {
                temp = (DefaultTableModel) views.sales_table.getModel();
                for (int i = 0; i < views.sales_table.getRowCount(); i++) {
                    if (views.sales_table.getValueAt(i, 1).equals(views.txt_sales_product_name.getText())) {
                        JOptionPane.showMessageDialog(null, "El producto ya esta registrado en la tabla de ventas");
                        return;
                    }
                }
                ArrayList list = new ArrayList();
                //Aggregamos cada uno de los items
                item = 1;
                list.add(item);
                list.add(sales_id);
                list.add(product_name);
                list.add(amount);
                list.add(price);
                list.add(amount * price);
                list.add(customer_name);

                Object[] obj = new Object[6];
                obj[0] = list.get(1);
                obj[1] = list.get(2);
                obj[2] = list.get(3);
                obj[3] = list.get(4);
                obj[4] = list.get(5);
                obj[5] = list.get(6);
                temp.addRow(obj);
                views.sales_table.setModel(temp);
                cleanFieldsSales();
                views.txt_sales_product_code.requestFocus();
                views.txt_sales_client_dni.requestFocus();
                calculateSales();
            }

        } else if (e.getSource() == views.btn_confirm_sales) {
            insertSale();
        }
    }

    private void insertSale() {
        double total = Double.parseDouble(views.txt_sales_total_to_pay.getText());
        int emplyee_id = id_user;

        if (saleDao.registerSaleQuery(getIdCustomer, emplyee_id, total)) {
            int sale_id = saleDao.SaleId();
            for (int i = 0; i < views.sales_table.getRowCount(); i++) {
                int product_id = Integer.parseInt(views.sales_table.getValueAt(i, 0).toString());
                int sale_amount = Integer.parseInt(views.sales_table.getValueAt(i, 2).toString());
                double sale_price = Double.parseDouble(views.sales_table.getValueAt(i, 3).toString());
                double sale_subtotal = sale_price * sale_amount;

                //Registrar detalles de la venta
                saleDao.registerSaleDetailQuey(sale_id, sale_amount, sale_price, sale_subtotal, product_id);

                //Traer la cantidad de productos
                product = productDao.searchId(product_id);
                int amount = product.getProduct_quantity() + sale_amount;
                productDao.updateStockQuery(amount, product_id);
            }
            cleanTableTemp();
            JOptionPane.showMessageDialog(null, "venta generada con éxito");
            cleanFieldsSales();
            Print print = new Print(sale_id);
            print.setVisible(true);
        }
    }

    //Metodo para listar las ventas realizadas
    public void listAllSales() {
        if (rol.equals("Administrador") || rol.equals("Empleado")) {
            List<Sales> list = saleDao.listAllSaleQuery();
            model = (DefaultTableModel) views.sales_table.getModel();
            Object[] row = new Object[4];
            //Recorrer con un ciclo for
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getProduct_name();
                row[2] = list.get(i).getTotal_sale();
                row[3] = list.get(i).getSales_name_client();
                row[4] = list.get(i).getCreated();
                model.addRow(row);
            }
            views.sales_table.setModel(model);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //buscar producto
        if (e.getSource() == views.txt_sales_product_code) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                //Si ya se selecciono enter se realizara lo siguiente
                if (views.txt_sales_product_code.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese el código del producto a vender");
                } else {
                    int id = Integer.parseInt(views.txt_sales_product_code.getText());
                    product = productDao.searchCode(id);
                    views.txt_sales_product_name.setText(product.getName());
                    views.txt_sales_id.setText("" + product.getId());
                    views.txt_sales_precio.setText("" + product.getUnit_price());
                    views.txt_sales_amount.requestFocus();

                }
            }
        }
        //buscar cliente

        if (e.getSource() == views.txt_sales_client_dni) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                //Si ya se selecciono enter se realizara lo siguiente
                if (views.txt_sales_client_dni.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese el dni del cliente a vender");
                } else {
                    int id = Integer.parseInt(views.txt_sales_client_dni.getText());
                    customer = customerDao.searchCustomer(id);
                    views.txt_sales_client_name.setText(customer.getFull_name());

                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txt_sales_precio) {
            int quantity;
            double price = 0.0;

            if (views.txt_sales_amount.getText().equals("")) {
                quantity = 1;
                views.txt_sales_precio.setText("" + price);
            } else {
                quantity = Integer.parseInt(views.txt_sales_amount.getText());
                price = Double.parseDouble(views.txt_sales_precio.getText());
                views.txt_sales_total_to_pay.setText("" + quantity * price);

            }
        }
    }

    //Limpiar campos
    public void cleanFieldsSales() {
        views.txt_sales_product_name.setText("");
        views.txt_sales_client_name.setText("");
        views.txt_sales_precio.setText("");
        views.txt_sales_client_dni.setText("");
        views.txt_sales_product_code.setText("");
        views.txt_sales_amount.setText("");
        views.txt_sales_id.setText("");
        views.txt_sales_total_to_pay.setText("");
    }

    //Calcular total a pagar
    public void calculateSales() {
        double total = 0.00;
        int numRow = views.sales_table.getRowCount();

        for (int i = 0; i < numRow; i++) {
            //Pasar el indice de la columna que se sumará
            total = total + Double.parseDouble(String.valueOf(views.sales_table.getValueAt(i, 4)));
        }
        views.txt_sales_total_to_pay.setText("" + total);
    }

    //Limpiar tabla temporal
    public void cleanTableTemp() {
        for (int i = 0; i < temp.getRowCount(); i++) {
            temp.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.jLabelSales) {
            if (rol.equals("Administrador") || rol.equals("Empleado")) {
                views.jTabbedPane1.setSelectedIndex(1);
                cleanTable();

            } else {
                views.jTabbedPane1.setEnabledAt(1, false);
                views.jLabelPurchases.setEnabled(false);
                JOptionPane.showMessageDialog(null, "No tiene privilegios de Administrador para ingresar a esta vista");
            }
        } else if (e.getSource() == views.jLabelReports) {
            views.jTabbedPane1.setSelectedIndex(6);
            cleanTable();
            listAllSales();
        } else if (e.getSource() == views.jLabelSettings) {
            //Solo para administrador
            if (rol.equals("Administrador")) {
                views.jTabbedPane1.setSelectedIndex(7);
                //Limpiar tabla
            } else {
                //si no es admi
                views.jTabbedPane1.setEnabledAt(7, false);
                views.jLabelSettings.setEnabled(false);
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

    //Limpiar tabla
    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

}
