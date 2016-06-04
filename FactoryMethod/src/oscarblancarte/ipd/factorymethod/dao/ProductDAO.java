package oscarblancarte.ipd.factorymethod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oscarblancarte.ipd.factorymethod.IDBAdapter;
import oscarblancarte.ipd.factorymethod.DBFactory;
import oscarblancarte.ipd.factorymethod.entity.Product;

public class ProductDAO {
    
    private IDBAdapter dbAdapter;
    
    public ProductDAO(){
        dbAdapter = DBFactory.getDefaultDBAdapter();
    }
    
    public List<Product> findAllProducts(){
        Connection connection = dbAdapter.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT idProductos,productName"
                            + ",productPrice FROM Productos");
            ResultSet results = statement.executeQuery();
            while(results.next()){
                productList.add(new Product(results.getLong(1), 
                        results.getString(2), results.getDouble(3)));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            try {
                connection.close();
            } catch (Exception e) {}
        }
    }
    
    public boolean saveProduct(Product product){
        Connection connection = dbAdapter.getConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Productos(idProductos,"
                            + "productName,productPrice) VALUES (?,?,?)");
            statement.setLong(1, product.getIdProduct());
            statement.setString(2, product.getProductName());
            statement.setDouble(3, product.getPrice());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                connection.close();
            } catch (Exception e) {}
        }
    }
    
}