package net.sjgang.controller;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
//Test for Controller
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//@AllArgsConstructor
@Log4j
public class BoardControllerTests {
	@Setter(onMethod_={@Autowired})
	private WebApplicationContext ctx;

	private MockMvc mockMvc;
	
	@Before(value = "")
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		System.out.println("orni ?????");
	}
	
	@Test
	public void testList() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title" , "테스트 새글 제목")
				.param("content", "테스트 새글 내용")
				.param("writer", "user00")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
	@Test
	public void testGet() throws Exception {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

		log.info(mockMvc.perform(MockMvcRequestBuilders 
				.get("/board/get")
				.param("bno", "2"))
				.andReturn()
				.getModelAndView().getModelMap());
	}
	
	@Test
	public void testModify() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "1")
				.param("title", "수정된 테스트 새글 제목")
				.param("content", "수정된 테스트 새글 내용")
				.param("writer", "user00"))
				.andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
	
	@Test
	public void testRemove() throws Exception{
		// 삭제 전 데이터 베이스에 게시물 번호 확인할 거ㅓㅅ
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "25")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
		
	}
}


