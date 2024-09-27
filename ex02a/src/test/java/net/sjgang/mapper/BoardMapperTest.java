package net.sjgang.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.sjgang.domain.BoardVO;
import net.sjgang.domain.Criteria;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작똥하는 꿀");
		board.setContent("새로 작똥하는 내용");
		board.setWriter("newbie11111");
		
		mapper.insert(board);
		
		log.info(board);
		
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작똥하는 꿀----- select key");
		board.setContent("새로 짝똥하는 내용 select key");
		board.setWriter("newbie!!!!!");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
		
	}
	
	@Test
	public void testRead() {
		// 존재하는 게시물 번호로 리스트
		BoardVO board = mapper.read(1L);
		
		log.info(board);
	}
//	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT : " + mapper.delete(3L));
	}
//	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		// 실행 전에는 존재하는 번호인지 확인할 것
		board.setBno(5L);
		board.setTitle("수뗭된 쩨목");
		board.setContent("수떵된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		//10개씩 3페이지 
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
}
