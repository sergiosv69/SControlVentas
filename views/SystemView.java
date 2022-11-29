package views;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import controllers.CategoriesController;
import controllers.CustomersController;
import controllers.EmployeesController;
import controllers.ProductsController;
import controllers.PurchasesController;
import controllers.SalesController;
import controllers.SettingsController;
import controllers.SuppliersController;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import models.Categories;
import models.CategoriesDao;
import models.Customers;
import models.CustomersDao;
import models.Employees;
import models.EmployeesDao;
import static models.EmployeesDao.full_name_user;
import static models.EmployeesDao.rol_user;
import models.Products;
import models.ProductsDao;
import models.Purchases;
import models.PurchasesDao;
import models.Sales;
import models.SalesDao;
import models.Suppliers;
import models.SuppliersDao;

public class SystemView extends javax.swing.JFrame {

    //Clientes 
    Customers customer = new Customers();
    CustomersDao customersDao = new CustomersDao();

    //proveedores
    Suppliers supplier = new Suppliers();
    SuppliersDao supplierDao = new SuppliersDao();

    //Empleados
    Employees employee = new Employees();
    EmployeesDao employeesDao = new EmployeesDao();

    //Compras 
    Purchases purchase = new Purchases();
    PurchasesDao purchaseDao = new PurchasesDao();
    
    //Ventas 
    Sales sale = new Sales();
    SalesDao saleDao = new SalesDao(); 

    //Categorias
    Categories category = new Categories();
    CategoriesDao categoriesDao = new CategoriesDao();

    //Productos
    Products product = new Products();
    ProductsDao productDao = new ProductsDao();

    public SystemView() {
        initComponents();
        setSize(1208, 680);  //QUE APAREZCA DE ESE TAMAÑO
        setResizable(false); //PARA QUE NO MODIFIQUEN EL TAMAÑO DE LA VENTANA
        setTitle("Panel de administración");  //TITULO A LA VENTANA
        setLocationRelativeTo(null); //CENTRADO
        titleInterface();

        //controlador del Settings
        SettingsController setting = new SettingsController(this);

        this.repaint();

        //Controlador de clientes
        CustomersController customer_account = new CustomersController(customer, customersDao, this);
        customer_account.listAllCustomers();

        //Controlador de empleados
        EmployeesController employee_account = new EmployeesController(employee, employeesDao, this);
        employee_account.listAllEmployees();

        //controlador de proveedores
        SuppliersController supplier_account = new SuppliersController(supplier, supplierDao, this);
        supplier_account.listAllSuppliers();

        //Controlador de compras
        PurchasesController purchase_section = new PurchasesController(purchase, purchaseDao, this);
        purchase_section.listAllPurchases();
        
        //Controlador de ventas
        SalesController sale_section = new SalesController(sale, saleDao, this);
        //sale_section.listAllSales();

        //Controlador de categorias
        CategoriesController category_section = new CategoriesController(category, categoriesDao, this);
        category_section.listAllCategories();

        //Controlador de Productos
        ProductsController product_section = new ProductsController(product, productDao, this);
        product_section.listAllProducts();
    }

    public String titleInterface() {
        setTitle("Panel - " + rol_user);
        label_name_employee.setText(full_name_user);
        label_name_rol.setText(rol_user);
        return rol_user.trim();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelProducts = new javax.swing.JPanel();
        jLabelProducts = new javax.swing.JLabel();
        jPanelPurchases = new javax.swing.JPanel();
        jLabelPurchases = new javax.swing.JLabel();
        jPanelSales = new javax.swing.JPanel();
        jLabelSales = new javax.swing.JLabel();
        jPanelCustomer = new javax.swing.JPanel();
        jLabelCustomers = new javax.swing.JLabel();
        jPanelEmployees = new javax.swing.JPanel();
        jLabelEmployees = new javax.swing.JLabel();
        jPanelSuppliers = new javax.swing.JPanel();
        jLabelSuppliers = new javax.swing.JLabel();
        jPanelCategories = new javax.swing.JPanel();
        jLabelCategories = new javax.swing.JLabel();
        jPanelReports = new javax.swing.JPanel();
        jLabelReports = new javax.swing.JLabel();
        jPanelSettings = new javax.swing.JPanel();
        jLabelSettings = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_photo = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        label_name_rol = new javax.swing.JLabel();
        label_name_employee = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_product_code = new javax.swing.JTextField();
        txt_product_name = new javax.swing.JTextField();
        txt_product_unit_price = new javax.swing.JTextField();
        txt_product_description = new javax.swing.JTextField();
        txt_product_id = new javax.swing.JTextField();
        cmb_product_category = new javax.swing.JComboBox<>();
        btn_register_product = new javax.swing.JButton();
        btn_update_product = new javax.swing.JButton();
        btn_delete_product = new javax.swing.JButton();
        btn_cancel_product = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_search_product = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_purchase_product_code = new javax.swing.JTextField();
        txt_purchase_product_name = new javax.swing.JTextField();
        txt_purchase_amount = new javax.swing.JTextField();
        cmb_purchase_supplier = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_purchase_price = new javax.swing.JTextField();
        txt_purchase_subtotal = new javax.swing.JTextField();
        txt_purchase_id = new javax.swing.JTextField();
        txt_purchase_total_to_pay = new javax.swing.JTextField();
        btn_confirm_purchase = new javax.swing.JButton();
        btn_remove_purchase = new javax.swing.JButton();
        btn_new_purchase = new javax.swing.JButton();
        btn_add_product_to_buy = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        purchases_table = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txt_sales_client_name = new javax.swing.JTextField();
        txt_sales_client_dni = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txt_sales_id = new javax.swing.JTextField();
        txt_sales_total_to_pay = new javax.swing.JTextField();
        btn_add_sales_to_buy = new javax.swing.JButton();
        btn_confirm_sales = new javax.swing.JButton();
        btn_remove_sales = new javax.swing.JButton();
        btn_new_sales = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txt_sales_product_code = new javax.swing.JTextField();
        txt_sales_product_name = new javax.swing.JTextField();
        txt_sales_amount = new javax.swing.JTextField();
        txt_products_amount = new javax.swing.JTextField();
        txt_sales_precio = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        sales_table = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_customer_id = new javax.swing.JTextField();
        txt_customer_fullname = new javax.swing.JTextField();
        txt_customer_address = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_customer_telephone = new javax.swing.JTextField();
        txt_customer_email = new javax.swing.JTextField();
        btn_register_customer = new javax.swing.JButton();
        btn_update_customer = new javax.swing.JButton();
        btn_delete_customer = new javax.swing.JButton();
        btn_cancel_customer = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        customers_table = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        txt_search_customer = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_employee_id = new javax.swing.JTextField();
        txt_employee_fullname = new javax.swing.JTextField();
        txt_employee_username = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txt_employee_address = new javax.swing.JTextField();
        txt_employee_telephone = new javax.swing.JTextField();
        btn_register_employee = new javax.swing.JButton();
        btn_update_employee = new javax.swing.JButton();
        btn_delete_employee = new javax.swing.JButton();
        btn_cancel_employee = new javax.swing.JButton();
        cmb_rol = new javax.swing.JComboBox<>();
        txt_employee_email = new javax.swing.JTextField();
        txt_employee_password = new javax.swing.JPasswordField();
        btn_consultar_employee = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        employees_table = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        txt_search_employee = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_suppliers_telephone = new javax.swing.JTextField();
        txt_suppliers_id = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txt_suppliers_address = new javax.swing.JTextField();
        btn_register_suppliers = new javax.swing.JButton();
        btn_update_suppliers = new javax.swing.JButton();
        btn_delete_suppliers = new javax.swing.JButton();
        btn_cancel_suppliers = new javax.swing.JButton();
        txt_suppliers_email = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txt_suppliers_name = new javax.swing.JTextField();
        txt_suppliers_description = new javax.swing.JTextField();
        cmb_suppliers_city = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        suppliers_table = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        txt_search_suppliers = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txt_category_id = new javax.swing.JTextField();
        txt_category_name = new javax.swing.JTextField();
        btn_register_category = new javax.swing.JButton();
        btn_update_category = new javax.swing.JButton();
        btn_delete_category = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        categories_table = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        txt_search_category = new javax.swing.JTextField();
        Menureportes = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_all_purchases = new javax.swing.JTable();
        Menuconfiguracion = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_id_profile = new javax.swing.JTextField();
        txt_name_profile = new javax.swing.JTextField();
        txt_address_profile = new javax.swing.JTextField();
        txt_phone_profile = new javax.swing.JTextField();
        txt_email_profile = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_password_modify = new javax.swing.JPasswordField();
        txt_password_modify_confirm = new javax.swing.JPasswordField();
        btn_modify_data = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(18, 45, 61));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelProducts.setBackground(new java.awt.Color(18, 45, 61));

        jLabelProducts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelProducts.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/producto.png"))); // NOI18N
        jLabelProducts.setText("  Productos");

        javax.swing.GroupLayout jPanelProductsLayout = new javax.swing.GroupLayout(jPanelProducts);
        jPanelProducts.setLayout(jPanelProductsLayout);
        jPanelProductsLayout.setHorizontalGroup(
            jPanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelProductsLayout.setVerticalGroup(
            jPanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 35));

        jPanelPurchases.setBackground(new java.awt.Color(18, 45, 61));

        jLabelPurchases.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPurchases.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPurchases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ventas.png"))); // NOI18N
        jLabelPurchases.setText("  Compras");

        javax.swing.GroupLayout jPanelPurchasesLayout = new javax.swing.GroupLayout(jPanelPurchases);
        jPanelPurchases.setLayout(jPanelPurchasesLayout);
        jPanelPurchasesLayout.setHorizontalGroup(
            jPanelPurchasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPurchases, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelPurchasesLayout.setVerticalGroup(
            jPanelPurchasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPurchases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelPurchases, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 35));

        jPanelSales.setBackground(new java.awt.Color(18, 45, 61));

        jLabelSales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSales.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales.png"))); // NOI18N
        jLabelSales.setText("   Ventas");
        jLabelSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalesLayout = new javax.swing.GroupLayout(jPanelSales);
        jPanelSales.setLayout(jPanelSalesLayout);
        jPanelSalesLayout.setHorizontalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSales, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelSalesLayout.setVerticalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalesLayout.createSequentialGroup()
                .addComponent(jLabelSales)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 35));

        jPanelCustomer.setBackground(new java.awt.Color(18, 45, 61));

        jLabelCustomers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCustomers.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clientes.png"))); // NOI18N
        jLabelCustomers.setText("  Clientes");

        javax.swing.GroupLayout jPanelCustomerLayout = new javax.swing.GroupLayout(jPanelCustomer);
        jPanelCustomer.setLayout(jPanelCustomerLayout);
        jPanelCustomerLayout.setHorizontalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustomerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelCustomerLayout.setVerticalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustomerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelCustomers))
        );

        jPanel1.add(jPanelCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 35));

        jPanelEmployees.setBackground(new java.awt.Color(18, 45, 61));

        jLabelEmployees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmployees.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empleados.png"))); // NOI18N
        jLabelEmployees.setText("  Empleados");

        javax.swing.GroupLayout jPanelEmployeesLayout = new javax.swing.GroupLayout(jPanelEmployees);
        jPanelEmployees.setLayout(jPanelEmployeesLayout);
        jPanelEmployeesLayout.setHorizontalGroup(
            jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelEmployees, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelEmployeesLayout.setVerticalGroup(
            jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelEmployees, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 200, 35));

        jPanelSuppliers.setBackground(new java.awt.Color(18, 45, 61));

        jLabelSuppliers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSuppliers.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSuppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/proveedores.png"))); // NOI18N
        jLabelSuppliers.setText("  Proveedores");

        javax.swing.GroupLayout jPanelSuppliersLayout = new javax.swing.GroupLayout(jPanelSuppliers);
        jPanelSuppliers.setLayout(jPanelSuppliersLayout);
        jPanelSuppliersLayout.setHorizontalGroup(
            jPanelSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSuppliers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelSuppliersLayout.setVerticalGroup(
            jPanelSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelSuppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, 35));

        jPanelCategories.setBackground(new java.awt.Color(18, 45, 61));

        jLabelCategories.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCategories.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCategories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categorias.png"))); // NOI18N
        jLabelCategories.setText("  Categorias");

        javax.swing.GroupLayout jPanelCategoriesLayout = new javax.swing.GroupLayout(jPanelCategories);
        jPanelCategories.setLayout(jPanelCategoriesLayout);
        jPanelCategoriesLayout.setHorizontalGroup(
            jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelCategoriesLayout.setVerticalGroup(
            jPanelCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelCategories, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 200, 35));

        jPanelReports.setBackground(new java.awt.Color(18, 45, 61));

        jLabelReports.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelReports.setForeground(new java.awt.Color(255, 255, 255));
        jLabelReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reporte.png"))); // NOI18N
        jLabelReports.setText("  Reportes");

        javax.swing.GroupLayout jPanelReportsLayout = new javax.swing.GroupLayout(jPanelReports);
        jPanelReports.setLayout(jPanelReportsLayout);
        jPanelReportsLayout.setHorizontalGroup(
            jPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReportsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelReports, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelReportsLayout.setVerticalGroup(
            jPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReportsLayout.createSequentialGroup()
                .addComponent(jLabelReports)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 200, 35));

        jPanelSettings.setBackground(new java.awt.Color(18, 45, 61));

        jLabelSettings.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSettings.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configuraciones.png"))); // NOI18N
        jLabelSettings.setText("  Configuraciones");

        javax.swing.GroupLayout jPanelSettingsLayout = new javax.swing.GroupLayout(jPanelSettings);
        jPanelSettings.setLayout(jPanelSettingsLayout);
        jPanelSettingsLayout.setHorizontalGroup(
            jPanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSettingsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelSettingsLayout.setVerticalGroup(
            jPanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSettingsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanelSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 200, 35));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 580));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mecanicomenu.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 100));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 100));

        jPanel3.setBackground(new java.awt.Color(18, 45, 61));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MECÁNICA AUTOMOTRIZ JUAN");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 390, 60));

        btn_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mecanico.png"))); // NOI18N
        jPanel3.add(btn_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 80, 80));

        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_logout.setText("Salir");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jPanel3.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 35, -1, 30));

        label_name_rol.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        label_name_rol.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(label_name_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 140, 20));

        label_name_employee.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        label_name_employee.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(label_name_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 140, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1010, 100));

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Código:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Precio de Venta:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Descripción:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Categoría:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Id:");

        txt_product_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_product_codeKeyTyped(evt);
            }
        });

        txt_product_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_product_nameKeyTyped(evt);
            }
        });

        txt_product_unit_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_product_unit_priceKeyTyped(evt);
            }
        });

        txt_product_id.setEditable(false);
        txt_product_id.setEnabled(false);

        btn_register_product.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_register_product.setText("Registrar");

        btn_update_product.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update_product.setText("Modificar");

        btn_delete_product.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete_product.setText("Eliminar");

        btn_cancel_product.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancel_product.setText("Cancelar");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(txt_product_code, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_product_unit_price, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_product_id, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_product_category, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_product_description, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_register_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cancel_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_product_code, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_product_description, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_register_product, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_product_unit_price, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txt_product_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmb_product_category, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_update_product, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete_product, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btn_cancel_product, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 920, 270));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Buscar:");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 70, -1));

        txt_search_product.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel10.add(txt_search_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 160, 30));

        products_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código", "Nombre", "Precio de Venta", "Cantidad", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(products_table);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 930, 180));

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Productos", jPanel4);

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(153, 153, 153));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Código del producto:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Nombre del producto:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Cantidad:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Proveedor:");

        txt_purchase_product_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_purchase_product_codeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_purchase_product_codeKeyTyped(evt);
            }
        });

        txt_purchase_product_name.setEditable(false);

        txt_purchase_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_purchase_amountKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Subtotal:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Precio de Compra:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Id:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Total a pagar:");

        txt_purchase_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_purchase_priceKeyTyped(evt);
            }
        });

        txt_purchase_subtotal.setEditable(false);

        txt_purchase_id.setEditable(false);
        txt_purchase_id.setEnabled(false);

        txt_purchase_total_to_pay.setEditable(false);

        btn_confirm_purchase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_confirm_purchase.setText("Comprar");
        btn_confirm_purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirm_purchaseActionPerformed(evt);
            }
        });

        btn_remove_purchase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_remove_purchase.setText("Eliminar");

        btn_new_purchase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_new_purchase.setText("Nuevo");

        btn_add_product_to_buy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add_product_to_buy.setText("Agregar");
        btn_add_product_to_buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_product_to_buyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(7, 7, 7)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_purchase_product_code, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_purchase_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_purchase_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_purchase_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_purchase_id, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_purchase_total_to_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_purchase_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_purchase_price, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_confirm_purchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_remove_purchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_new_purchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_add_product_to_buy, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_purchase_product_code, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_purchase_price, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add_product_to_buy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_purchase_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(btn_confirm_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_purchase_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_purchase_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txt_purchase_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_remove_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmb_purchase_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txt_purchase_total_to_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_new_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 920, 310));

        purchases_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre del producto", "Cantidad", "Precio", "Subtotal", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(purchases_table);

        jPanel11.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 930, 170));

        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Compras", jPanel5);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("Código del producto:");
        jPanel20.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Dni del Cliente:");
        jPanel20.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setText("Cantidad:");
        jPanel20.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txt_sales_client_name.setEditable(false);
        jPanel20.add(txt_sales_client_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 165, 30));

        txt_sales_client_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sales_client_dniKeyTyped(evt);
            }
        });
        jPanel20.add(txt_sales_client_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 165, 30));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setText("Precio unitario:");
        jPanel20.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("Id:");
        jPanel20.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Total a pagar:");
        jPanel20.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        txt_sales_id.setEditable(false);
        jPanel20.add(txt_sales_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 165, 30));

        txt_sales_total_to_pay.setEditable(false);
        jPanel20.add(txt_sales_total_to_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 165, 30));

        btn_add_sales_to_buy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add_sales_to_buy.setText("Agregar");
        btn_add_sales_to_buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_sales_to_buyActionPerformed(evt);
            }
        });
        jPanel20.add(btn_add_sales_to_buy, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 51, -1, 30));

        btn_confirm_sales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_confirm_sales.setText("Vender");
        btn_confirm_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirm_salesActionPerformed(evt);
            }
        });
        jPanel20.add(btn_confirm_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 112, 89, 30));

        btn_remove_sales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_remove_sales.setText("Eliminar");
        jPanel20.add(btn_remove_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 173, 89, 30));

        btn_new_sales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_new_sales.setText("Nuevo");
        jPanel20.add(btn_new_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 234, 89, 30));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setText("Nombre del producto:");
        jPanel20.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Nombre del cliente:");
        jPanel20.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        txt_sales_product_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sales_product_codeKeyReleased(evt);
            }
        });
        jPanel20.add(txt_sales_product_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 165, 30));

        txt_sales_product_name.setEditable(false);
        jPanel20.add(txt_sales_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 165, 30));

        txt_sales_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sales_amountKeyTyped(evt);
            }
        });
        jPanel20.add(txt_sales_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 75, 30));

        txt_products_amount.setEditable(false);
        txt_products_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_products_amountKeyTyped(evt);
            }
        });
        jPanel20.add(txt_products_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 75, 30));

        txt_sales_precio.setEditable(false);
        jPanel20.add(txt_sales_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 165, 30));

        sales_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre del producto", "Cantidad", "Precio", "Subtotal", "Nombre del cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(sales_table);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jTabbedPane1.addTab("Ventas", jPanel17);

        jPanel14.setBackground(new java.awt.Color(153, 153, 153));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Identificación:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Nombre o Razón Social:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Direccion:");

        txt_customer_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_customer_idKeyTyped(evt);
            }
        });

        txt_customer_fullname.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Correo:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Telefono");

        txt_customer_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_customer_telephoneKeyTyped(evt);
            }
        });

        btn_register_customer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_register_customer.setText("Registrar");
        btn_register_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_register_customerActionPerformed(evt);
            }
        });

        btn_update_customer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update_customer.setText("Modificar");

        btn_delete_customer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete_customer.setText("Eliminar");

        btn_cancel_customer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancel_customer.setText("Cancelar");

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_buscar.setText("Consultar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(82, 82, 82)
                        .addComponent(txt_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(53, 53, 53)
                        .addComponent(txt_customer_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_customer_address, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_customer_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_customer_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_register_customer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_delete_customer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel_customer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_update_customer, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btn_buscar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txt_customer_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btn_buscar)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txt_customer_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_register_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txt_customer_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txt_customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_update_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_cancel_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 920, 310));

        customers_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customers_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Nombre", "Teléfono", "Dirección", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(customers_table);
        if (customers_table.getColumnModel().getColumnCount() > 0) {
            customers_table.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel14.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 930, 110));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Buscar:");
        jPanel14.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));
        jPanel14.add(txt_search_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 160, 30));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1013, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Clientes", jPanel6);

        jPanel18.setBackground(new java.awt.Color(153, 153, 153));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Identificación:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Nombre completo:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Nombre de usuario:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Rol:");

        txt_employee_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_employee_idKeyTyped(evt);
            }
        });

        txt_employee_fullname.setEditable(false);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Teléfono:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Dirección:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Correo:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Contraseña:");

        txt_employee_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_employee_telephoneKeyTyped(evt);
            }
        });

        btn_register_employee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_register_employee.setText("Registrar");
        btn_register_employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_register_employeeActionPerformed(evt);
            }
        });

        btn_update_employee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update_employee.setText("Modificar");

        btn_delete_employee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete_employee.setText("Eliminar");

        btn_cancel_employee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancel_employee.setText("Cancelar");

        cmb_rol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado" }));

        btn_consultar_employee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_consultar_employee.setText("Consultar");
        btn_consultar_employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultar_employeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel35))
                .addGap(25, 25, 25)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_employee_username)
                                .addComponent(cmb_rol, 0, 198, Short.MAX_VALUE)
                                .addComponent(txt_employee_address))
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGap(45, 45, 45)
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel36)
                                        .addComponent(jLabel37)))
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel34)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_employee_email, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addComponent(txt_employee_telephone)
                                .addComponent(txt_employee_password)))
                        .addComponent(txt_employee_fullname))
                    .addComponent(txt_employee_id, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_register_employee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update_employee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete_employee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cancel_employee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_consultar_employee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txt_employee_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txt_employee_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txt_employee_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(txt_employee_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txt_employee_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(txt_employee_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel37)
                    .addComponent(cmb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_employee_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_consultar_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_register_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_update_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_delete_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cancel_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 920, 310));

        employees_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Nombre ", "Usuario", "Dirección", "Teléfono", "Correo", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(employees_table);

        jPanel18.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 930, 110));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Buscar:");
        jPanel18.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));
        jPanel18.add(txt_search_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 160, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Empleados", jPanel7);

        jPanel22.setBackground(new java.awt.Color(153, 153, 153));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("id:");
        jPanel23.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Nombre :");
        jPanel23.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("Correo:");
        jPanel23.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        txt_suppliers_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_suppliers_telephoneKeyTyped(evt);
            }
        });
        jPanel23.add(txt_suppliers_telephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 165, 30));

        txt_suppliers_id.setEditable(false);
        jPanel23.add(txt_suppliers_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 165, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("Teléfono:");
        jPanel23.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("Dirección:");
        jPanel23.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel23.add(txt_suppliers_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 165, 30));

        btn_register_suppliers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_register_suppliers.setText("Registrar");
        btn_register_suppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_register_suppliersActionPerformed(evt);
            }
        });
        jPanel23.add(btn_register_suppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 51, 110, 30));

        btn_update_suppliers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update_suppliers.setText("Modificar");
        jPanel23.add(btn_update_suppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 112, 110, 30));

        btn_delete_suppliers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete_suppliers.setText("Eliminar");
        jPanel23.add(btn_delete_suppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 173, 110, 30));

        btn_cancel_suppliers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancel_suppliers.setText("Cancelar");
        jPanel23.add(btn_cancel_suppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 110, 30));
        jPanel23.add(txt_suppliers_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 160, 30));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("Descripcion:");
        jPanel23.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setText("Ciudad:");
        jPanel23.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));
        jPanel23.add(txt_suppliers_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 165, 30));
        jPanel23.add(txt_suppliers_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 165, 30));

        cmb_suppliers_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "TINGO MARIA", "HUANUCO", "PUCALLPA" }));
        jPanel23.add(cmb_suppliers_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 112, 160, 30));

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 920, 310));

        suppliers_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Nombre ", "Descripcion", "Telefono", "Direccion", "Correo", "ciudad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(suppliers_table);

        jPanel22.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 930, 100));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Buscar:");
        jPanel22.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        txt_search_suppliers.setToolTipText("");
        jPanel22.add(txt_search_suppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 160, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Proveedores", jPanel8);

        jPanel24.setBackground(new java.awt.Color(153, 153, 153));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBackground(new java.awt.Color(204, 204, 204));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Id:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Nombre:");

        txt_category_id.setEditable(false);

        btn_register_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_register_category.setText("Registrar");
        btn_register_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_register_categoryActionPerformed(evt);
            }
        });

        btn_update_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update_category.setText("Modificar");

        btn_delete_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete_category.setText("Eliminar");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txt_category_id, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_category_name, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_update_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_register_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_category_id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_register_category))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txt_category_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_update_category)))
                .addGap(12, 12, 12)
                .addComponent(btn_delete_category)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 460, 360));

        categories_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(categories_table);

        jPanel24.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 440, 290));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Buscar");
        jPanel24.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));
        jPanel24.add(txt_search_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 310, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Categorias", jPanel9);

        Menureportes.setBackground(new java.awt.Color(204, 204, 204));
        Menureportes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Menureportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setText("COMPRAS REALIZADAS");
        Menureportes.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 280, 20));

        table_all_purchases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Factura", "Proveedor", "Total", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table_all_purchases);

        Menureportes.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 910, 380));

        jTabbedPane1.addTab("Reportes", Menureportes);

        Menuconfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Perfil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Identificación:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("Nombre Completo:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("Dirección:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("Teléfono:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("Correo:");

        txt_id_profile.setEditable(false);

        txt_name_profile.setEditable(false);
        txt_name_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_name_profileActionPerformed(evt);
            }
        });

        txt_address_profile.setEditable(false);

        txt_phone_profile.setEditable(false);

        txt_email_profile.setEditable(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Nueva Contraseña:");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Confirmar Contraseña:");

        btn_modify_data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_modify_data.setText("Modificar");
        btn_modify_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modify_dataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_email_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_phone_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_address_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_password_modify_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(txt_password_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(btn_modify_data, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_id_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(txt_password_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modify_data, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txt_name_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(txt_password_modify_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txt_address_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txt_phone_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txt_email_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        Menuconfiguracion.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 920, 390));

        jTabbedPane1.addTab("Perfil", Menuconfiguracion);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 1010, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_register_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_register_customerActionPerformed

    private void btn_register_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_employeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_register_employeeActionPerformed

    private void btn_register_suppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_suppliersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_register_suppliersActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        if (evt.getSource() == btn_logout) {
            dispose();
            LoginView login = new LoginView();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_register_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_register_categoryActionPerformed

    private void txt_name_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_name_profileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_name_profileActionPerformed

    private void btn_modify_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modify_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modify_dataActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        String leerid = txt_customer_id.getText();

        if (leerid.length() == 8) {
            String enlacedni = "https://dniruc.apisperu.com/api/v1/dni/" + leerid + "?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InNhYmlub3Zhc3F1ZXpzZXJnaW9hbmRlcnNvbkBnbWFpbC5jb20ifQ.MIJGPcxZ3EObiB7oMe09JfyZKXouxZnBHrzG-8LFTQc";
            try {
                URL url = new URL(enlacedni);
                URLConnection request = url.openConnection();
                request.connect();

                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject rootobj = root.getAsJsonObject();

                String apellido_paterno = rootobj.get("apellidoPaterno").getAsString();
                String apellido_materno = rootobj.get("apellidoMaterno").getAsString();
                String nombres = rootobj.get("nombres").getAsString();

                txt_customer_fullname.setText("");
                txt_customer_fullname.setText(apellido_paterno + " " + apellido_materno + " " + nombres);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } else if (leerid.length() == 11) {
            String enlaceruc = "https://dniruc.apisperu.com/api/v1/ruc/" + leerid + "?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InNhYmlub3Zhc3F1ZXpzZXJnaW9hbmRlcnNvbkBnbWFpbC5jb20ifQ.MIJGPcxZ3EObiB7oMe09JfyZKXouxZnBHrzG-8LFTQc";
            try {
                URL url = new URL(enlaceruc);
                URLConnection request = url.openConnection();
                request.connect();

                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject rootobj = root.getAsJsonObject();

                String razon_social = rootobj.get("razonSocial").getAsString();
                String direccion = rootobj.get("direccion").getAsString();

                txt_customer_fullname.setText("");
                txt_customer_address.setText("");
                txt_customer_fullname.setText(razon_social);
                txt_customer_address.setText(direccion);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Consulta inválida");
        }


    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_confirm_purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirm_purchaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_confirm_purchaseActionPerformed

    private void btn_consultar_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultar_employeeActionPerformed
        String leerid = txt_employee_id.getText();

        if (leerid.length() == 8) {
            String enlacedni = "https://dniruc.apisperu.com/api/v1/dni/" + leerid + "?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InNhYmlub3Zhc3F1ZXpzZXJnaW9hbmRlcnNvbkBnbWFpbC5jb20ifQ.MIJGPcxZ3EObiB7oMe09JfyZKXouxZnBHrzG-8LFTQc";
            try {
                URL url = new URL(enlacedni);
                URLConnection request = url.openConnection();
                request.connect();

                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject rootobj = root.getAsJsonObject();

                String apellido_paterno = rootobj.get("apellidoPaterno").getAsString();
                String apellido_materno = rootobj.get("apellidoMaterno").getAsString();
                String nombres = rootobj.get("nombres").getAsString();

                txt_employee_fullname.setText("");
                txt_employee_fullname.setText(apellido_paterno + " " + apellido_materno + " " + nombres);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } else if (leerid.length() == 11) {
            String enlaceruc = "https://dniruc.apisperu.com/api/v1/ruc/" + leerid + "?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InNhYmlub3Zhc3F1ZXpzZXJnaW9hbmRlcnNvbkBnbWFpbC5jb20ifQ.MIJGPcxZ3EObiB7oMe09JfyZKXouxZnBHrzG-8LFTQc";
            try {
                URL url = new URL(enlaceruc);
                URLConnection request = url.openConnection();
                request.connect();

                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject rootobj = root.getAsJsonObject();

                String razon_social = rootobj.get("razonSocial").getAsString();
                String direccion = rootobj.get("direccion").getAsString();

                txt_employee_fullname.setText("");
                txt_employee_address.setText("");
                txt_employee_fullname.setText(razon_social);
                txt_employee_address.setText(direccion);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Consulta inválida");
        }
    }//GEN-LAST:event_btn_consultar_employeeActionPerformed

    private void txt_customer_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_customer_idKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txt_customer_idKeyTyped

    private void txt_employee_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_employee_idKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txt_employee_idKeyTyped

    private void txt_product_unit_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_product_unit_priceKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txt_product_unit_priceKeyTyped

    private void txt_product_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_product_nameKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) evt.consume();
    }//GEN-LAST:event_txt_product_nameKeyTyped

    private void txt_purchase_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_purchase_amountKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txt_purchase_amountKeyTyped

    private void txt_purchase_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_purchase_priceKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || c=='.') evt.consume();
    }//GEN-LAST:event_txt_purchase_priceKeyTyped

    private void txt_customer_telephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_customer_telephoneKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txt_customer_telephoneKeyTyped

    private void txt_employee_telephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_employee_telephoneKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txt_employee_telephoneKeyTyped

    private void txt_suppliers_telephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_suppliers_telephoneKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txt_suppliers_telephoneKeyTyped

    private void txt_sales_client_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sales_client_dniKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txt_sales_client_dniKeyTyped

    private void btn_add_sales_to_buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_sales_to_buyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add_sales_to_buyActionPerformed

    private void btn_confirm_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirm_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_confirm_salesActionPerformed

    private void jLabelSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSalesMouseClicked

    private void btn_add_product_to_buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_product_to_buyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add_product_to_buyActionPerformed

    private void txt_sales_product_codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sales_product_codeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sales_product_codeKeyReleased

    private void txt_purchase_product_codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_purchase_product_codeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_purchase_product_codeKeyReleased

    private void txt_sales_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sales_amountKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txt_sales_amountKeyTyped

    private void txt_products_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_products_amountKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_products_amountKeyTyped

    private void txt_product_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_product_codeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_product_codeKeyTyped

    private void txt_purchase_product_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_purchase_product_codeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_purchase_product_codeKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SystemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Menuconfiguracion;
    private javax.swing.JPanel Menureportes;
    public javax.swing.JButton btn_add_product_to_buy;
    public javax.swing.JButton btn_add_sales_to_buy;
    private javax.swing.JButton btn_buscar;
    public javax.swing.JButton btn_cancel_customer;
    public javax.swing.JButton btn_cancel_employee;
    public javax.swing.JButton btn_cancel_product;
    public javax.swing.JButton btn_cancel_suppliers;
    public javax.swing.JButton btn_confirm_purchase;
    public javax.swing.JButton btn_confirm_sales;
    public javax.swing.JButton btn_consultar_employee;
    public javax.swing.JButton btn_delete_category;
    public javax.swing.JButton btn_delete_customer;
    public javax.swing.JButton btn_delete_employee;
    public javax.swing.JButton btn_delete_product;
    public javax.swing.JButton btn_delete_suppliers;
    private javax.swing.JButton btn_logout;
    public javax.swing.JButton btn_modify_data;
    public javax.swing.JButton btn_new_purchase;
    public javax.swing.JButton btn_new_sales;
    private javax.swing.JButton btn_photo;
    public javax.swing.JButton btn_register_category;
    public javax.swing.JButton btn_register_customer;
    public javax.swing.JButton btn_register_employee;
    public javax.swing.JButton btn_register_product;
    public javax.swing.JButton btn_register_suppliers;
    public javax.swing.JButton btn_remove_purchase;
    public javax.swing.JButton btn_remove_sales;
    public javax.swing.JButton btn_update_category;
    public javax.swing.JButton btn_update_customer;
    public javax.swing.JButton btn_update_employee;
    public javax.swing.JButton btn_update_product;
    public javax.swing.JButton btn_update_suppliers;
    public javax.swing.JTable categories_table;
    public javax.swing.JComboBox<Object> cmb_product_category;
    public javax.swing.JComboBox<Object> cmb_purchase_supplier;
    public javax.swing.JComboBox<String> cmb_rol;
    public javax.swing.JComboBox<String> cmb_suppliers_city;
    public javax.swing.JTable customers_table;
    public javax.swing.JTable employees_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelCategories;
    public javax.swing.JLabel jLabelCustomers;
    public javax.swing.JLabel jLabelEmployees;
    public javax.swing.JLabel jLabelProducts;
    public javax.swing.JLabel jLabelPurchases;
    public javax.swing.JLabel jLabelReports;
    public javax.swing.JLabel jLabelSales;
    public javax.swing.JLabel jLabelSettings;
    public javax.swing.JLabel jLabelSuppliers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    public javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    public javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JPanel jPanelCategories;
    public javax.swing.JPanel jPanelCustomer;
    public javax.swing.JPanel jPanelEmployees;
    public javax.swing.JPanel jPanelProducts;
    public javax.swing.JPanel jPanelPurchases;
    public javax.swing.JPanel jPanelReports;
    public javax.swing.JPanel jPanelSales;
    public javax.swing.JPanel jPanelSettings;
    public javax.swing.JPanel jPanelSuppliers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel label_name_employee;
    public javax.swing.JLabel label_name_rol;
    public javax.swing.JTable products_table;
    public javax.swing.JTable purchases_table;
    public javax.swing.JTable sales_table;
    public javax.swing.JTable suppliers_table;
    public javax.swing.JTable table_all_purchases;
    public javax.swing.JTextField txt_address_profile;
    public javax.swing.JTextField txt_category_id;
    public javax.swing.JTextField txt_category_name;
    public javax.swing.JTextField txt_customer_address;
    public javax.swing.JTextField txt_customer_email;
    public javax.swing.JTextField txt_customer_fullname;
    public javax.swing.JTextField txt_customer_id;
    public javax.swing.JTextField txt_customer_telephone;
    public javax.swing.JTextField txt_email_profile;
    public javax.swing.JTextField txt_employee_address;
    public javax.swing.JTextField txt_employee_email;
    public javax.swing.JTextField txt_employee_fullname;
    public javax.swing.JTextField txt_employee_id;
    public javax.swing.JPasswordField txt_employee_password;
    public javax.swing.JTextField txt_employee_telephone;
    public javax.swing.JTextField txt_employee_username;
    public javax.swing.JTextField txt_id_profile;
    public javax.swing.JTextField txt_name_profile;
    public javax.swing.JPasswordField txt_password_modify;
    public javax.swing.JPasswordField txt_password_modify_confirm;
    public javax.swing.JTextField txt_phone_profile;
    public javax.swing.JTextField txt_product_code;
    public javax.swing.JTextField txt_product_description;
    public javax.swing.JTextField txt_product_id;
    public javax.swing.JTextField txt_product_name;
    public javax.swing.JTextField txt_product_unit_price;
    public javax.swing.JTextField txt_products_amount;
    public javax.swing.JTextField txt_purchase_amount;
    public javax.swing.JTextField txt_purchase_id;
    public javax.swing.JTextField txt_purchase_price;
    public javax.swing.JTextField txt_purchase_product_code;
    public javax.swing.JTextField txt_purchase_product_name;
    public javax.swing.JTextField txt_purchase_subtotal;
    public javax.swing.JTextField txt_purchase_total_to_pay;
    public javax.swing.JTextField txt_sales_amount;
    public javax.swing.JTextField txt_sales_client_dni;
    public javax.swing.JTextField txt_sales_client_name;
    public javax.swing.JTextField txt_sales_id;
    public javax.swing.JTextField txt_sales_precio;
    public javax.swing.JTextField txt_sales_product_code;
    public javax.swing.JTextField txt_sales_product_name;
    public javax.swing.JTextField txt_sales_total_to_pay;
    public javax.swing.JTextField txt_search_category;
    public javax.swing.JTextField txt_search_customer;
    public javax.swing.JTextField txt_search_employee;
    public javax.swing.JTextField txt_search_product;
    public javax.swing.JTextField txt_search_suppliers;
    public javax.swing.JTextField txt_suppliers_address;
    public javax.swing.JTextField txt_suppliers_description;
    public javax.swing.JTextField txt_suppliers_email;
    public javax.swing.JTextField txt_suppliers_id;
    public javax.swing.JTextField txt_suppliers_name;
    public javax.swing.JTextField txt_suppliers_telephone;
    // End of variables declaration//GEN-END:variables
}
