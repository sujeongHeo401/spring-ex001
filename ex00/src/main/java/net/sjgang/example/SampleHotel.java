package net.sjgang.example;

import org.springframework.stereotype.Component;

import lombok.NonNull;
//import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

// 필드 주입 // 세터 주입 /// 생성자 주입 
@Component
@ToString
//@AllArgsConstructor
@RequiredArgsConstructor
public class SampleHotel {
	@NonNull
	private final Chef chef;

//	public SampleHotel(Chef chef) {
//		super();
//		this.chef = chef;
//	}
	
	
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
}
