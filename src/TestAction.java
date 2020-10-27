import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.sql.*;

public class TestAction extends Action {
    Connection conn = null;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		TestActionForm form = (TestActionForm)actionForm;
		String data = form.getData();

		try {	
			CallableStatement stmt = conn.prepareCall("{ ? = call TEST.SampleFn(?)}");
			// bind params
			stmt.registerOutParameter(1, 3);
			stmt.setString(2, data);
			stmt.execute();
		} catch(Exception e) { }
		
		return new ActionForward("forwardURL");
	}
}
