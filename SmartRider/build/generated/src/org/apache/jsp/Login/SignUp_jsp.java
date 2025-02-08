package org.apache.jsp.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SignUp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <title>SmartRide - User Sign Up</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"left-section\">\n");
      out.write("      <img src=\"Icon.png\" alt=\"Smart Ride\" class=\"icon\">\n");
      out.write("      <h1>Smart Ride</h1>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"right-section\">\n");
      out.write("      <div class=\"login-box\">\n");
      out.write("        <h2>Sign Up</h2>\n");
      out.write("        <div class=\"form-scroll-container\">\n");
      out.write("            <form action=\"../SignUpServlet\" method=\"post\">\n");
      out.write("                <!-- Input fields -->\n");
      out.write("            <label for=\"username\">Username</label>\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\" placeholder=\"Username\" required>\n");
      out.write("\n");
      out.write("            <label for=\"first_name\">First Name</label>\n");
      out.write("            <input type=\"text\" id=\"first_name\" name=\"first_name\" placeholder=\"First Name\" required>\n");
      out.write("\n");
      out.write("            <label for=\"last_name\">Last Name</label>\n");
      out.write("            <input type=\"text\" id=\"last_name\" name=\"last_name\" placeholder=\"Last Name\" required>\n");
      out.write("\n");
      out.write("            <label for=\"email\">Email</label>\n");
      out.write("            <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"Email\" required>\n");
      out.write("\n");
      out.write("            <label for=\"phone_num\">Phone Number</label>\n");
      out.write("            <input type=\"tel\" id=\"phone_num\" name=\"phone_num\" placeholder=\"Phone Number\" required>\n");
      out.write("\n");
      out.write("            <label for=\"address\">Address</label>\n");
      out.write("            <input type=\"text\" id=\"address\" name=\"address\" placeholder=\"Address\" required>\n");
      out.write("\n");
      out.write("            <label for=\"gender\">Select Gender</label>\n");
      out.write("            <select id=\"gender\" name=\"gender\">\n");
      out.write("              <option value=\"\">Select gender</option>\n");
      out.write("              <option value=\"male\">Male</option>\n");
      out.write("              <option value=\"female\">Female</option>\n");
      out.write("              <option value=\"other\">Other</option>\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <label for=\"password\">Password</label>\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Password\" required>\n");
      out.write("\n");
      out.write("            <!-- Button -->\n");
      out.write("            <button type=\"submit\" class=\"btn\">Sign Up as a User</button>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Links -->\n");
      out.write("        <p class=\"guest-option\">\n");
      out.write("          Already have an account? <a href=\"Login.jsp\">Login</a>\n");
      out.write("        </p>\n");
      out.write("        <p class=\"guest-option\">\n");
      out.write("          <a href=\"../index.jsp\">Return to Main Page</a>\n");
      out.write("        </p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</body>\n");
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
