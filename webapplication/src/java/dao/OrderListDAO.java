/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author dungc
 */
import java.sql.PreparedStatement;
import model.Order;
import model.OrderList;
import model.Book;
import model.Customer;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
public class OrderListDAO extends DAO {
    public OrderListDAO(){
        super();
    }
    public void insertOrderList(Customer cus, String date, ArrayList<Order> list){
        String sql = "SELECT id FROM tblAddress WHERE customer_id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,cus.getId());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int address_id = rs.getInt("id");
                String sql2 = "INSERT INTO tblOrderList(customer_id,date,address_id) VALUES (?,?,?)";
                try{
                    PreparedStatement ps2 = con.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
                    ps2.setInt(1,cus.getId());
                    ps2.setString(2,date);
                    ps2.setInt(3,address_id);
                    
                    ps2.executeUpdate();
                    ResultSet rs2 = ps2.getGeneratedKeys();
                    if(rs2.next())
                    {
                        int orderlist_id = rs2.getInt(1);
                        String sql3 = "INSERT INTO tblOrder(book_id,quantity,rentalPrice,orderlist_id) VALUES (?,?,?,?)";
                        for(int i = 0; i < list.size(); i++)
                        {
                            try{
                               PreparedStatement ps3 = con.prepareStatement(sql3,Statement.RETURN_GENERATED_KEYS); 
                               ps3.setInt(1,list.get(i).getBook().getId());
                               ps3.setInt(2,list.get(i).getQuantity());
                               ps3.setInt(3,list.get(i).getBook().getRentalPrice());
                               ps3.setInt(4,orderlist_id);
                               
                               
                               ps3.executeUpdate();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
