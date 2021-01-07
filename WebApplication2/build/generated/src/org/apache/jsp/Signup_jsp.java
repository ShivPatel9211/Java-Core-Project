package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <!-- Compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
      out.write("\n");
      out.write("    <!-- Compiled and minified JavaScript -->\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
      out.write("            \n");
      out.write("     \n");
      out.write("            \n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"green\"style=\"text-align: center;\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col m6 offset-m3\" >\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div style=\"background: url(img/imgev.jpg);background-size: cover; background-attachment: fixed \"class=\"card-content\">\n");
      out.write("                            <h3 style=\"margin: 10px; padding:10px 10px 10px 10px;  \">Register Here!!!</h3>\n");
      out.write("                            <div class=\"form\"style=\"text-align: center;\" id=\"myform\">\n");
      out.write("                                <form action=\"Register\" method=\"post\">\n");
      out.write("                                    <input type=\"text\" name=\"username\" placeholder=\"Enter user's name\">\n");
      out.write("                                    <input type=\"password\" name=\"password\" placeholder=\"Enter user's password\">\n");
      out.write("                                    <input type=\"email\" name=\"email\" placeholder=\"Enter user's email\">\n");
      out.write("                                    <input type=\"text\" name=\"phone\" placeholder=\"Enter user's Phone number\">\n");
      out.write("                                    <button type=\"submit\"  class=\" btn \" > Submit</button>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"lodder \" style=\"text-align: center;display: none\" >\n");
      out.write("                                <div class=\"preloader-wrapper big active\">\n");
      out.write("      <div class=\"spinner-layer spinner-blue\">\n");
      out.write("        <div class=\"circle-clipper left\">\n");
      out.write("          <div class=\"circle\"></div>\n");
      out.write("        </div><div class=\"gap-patch\">\n");
      out.write("          <div class=\"circle\"></div>\n");
      out.write("        </div><div class=\"circle-clipper right\">\n");
      out.write("          <div class=\"circle\"></div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("                            </div>\n");
      out.write("                            <h5>Please wait..</h5>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                     \n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script\n");
      out.write("  src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\n");
      out.write("  integrity=\"sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=\"\n");
      out.write("  crossorigin=\"anonymous\"></script>\n");
      out.write("  <script >\n");
      out.write("      $(document).ready(function(){\n");
      out.write("        console.log(\"page is ready..\")\n");
      out.write("        $(\"#myform\").on('submit', function (event){\n");
      out.write("            event.preventDefault();\n");
      out.write("            var f= $(this).serialize();\n");
      out.write("            console.log(f);\n");
      out.write("           // $.ajax({\n");
      out.write("             //   url:\"Register\",\n");
      out.write("            //    data:f,\n");
      out.write("            //    type:'POST',\n");
      out.write("             //   success: function (data, textStatus, jqXHR) {\n");
      out.write("               //         console.log(data);\n");
      out.write("              //          console.log(\"success...\")\n");
      out.write("              //      },\n");
      out.write("               //     error: function (jqXHR, textStatus, errorThrown) {\n");
      out.write("                 //        console.log(data);\n");
      out.write("                  //      console.log(\"error...\")\n");
      out.write("                    },\n");
      out.write("            })\n");
      out.write("        })\n");
      out.write("      })\n");
      out.write("  </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
