package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class SalesDao {

    //Instanciar conexión
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //Metodo de Registrar venta 
    public boolean registerSaleQuery(int customer_id, int employee_id, double total_sale) {
        String query = "INSERT INTO sales (customer_id, employee_id, total_sale, created)"
                + "VALUES (?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, customer_id);
            pst.setInt(2, employee_id);
            pst.setDouble(3, total_sale);
            pst.setTimestamp(4, datetime);
            pst.execute();  //ejecutamos la consulta
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al retornar la venta" + e);
            return false;
        }

    }

    //Metodo para registrar los detalles de la venta
    public boolean registerSaleDetailQuey(int sale_id, int sale_amount, double sale_price, double sale_subtotal, int product_id) {
        String query = " INSERT INTO sale_details (sale_id, sale_amount, sale_price, sale_subtotal, product_id) VALUES(?,?,?,?,?)";

        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, sale_id);
            pst.setInt(2, sale_amount);
            pst.setDouble(3, sale_price);
            pst.setDouble(4, sale_subtotal);
            pst.setInt(5, product_id);
            pst.execute(); //ejecutamos la consulta
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar los detalles de la venta" + e);
            return false;
        }
    }

    //Obteer id de la venta
    public int SaleId() {
        int id = 0;
        String query = "SELECT MAX(id) AS id FROM sales"; //obtener el id maximo de la tabla
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id"); //Asignar el id maximo de la venta
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return id;
    }

    //Listar todas las ventas realizadas 
    public List listAllSaleQuery() {
        List<Sales> list_sale = new ArrayList();
        String query = "SELECT sa.*, cu.full_name AS customer_name FROM sales sa, customers cu WHERE sa.customer_id = cu.id ORDER BY sa.id ASC";
        //SELECT sa.*, cu.name AS sales_name_client, pr.name AS sales_name_product FROM sales sa, customers cu, products pr WHERE sa.customer_id = cu.id ORDER BY sa.id ASC

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Sales sale = new Sales();
                sale.setId(rs.getInt("id"));
                //sale.setSales_name_product(rs.getString(""));
                sale.setSales_name_client(rs.getString("customer_name"));
                sale.setTotal_sale(rs.getDouble("total_sale"));
                sale.setCreated(rs.getString("created"));
                list_sale.add(sale);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list_sale;
    }

    //Listar ventas para limpiar facturas
    public List listSaleDetailQuery(int id) {
        List<Sales> list_sales = new ArrayList();
        String query = "SELECT sa.created, sade.sale_price, sade.sale_amount, sade.sale_subtotal, cu.name AS customer_name,\n"
                + "pro.name AS product_name, em.full_name FROM sales sa INNER JOIN sale_details sade ON sa.id = sade.sale_id\n"
                + "INNER JOIN products pro ON sade.product_id = pro.id INNER JOIN customers cu ON sa.customer_id = cu.id\n"
                + "INNER JOIN employees em ON sa.employee_id = em.id WHERE sa.id = ?";

        try { //llamamos la conexion
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Sales sale = new Sales();
                sale.setProduct_name(rs.getString("product_name"));
                sale.setSale_amount(rs.getInt("sale_amount"));
                sale.setSale_price(rs.getDouble("sale_price"));
                sale.setSale_subtotal(rs.getDouble("sale_subtotal"));
                sale.setSales_name_client(rs.getString("customer_name"));
                sale.setCreated(rs.getString("created"));
                sale.setSaler(rs.getString("full_name"));
                list_sales.add(sale);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list_sales;
    }
}

