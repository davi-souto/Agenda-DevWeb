/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Model.Contato;
import Controller.Agenda;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul
 */
@WebServlet(name = "CadastroServlet", urlPatterns = {"", "/CadastroServlet", "/adicionar", "/remover", "editar", "listar"})
public class CadastroServlet extends HttpServlet {
    Agenda agenda = new Agenda();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastroServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rota = request.getServletPath();
        
        switch(rota){
            case "/adicionar":
                String adicionarHTML = "<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1>Cadastro</h1>\n" +
"        <hr>\n" +
"        <form action=\"CadastroServlet\">\n" +
"            Nome:<input type=\"text\" name=\"nome\"/><br>\n" +
"            Email: <input type=\"text\" name=\"email\"/><br>\n" +
"            Telefone: <input type=\"text\" name=\"telefone\"/><br>\n" +
"            Rua: <input type=\"text\" name=\"rua\"/><br>\n" +
"            Bairro: <input type=\"text\" name=\"bairro\"/><br>\n" +
"            Cidade: <input type=\"text\" name=\"cidade\"/><br>\n" +
"            Estado: <input type=\"text\" name=\"estado\"/><br>\n" +
"            <input type=\"submit\" value=\"Enviar\">\n" +
"        </form>\n" +
"        <a href=\"index.html\">Voltar</a>\n" +
"    </body>\n" +
"</html>";
                break;
            case "/remover":
                response.sendRedirect("index.html");
                break;
            case "/editar":
                int ind = Integer.parseInt(request.getParameter("contato"));
                this.agenda.contatos.remove(ind);
                String editarHTML = "<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1>Cadastro</h1>\n" +
"        <hr>\n" +
"        <form action=\"CadastroServlet\">\n" +
"            Nome:<input type=\"text\" name=\"nome\"/><br>\n" +
"            Email: <input type=\"text\" name=\"email\"/><br>\n" +
"            Telefone: <input type=\"text\" name=\"telefone\"/><br>\n" +
"            Rua: <input type=\"text\" name=\"rua\"/><br>\n" +
"            Bairro: <input type=\"text\" name=\"bairro\"/><br>\n" +
"            Cidade: <input type=\"text\" name=\"cidade\"/><br>\n" +
"            Estado: <input type=\"text\" name=\"estado\"/><br>\n" +
"            <input type=\"submit\" value=\"Enviar\">\n" +
"        </form>\n" +
"        <a href=\"index.html\">Voltar</a>\n" +
"    </body>\n" +
"</html>";
                response.sendRedirect("/Agenda DevWeb/");
                break;
        }
        
    }
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String rota = request.getServletPath();
        switch(rota){
            case "/adicionar":
                this.adicionarContato(request, response);
                break;
            case "/editar":
                this.editarContato(request, response);
                break;
        }
    }

    public void adicionarContato(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String rua = request.getParameter("rua");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        
        agenda.AddContato(nome, email, telefone, rua, bairro, cidade, estado);
        
    }
    
    public void removerContato(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
            int ind = Integer.parseInt(request.getParameter("contato"));
            this.agenda.contatos.remove(ind);
            
            response.sendRedirect("/Agenda Agenda DevWeb/");
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void editarContato(HttpServletRequest request, HttpServletResponse response ) throws IOException {
         
         int indice = Integer.parseInt(request.getParameter("indice"));
         
         String nome = request.getParameter("nome");
         String email = request.getParameter("email");
         String telefone = request.getParameter("telefone");
         String rua = request.getParameter("rua");
         String bairro = request.getParameter("bairro");
         String cidade = request.getParameter("cidade");
         String estado = request.getParameter("estado");
         
         Contato contato = (Contato) this.agenda.contatos.get(indice);
         
         contato.setNome(nome);
         contato.setEmail(email);
         contato.setTelefone(telefone);
         contato.setRua(rua);
         contato.setBairro(bairro);
         contato.setCidade(cidade);
         contato.setEstado(estado);
         
         response.sendRedirect("/Agenda Agenda DevWeb/");
     }
}
