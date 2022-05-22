package net.sjgang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Arrays;
import net.sjgang.domain.SampleDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@RequestMapping("")
	public void basic() {
		log.info("basic........");
		
	}

	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get........");
		
	}
	
	@RequestMapping(value = "/basicOnlyGet")
	public void basicGet2() {
		log.info("basic only get........");
		
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}

	///https://jy-tblog.tistory.com/38#:~:text=%EB%B0%B0%EC%97%B4%EC%97%90%EC%84%9C%20%EC%9D%B8%EB%8D%B1%EC%8A%A4%EB%8A%94%20%EC%9C%A0%EC%9D%BC%EB%AC%B4%EC%9D%B4,%EC%95%8A%EC%95%84%20cash%20hit%EA%B0%80%20%EC%96%B4%EB%A0%B5%EB%8B%A4.
	/// 배열과 리스트의 차이점을 읊어놓은 글
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids")String[] ids) {
		log.info("array ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
}
