package net.sjgang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.sjgang.domain.BoardVO;
import net.sjgang.domain.Criteria;
import net.sjgang.mapper.BoardMapper;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board){
		log.info("register....." + board);
		mapper.insertSelectKey(board);
	}
	
//	@Override
//	public List<BoardVO> getList() {
//		// TODO Auto-generated method stub
//		
//		log.info("get List.....");
//		return mapper.getList();
//	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		
		log.info("22222222222222222222 get List....." + cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		
		
		log.info("get...." + bno);
		return mapper.read(bno);
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
		log.info("remove...." + bno);
		return mapper.delete(bno) == 1;
	}
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}



}
