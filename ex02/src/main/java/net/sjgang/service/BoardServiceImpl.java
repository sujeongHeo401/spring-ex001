package net.sjgang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sjgang.domain.BoardVO;
import net.sjgang.mapper.BoardMapper;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Service;
import net.sjgang.domain.BoardVO;
import net.sjgang.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor


public class BoardServiceImpl implements BoardService {
	
	// spring 4.3 이상에서 자동으로 처리 
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register...." + board);
		mapper.insertSelectKey(board);
		// TODO Auto-generated method stub
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("modify...." + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove .... " + bno);
		return mapper.delete(bno) == 1;
	}


	@Override
	public List<BoardVO> getList(){
		log.info("getList....");
		return mapper.getList();
	}


}
