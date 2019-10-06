package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CoinItem;

/**
 * Servlet implementation class addCoinServlet
 */
@WebServlet("/addCoinServlet")
public class addCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//add coin to database
		
		//get data from form
		String price = request.getParameter("price");
		String type = request.getParameter("type");
		
		//create new coin item
		CoinItem item = new CoinItem(type,Double.parseDouble(price));
		
		CoinController controller = new CoinController();
		
		//insert into database
		controller.insert(item);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);

	}
	
}
