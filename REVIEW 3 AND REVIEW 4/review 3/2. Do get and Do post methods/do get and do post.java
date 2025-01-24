import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet {

    // Handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");

        // Write HTML form in the response
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Example Form</title></head>");
        out.println("<body>");
        out.println("<h2>Enter Your Details</h2>");
        out.println("<form method='post' action='example'>");
        out.println("    <label for='name'>Name:</label>");
        out.println("    <input type='text' id='name' name='name' required><br><br>");
        out.println("    <label for='email'>Email:</label>");
        out.println("    <input type='email' id='email' name='email' required><br><br>");
        out.println("    <button type='submit'>Submit</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    // Handle POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Set the response content type
        response.setContentType("text/html");

        // Write a response back to the user
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Submission Successful</title></head>");
        out.println("<body>");
        out.println("<h2>Thank You for Submitting Your Details!</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<a href='example'>Go Back</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
