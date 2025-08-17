/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Statement;
import model.Account;
import model.Customer;
import model.Address;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dungc
 */
public class AccountDAO extends DAO {
    public AccountDAO(){
        super();
    }
    public boolean checkLogin(Account account){
        boolean result = false;
        String sql = "SELECT * FROM tblCustomer INNER JOIN tblAccount ON tblCustomer.id = tblAccount.customer_id WHERE username = ? AND password = ?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, account.getUsername());
		ps.setString(2, account.getPassword());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
                    Customer cus = new Customer(rs.getString("name"), rs.getString("tel"), rs.getString("email"));
                    account.setCus(cus);
                    result = true;
		}
	}catch(Exception e) {
            e.printStackTrace();
        }
        return result;
        }
    public boolean addNewAccount(Account account){
        String sql = "SELECT * FROM tblAccount WHERE username = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,account.getUsername());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return false;
            }
            else{
                String sql2 = "INSERT INTO tblCustomer(name,tel,email) VALUES (?,?,?)";
                try{
                    PreparedStatement ps2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
                    ps2.setString(1,account.getCus().getName());
                    ps2.setString(2,account.getCus().getTel());
                    ps2.setString(3, account.getCus().getEmail());


                    ps2.executeUpdate();

                    ResultSet generatedKeys = ps2.getGeneratedKeys();
                    if(generatedKeys.next())
                    {
                        account.getCus().setId(generatedKeys.getInt(1));
                        String sql3 = "INSERT INTO tblAccount(username,password,customer_id) VALUES (?,?,?)";
                        try{
                            PreparedStatement ps3 = con.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
                            ps3.setString(1,account.getUsername());
                            ps3.setString(2, account.getPassword());
                            ps3.setInt(3, account.getCus().getId());
                            
                            ps3.executeUpdate();
                            ResultSet generatedKeys1 = ps3.getGeneratedKeys();
                            if(generatedKeys1.next()){
                                account.setId(generatedKeys1.getInt(1));
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                            return false;
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

