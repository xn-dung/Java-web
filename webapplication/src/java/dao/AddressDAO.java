/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Statement;
import model.Address;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author dungc
 */
public class AddressDAO extends DAO {
    public AddressDAO(){
        super();
    }
    public boolean addNewAddress(Address address){
        String sql = "INSERT INTO tblAddress(street,city,country,customer_id) VALUES (?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,address.getStreet());
            ps.setString(2,address.getCity());
            ps.setString(3,address.getCountry());
            ps.setInt(4,address.getCus().getId());
            
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next())
            {
                address.setId(generatedKeys.getInt(1));
                        
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
