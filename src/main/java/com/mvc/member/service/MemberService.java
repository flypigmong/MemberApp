package com.mvc.member.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.member.dao.MemberDAO;
import com.mvc.member.dto.MemberDTO;

@Service  //이것이 서비스다라는것을 명시해줌..
public class MemberService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberDAO dao;
	
	public String join(String id,String pw,String name,String email) {
		 logger.info("서비스 도착");
		 String msg="회원가입에 실패 했습니다.";
		 
		 if(dao.join(id,pw,name,email)>0) {
			 msg = "회원가입에 성공했습니다.";
		 }
		return msg;
	}

	public String login(String id, String pw) {  
		logger.info("서비스 도착");
		return dao.login(id,pw); 
	}

	public ArrayList<MemberDTO> list() {
		logger.info("리스트 요청 서비스");
		return dao.list();
	}

	public void delete(String id) {
		logger.info("삭제서비스 도착");
		int success=dao.delete(id);
		logger.info("삭제된 데이터 수 : "+success);
	}

	public MemberDTO detail(String id) {
		logger.info(id+"의 상세정보 DB에 요청");
		return dao.detail(id);
	}

	public void update(String id, String pw, String name, String email) {
		logger.info(id+"의 수정 DB에 요청");
		int row= dao.update(id,pw,name,email);
		logger.info("수정한 데이터 수 :"+row);
	}
}
