package me.efraimgentil.simpleejbconsumer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.efraimgentil.simple.service.SelectWorldService;
import me.efraimgentil.simple.service.SelectWorldServiceRemote;


@WebServlet(urlPatterns ={ "/simple-hello" } )
public class SimpleHelloServlet extends HttpServlet {

	private static final long serialVersionUID = -5997309121831466595L;
	
	@EJB(lookup="java:global/sampleejb-ear/sampleejb-core-impl-1.0/SelectWorldServiceRemoteImpl") SelectWorldServiceRemote selectWorld;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		writer.write( ""+selectWorld );
		writer.write( selectWorld.selectWorld() );
		writer.flush();
	}
	

}
