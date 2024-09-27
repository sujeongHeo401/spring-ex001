package net.sjgang.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;
import net.sjgang.domain.SampleVO;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	
	@GetMapping(value="/getSample",
			produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
		
		//return new String[] {"AAA","BBB","CCC"};
		
		return new SampleVO(112, "스타", "로드");
	}
	
	
	@GetMapping(value ="/getText", produces ="text/plain; charset=UTF-8")
	public String getText() {
		System.out.println("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
