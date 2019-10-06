package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CoinItem;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String act = request.getParameter("doThis");
		if (act == null) {
			//if no item selected, just go back to view page
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").
			forward(request, response);
		} else if (act.equals("delete")) {
			
			CoinController controller = new CoinController();	
			
			//get data to delete
			int idNumber = Integer.parseInt(request.getParameter("id"));
			CoinItem item = controller.searchById(idNumber);
			
			//delete from database
			controller.delete(item);
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			
		} else if (act.equals("edit")) {
			CoinController controller = new CoinController();
			
			//get id to edit
			int integerId = Integer.parseInt(request.getParameter("id"));
			CoinItem edit = controller.searchById(integerId);
			
			//send to edit from to edit
			request.setAttribute("itemToEdit", edit);
			getServletContext().getRequestDispatcher("/edititem.jsp").forward(request, response);
			
			
		} else if (act.equals("add")) {
			//forward to main page for add
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
