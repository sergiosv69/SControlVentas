package models;

public class Sales {

    private int id;
    private int code;
    //private int dni;
    private String product_name;
    private int sale_amount;
    private double sale_price;
    private double sale_subtotal;
    private double total_sale;
    private String created;
     //Var para almacenar el nombre del cliente y compra
    private String sales_name_client;
    private String saler;

    //Constructor
    public Sales() {
    }

    public Sales(int id, int code, String product_name, int sale_amount, double sale_price, double sale_subtotal, double total_sale, String created, String sales_name_client, String saler) {
        this.id = id;
        this.code = code;
        this.product_name = product_name;
        this.sale_amount = sale_amount;
        this.sale_price = sale_price;
        this.sale_subtotal = sale_subtotal;
        this.total_sale = total_sale;
        this.created = created;
        this.sales_name_client = sales_name_client;
        this.saler = saler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getSale_amount() {
        return sale_amount;
    }

    public void setSale_amount(int sale_amount) {
        this.sale_amount = sale_amount;
    }

    public double getSale_price() {
        return sale_price;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }

    public double getSale_subtotal() {
        return sale_subtotal;
    }

    public void setSale_subtotal(double sale_subtotal) {
        this.sale_subtotal = sale_subtotal;
    }

    public double getTotal_sale() {
        return total_sale;
    }

    public void setTotal_sale(double total_sale) {
        this.total_sale = total_sale;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSales_name_client() {
        return sales_name_client;
    }

    public void setSales_name_client(String sales_name_client) {
        this.sales_name_client = sales_name_client;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }
    
   
}
