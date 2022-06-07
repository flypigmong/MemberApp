package com.mvc.member.dao;

import java.util.ArrayList;

import com.mvc.member.dto.MemberDTO;

public interface MemberDAO { //이 인터페이스는 xml과 연결

	int join(String id, String pw, String name, String email); //member_mapper.xml의 param값이 넣어짐

	String login(String id, String pw);

	ArrayList<MemberDTO> list(); //멤버들의 리스트 갯수를 가져온다.

	int delete(String id);

	MemberDTO detail(String id);

	int update(String id, String pw, String name, String email);

}
