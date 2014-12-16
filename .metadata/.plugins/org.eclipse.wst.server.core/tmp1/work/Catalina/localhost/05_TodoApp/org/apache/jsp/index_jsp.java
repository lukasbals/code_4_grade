/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.57
 * Generated at: 2014-12-16 13:22:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import todos.TodoDAO;
import todos.Todo;
import javax.swing.JOptionPane;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>List</title>\n");
      out.write("<script src=\"./res/js/jquery-1.11.1.min.js\"></script>\n");
      out.write("<script src=\"./res/js/jquery-ui.min.js\"></script>\n");
      out.write("<link href=\"./res/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"./res/css/jquery-ui.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("span[data-type] {\n");
      out.write("\tcursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#toggleDiv {\n");
      out.write("\tdisplay: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container {\n");
      out.write("\tbackground-color: white;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script>\n");
      out.write("\t$(function() {\n");
      out.write("\t\tvar isOpen = true;\n");
      out.write("\t\t$(\"#toggleButton\").click(function() {\n");
      out.write("\t\t\tif (isOpen == true) {\n");
      out.write("\t\t\t\t$(\"#toggleDiv\").slideToggle();\n");
      out.write("\t\t\t\t$(\"#toggleButton\").html(\"Zuklappen...\")\n");
      out.write("\t\t\t\tisOpen = false;\n");
      out.write("\t\t\t} else {\n");
      out.write("\t\t\t\t$(\"#toggleDiv\").slideToggle();\n");
      out.write("\t\t\t\t$(\"#toggleButton\").html(\"Neues Todo\")\n");
      out.write("\t\t\t\tisOpen = true;\n");
      out.write("\t\t\t}\n");
      out.write("\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<p />\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-md-12\">\n");
      out.write("\t\t\t\t<h1 id=\"type\" class=\"page-header\">Todo List</h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-md-12\">\n");
      out.write("\t\t\t\t<button id=\"toggleButton\" type=\"button\"\n");
      out.write("\t\t\t\t\tclass=\"btn btn-default btn-md\">Neues Todo</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<p />\n");
      out.write("\t\t<div class=\"row\" id=\"toggleDiv\">\n");
      out.write("\t\t\t");

				TodoDAO d = new TodoDAO();

				String todo = request.getParameter("todo");
				String type = request.getParameter("type");

				if (type != null && type.equals("delete")) {
					String ID = request.getParameter("id");
					d.deleteTodo(Integer.parseInt(ID));
				}

				if ((todo != null) && (todo != null)) {
					Todo T = new Todo(todo);
					d.saveTodo(T);
				}
			
      out.write("\n");
      out.write("\t\t\t<form class=\"form-horizontal\" method=\"post\" action=\"index.jsp\"\n");
      out.write("\t\t\t\trole=\"form\">\n");
      out.write("\t\t\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t\t\t<input id=\"vorname\" type=\"text\" class=\"form-control\"\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Todo eintragen...\" name=\"firstname\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-md-2\">\n");
      out.write("\t\t\t\t\t<input type=\"submit\" class=\"btn btn-success btn-md\"></input>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<p />\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-md-12\">\n");
      out.write("\t\t\t\t<table class=\"table\">\n");
      out.write("\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<th>ID</th>\n");
      out.write("\t\t\t\t\t\t\t<th>Todo</th>\n");
      out.write("\t\t\t\t\t\t\t<th>Funktionen</th>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t<tbody id=\"input\">\n");
      out.write("\t\t\t\t\t\t");

							List<Todo> todoList = d.getAllTodos();
							for (Todo t : todoList) {
						
      out.write("\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td data-update=\"updateField\">");
      out.print(t.getId());
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td data-update=\"updateField\">");
      out.print(t.getTodo());
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td><span data-id=\"\" data-delete=\"delete\" data-type=\"send\"\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-remove\"></span></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\n");
      out.write("\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t</table>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
