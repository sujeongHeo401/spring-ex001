package net.sjgang.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.ToString;
import lombok.Setter;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;

/// Setter 주입
/// 생성자 주입
/// 필드 주입 


@Component
@ToString
//@AllArgsConstructor
//@RequiredArgsConstructor
public class Restaurant {
	
	@Setter(onMethod_ = {@Autowired} )
	private  Chef chef; ////////// 5점대에서 적용 ,final 필드 자동 주입 기능 
	

}
