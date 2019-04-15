package test.char3;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ValueConstants;

import com.hihihigh.crm.controller.HomeController;

public class HomeControllerTest {
	
	@Test
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("redirect:easyUi/workspace.jsp"));
		//System.out.println(ValueConstants.DEFAULT_NONE);
	}
	
}
