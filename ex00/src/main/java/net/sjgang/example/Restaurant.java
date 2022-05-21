package net.sjgang.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.ToString;
import lombok.Setter;
import lombok.AllArgsConstructor;

/// Setter 주입
/// 생성자 주입
/// 필드 주입 


@Component
@ToString
@AllArgsConstructor
public class Restaurant {
	
//	@Setter(onMethod_ = {@Autowired} )
	private Chef chef;
	

}
