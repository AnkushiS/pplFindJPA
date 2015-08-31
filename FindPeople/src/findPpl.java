
import java.util.List;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

import model.Customer;
import model.City;
import model.Company;
import model.State;

/**
 * Servlet implementation class findPpl
 */
@WebServlet("/findPpl")
public class findPpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findPpl() {
        super();
        // TODO Auto-generated constructor stub
    }
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
	
		String name = request.getParameter("name");
		
		String city_name = "";
		String state_name = "";
		String company_name = "";
		
		// get the value from customers table and rest of the tables
		List<Customer> cust_list = DBtrans.selectCustAll(request.getParameter("name").trim());
		List<City> city = null;
		List<State> states = null;
		List<Company> comps = null;
		
	
		for (int i = 0; i < cust_list.size(); i++){
			city = DBtrans.selectCity(cust_list.get(i).getCityid());
			states = DBtrans.selectState(cust_list.get(i).getStateid());
			comps = DBtrans.selectComp(cust_list.get(i).getCompanyid());
			
		}
		
		for (int i = 0; i < city.size(); i++){
			city_name = city.get(i).getCity();
		}
		
		for (int i = 0; i < states.size(); i++){
			state_name = states.get(i).getState();
		}
		
		for (int i = 0; i < comps.size(); i++){
			company_name = comps.get(i).getCompany();
		}
		
		
		   String line= "";
	        line += "<style>"
					+ ".bs-example{" + "margin-top:20%" + "margin-left:20%"
					+  "margin-bottom:20%" + "}"

					+ "table { " + " table-layout: fixed;"
					+ " word-wrap: break-word;" + "}" + "</style>";
	        
	        
	        line += "<table class=" 
	        		+ "\"table table-striped\"" 
	        		+ "style=width:100%>";
	        
	        line += 
	     			"<tr>" 
					+"<th>" + "title" + "</th><br>"
	     			+"<th>" + "fullname" + "</th><br>"
	     			+"<th>" + "Street Address" + "</th><br>"
	     			+"<th>" + "zipCode" + "</th><br>"
	     			+"<th>" + "email" + "</th><br>"
	     			+"<th>" + "position" + "</th><br>"
	     			+"<th>" + "company" + "</th><br>"
	     			+"<th>" + "city" + "</th><br>"
	     			+"<th>" + "state" + "</th><br>"
	     			+ "</tr>"
	     			;
	        
	        
	        for(int i = 0; i<cust_list.size(); i++){
	        	line += "<tr>" 
	        			+ "<td>" +cust_list.get(i).getTitle() + "</td>"
	        			+ "<td>" +cust_list.get(i).getFullname() + "</td>"
	        			+"<td>" + cust_list.get(i).getStreetaddress() + "</td>"
	        			+"<td>" + cust_list.get(i).getZipcode() + "</td>"
	        			+"<td>" + cust_list.get(i).getEmailaddress() + "</td>"
	        			+"<td>" + cust_list.get(i).getPosition() + "</td>"
		    			;
	        }
	        
	        line += "<td>" + company_name + "</td>"
	        	 + "<td>" + city_name + "</td>"
	        	 + "<td>" + state_name + "</td>"
	        	 + "</tr>"
	        	 ;
	        
	        
		    line += "</table>";
	        
	        request.setAttribute("message", line);
	        getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);	
	       
	        
		}catch (Exception e){
			e.printStackTrace();
		}
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			List<Customer> cust_list = DBtrans.selectCust(request.getParameter("text_name").trim());
		  
	    
	        String line= "";
	        line += "<style>"
					+ ".bs-example{" + "margin-top:20%" + "margin-left:20%"
					+  "margin-bottom:20%" + "}"

					+ "table { " + " table-layout: fixed;"
					+ " word-wrap: break-word;" + "}" + "</style>";
	        
	        
	        line += "<table class=" 
	        		+ "\"table table-striped\"" 
	        		+ "style=width:100%>";
	        
	        line += 
	     			"<tr>" 
	     			+"<th>" + "fullname" + "</th><br>"
	     			+ "</tr>"
	     			;

	     
			for (int i = 0; i < cust_list.size(); i++){
					line += "<tr>" 
							+ "<td><a href= " + "\'" + "findPpl?name="+ URLEncoder.encode(cust_list.get(i).getFullname()) + "\'" + ">"+ cust_list.get(i).getFullname() + "</a></td>"
							+"</tr>"
							;
					
		}
			line += "</table>";
	        
	        request.setAttribute("message", line);
	        getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);	
	       
	        
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
