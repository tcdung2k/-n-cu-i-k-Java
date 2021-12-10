
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Computer
 */
public class CustomerList {
    private ArrayList<Customer> list = new ArrayList<>();// khai bao truong list de luu customer
    private int currentIndex = -1;
    
    public void firist(){// truy cap toi phan tu dau tien
        if(currentIndex > 0){
            currentIndex =0;
        }
    }
    public void previous(){ //truy cap toi phan tu truoc phan tu hien tai
        if(currentIndex > 0){
            currentIndex --;
        }
    }
    public void next(){ //truy cap toi phan tu tiep theo
        if(currentIndex < list.size() -1){
            currentIndex ++;
        }
    }
    public void last(){  // truy cap toi phan tu cuoi cung
        
           currentIndex = list.size() -1;
        
    }
    public int getCurrentCustomerIndex(){ // tra ve phan tu hien dang dc truy cap
        return currentIndex;
    }
    public Customer getCurrentCustomer(){
        if (list.size()==0)
            return null;
        
        return list.get(currentIndex);
    }  
    
    public void add(Customer ctm){
        list.add(ctm);
    }
    public boolean update(Customer ctm){
        Customer existCtm = findById(ctm.getCustomerId());// tim kiem khach hang trong danh sach dua vao id
        boolean flag = false;
        if(existCtm!= null){
            existCtm.setName(ctm.getName());
            existCtm.setAge(ctm.getAge());
            existCtm.setEmail(ctm.getEmail());
            existCtm.setSex(ctm.getSex());
            existCtm.setSdt(ctm.getSdt());
            existCtm.setAdress(ctm.getAdress());
            
            flag = true;
        }
        return flag;
    }
    public void renderToTable(DefaultTableModel tb1Model){
       tb1Model.setRowCount(0);
        
        for (Customer customer : list) {
            Object[] row = new Object[]  {  
                customer.getCustomerId(), customer.getName(), customer.getAge(), 
                customer.getEmail(), customer.getSex() , customer.getSdt(), customer.getAdress()
            };
            tb1Model.addRow(row);
            }
        tb1Model.fireTableDataChanged(); // bat dau thay doi noi dung hien thi o trong table
        
    }
    public Customer findById(String customerId){
        for (Customer customer : list) {
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
            
        }
        return null;
    }
    public boolean deleteById(String customerId){
        for (Customer customer : list) {
            if (customer.getCustomerId().equals(customerId)){
                list.remove(customer);
                return true;
            }
            
        }
        return false;
    }
}
