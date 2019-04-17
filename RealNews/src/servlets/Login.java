package br.usjt.projetoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.usjt.projetoWeb.service.UsuarioService;
import br.usjt.projetoWeb.model.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UsuarioService usuarioService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		usuarioService = new UsuarioService();
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = usuarioService.consultar(email);
		
		if (senha.equals(usuario.getSenha())) {
			response.sendRedirect("index.html"); //logado
		} else {
			request.getRequestDispatcher("login.html"); //volta a pagina inicial
		}
	}

}
