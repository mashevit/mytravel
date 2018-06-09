package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.travel1.TripBeLocal;

import tr.model.Sightseeing;
import tr.model.Trip;
import tr.model.TripSightseeing;

/**
 * Servlet implementation class TripEditController
 */
@WebServlet("/TripEditController")
public class TripEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(beanName = "TripBe")
	TripBeLocal TBL;
	public static final String tripedit = "/tripedit.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TripEditController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session1 = request.getSession();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		String forward = tripedit;
		List<Trip> trl = TBL.Tripl();
		request.setAttribute("trl", trl);
		if (action.equals("trinit")) {
			// List<Trip> trl = TBL.Tripl();
			request.setAttribute("trl", trl);
		}
		if (action.equals("tslctd")) {
			String Tripid = request.getParameter("tripn");
			// City c = TBL.getCitybyTrip(Tripid);
			// String s=c.getIdcities()+"";
			// request.setAttribute("city", s);
			request.setAttribute("tna", Tripid);// <-----
			request.setAttribute("tripn", Tripid);
			Trip chosent = TBL.getTripbyId(Tripid);

			session1.setAttribute("trid", chosent.getTripDate());
			session1.setAttribute("trm", chosent.getTripMoneyspent() + "");
			session1.setAttribute("trdy", chosent.getTripNumdays() + "");
			session1.setAttribute("trt", chosent.getTrip_numMinTransit() + "");
			session1.setAttribute("triho", chosent.getTripHotel());
		}
		if (action.equals("update")) {
			String Tripid = request.getParameter("tripn");
			// City c = TBL.getCitybyTrip(Tripid);
			// String s=c.getIdcities()+"";
			// request.setAttribute("city", s);
			request.setAttribute("tna", Tripid);// <-----
			request.setAttribute("tripn", Tripid);
			Trip chosent = TBL.getTripbyId(Tripid);
			
			//String ci=request.getParameter("ci");//city
			String trt=request.getParameter("trt");//transit
			String trid=request.getParameter("trid");//date
			String triho=request.getParameter("triho");//hotel
			String trm=request.getParameter("trm");//money
			String trdy=request.getParameter("trdy");//days
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				java.util.Date date = sdf.parse(trid);
				Date sqld = new java.sql.Date(date.getTime());
			TBL.updateTrip(Tripid, sqld, trdy, trm, triho, trt);
			}catch (Exception e) {
				// TODO: handle exception
			}
			session1.setAttribute("trid", chosent.getTripDate());
			session1.setAttribute("trm", chosent.getTripMoneyspent() + "");
			session1.setAttribute("trdy", chosent.getTripNumdays() + "");
			session1.setAttribute("trt", chosent.getTrip_numMinTransit() + "");
			session1.setAttribute("triho", chosent.getTripHotel());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
