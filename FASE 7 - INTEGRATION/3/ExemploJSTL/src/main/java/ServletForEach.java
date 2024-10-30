import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletForEach")
public class ServletForEach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletForEach() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    	ArrayList<String> nomes = new ArrayList<String>();
    	nomes.add("Alexandre");
    	nomes.add("Carlos");
    	req.setAttribute("lista", nomes);
    }


}
