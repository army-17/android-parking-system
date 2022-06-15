package com.example.android.controller.reserve;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.android.mapper.reserve.ReserveMapper;
import com.example.android.model.reserve.Reserve;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

	private ReserveMapper mapper;
	
	public ReserveController(ReserveMapper mapper) {
		this.mapper = mapper;
	}

	@GetMapping("/list/{member_seq}")
	public List<Reserve> selectAllReserve(@PathVariable("member_seq") int member_seq) {
		return mapper.selectAllReserve(member_seq);
	}
	
	@PostMapping("/detail/{reserve_seq}")
	public Reserve selectDetailReserve(@PathVariable("reserve_seq") int reserve_seq, @RequestParam("member_seq") int member_seq) {
		return mapper.selectDetailReserve(reserve_seq, member_seq);
	}
	
	@PostMapping("/insert")
	public int insertReserve(@RequestParam("member_seq") int member_seq, 
			@RequestParam("parking_seq") int parking_seq) {
		return mapper.inserReserve(member_seq, parking_seq);
	}
	
	@PostMapping("/cancel")
	public int cancelReserve(@RequestParam("reserve_seq") int reserve_seq) {
		return mapper.cancelReserve(reserve_seq);
	}
}
