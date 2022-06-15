package com.example.android.mapper.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.android.model.member.Member;


@Mapper
public interface MemberMapper {
	// [1] 회원가입
	@Insert("INSERT INTO tb_member VALUES(#{member_name}, #{car_name}, #{member_id}, #{password})")
	int signup(@Param("member_name") String member_name, @Param("car_num") String car_num, @Param("member_id") String member_id, @Param("password") String password);
	
	// [2] 로그인
	@Select("SELECT COUNT(*) FROM tb_member WHERE MEMBER_ID = #{member_id} AND PASSWORD = #{password}")
	int login(@Param("member_id") String member_id, @Param("password") String password);
	
	// [3] 아이디 찾기
	@Select("SELECT MEMBER_ID FROM tb_member WHERE MEMBER_NAME = #{member_name} AND CAR_NUM = #{car_num}")
	String findMemberId(@Param("member_name") String member_name, @Param("car_num") String car_num );
	
	// [4] 비밀번호 찾기
	@Select("SELECT PASSWORD FROM tb_member WHERE MEMBER_NAME = #{member_name} AND CAR_NUM = #{car_num } AND MEMBER_ID = #{member_id}")
	String findMemberPwd(@Param("member_name") String member_name, @Param("car_num") String car_num, @Param("member_id") String member_id );
	
}
