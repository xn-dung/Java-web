/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import model.Book;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author dungc
 */
public class BookDAO extends DAO {
    public BookDAO(){
        super();
    }
    
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> result = new ArrayList<Book>();
	String sql = "SELECT * FROM tblBook";
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setAuthor(rs.getString("author"));
                    book.setNumber(rs.getInt("number"));
                    book.setYearOfPublication(rs.getInt("yearOfPublication"));
                    book.setRentalPrice(rs.getInt("rentalPrice"));
                    book.setTitle(rs.getString("title"));
                    if(book.getNumber() > 0) result.add(book);
                    
		}
	}catch(Exception e){
            e.printStackTrace();
	}	
        return result;
    }
    public ArrayList<Book> searchBook(String title){
        ArrayList<Book> result = new ArrayList<Book>();
	String sql = "SELECT * FROM tblBook WHERE title LIKE ?";
	try{
		PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, title);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setAuthor(rs.getString("author"));
                    book.setNumber(rs.getInt("number"));
                    book.setYearOfPublication(rs.getInt("yearOfPublication"));
                    book.setRentalPrice(rs.getInt("rentalPrice"));
                    book.setTitle(rs.getString("title"));
                    if(book.getNumber() > 0) result.add(book);
                    
		}
	}catch(Exception e){
            e.printStackTrace();
	}	
        return result;
    }
    public Book getBookByID(int id){
        String sql = "SELECT * FROM tblBook WHERE id = ?";
	try{
		PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if(rs.next()){
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setAuthor(rs.getString("author"));
                    book.setNumber(rs.getInt("number"));
                    book.setYearOfPublication(rs.getInt("yearOfPublication"));
                    book.setRentalPrice(rs.getInt("rentalPrice"));
                    book.setTitle(rs.getString("title"));
                    return book;
		}
	}catch(Exception e){
            e.printStackTrace();
	}
        return null;
    }
    
}
