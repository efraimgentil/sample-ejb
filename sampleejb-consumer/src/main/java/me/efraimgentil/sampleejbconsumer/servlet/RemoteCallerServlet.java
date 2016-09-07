package me.efraimgentil.sampleejbconsumer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.efraimgentil.sampleejb.core.service.SelectWorldService;
import me.efraimgentil.sampleejb.core.service.SelectWorldServiceRemote;
import me.efraimgentil.sampleejbconsumer.KnownEJBS;


@WebServlet(urlPatterns ={ "/remote-caller" } )
public class RemoteCallerServlet extends HttpServlet {

	private static final long serialVersionUID = -5997309121831466595L;
	
	@EJB(lookup= KnownEJBS.SelectWorldServiceRemote ) SelectWorldServiceRemote selectWorld;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		writer.write( ""+selectWorld );
		writer.write( selectWorld.selectWorld() );
		writer.flush();
	}
	

}
