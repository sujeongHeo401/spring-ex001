package net.sjgang.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.bind.annotation.RequestMapping;

import net.sjgang.domain.BoardVO;
import net.sjgang.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.Setter;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	private void list(Model model) {
		log.info("list");
		
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register : " + board);
		
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}

}
