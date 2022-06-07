package com.mvc.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.member.dto.MemberDTO;
import com.mvc.member.service.MemberService;


@Controller
public class HomeController {
	
	@Autowired MemberService service;	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); //
	
	//로그인
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("로그인 페이지");
		return "login";
	}
	

	@RequestMapping(value = "/joinForm")
	public String joinForm(Model model) { //Model model : View에게 데이터를 전달하기 위한 객체
		logger.info("회원가입 페이지");
		return "joinForm";
	}
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String joinForm(Model model, HttpServletRequest request) { //메서드에 매개변수를 Model타입의 model변수를 선언
		logger.info("회원가입 페이지");
		String id= request.getParameter("id");//사용자가 입력한 데이터(id)가져오기(요청 파라메터값 가져오기)
		String pw= request.getParameter("pw");
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		logger.info(id+"/"+pw+"/"+name+"/"+email);
		
		String msg=service.join(id,pw,name,email); //String타입의 변수 msg를 선언하고, model.addAttribute를 통해 view에 데이터를 전달
		logger.info(msg);
		model.addAttribute("msg",msg); //데이터를 view에게 전달한다.
		return "login";
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model, HttpServletRequest request) {
		//model:데이터를 담는 그릇 역할,map구조로 저장됨.key와 value로 구성
		logger.info("로그인 페이지");
		String id= request.getParameter("id"); //사용자가 입력한 "id"값을 가져와서 id에 대입
		String pw= request.getParameter("pw"); //사용자가 입력한 "pw"값을 가져와서 pw에 대입
		logger.info(id+"/"+pw);
		String loginId= service.login(id,pw);//id와pw를 
		logger.info("로그인 아이디 :" +loginId);
		
		String msg = "아이디 또는 비밀번호를 확인하세요";
		String page="login";
		
		if(loginId != null) { //null값이 아니면
			HttpSession session = request.getSession(); //세션 생성해서
			session.setAttribute("loginId", loginId); //loginId로 loginId값을 넘기자
			msg= loginId+"님 반갑습니다.";
			//로그인에 성공하면 controller에 list를 보여달라고 요청할 예정
			page= "redirect:/list";    //redirect는 데이터를 실어보낼 수 없다.
			// msg = loginId+ "님 반갑습니다.";
		}else {
			model.addAttribute("msg",msg); //model.addAttribute("변수명",값)
		}
		
		model.addAttribute("msg",msg);
		return page;
		
		
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request) {
		
		//로그인 한 사용자가 아니면 login 으로 보낼 예정
		String page="main";
		HttpSession session = request.getSession();//세션생성
		if(session.getAttribute("loginId")==null) { //세션에서 "loginId"값을 가져온게 null이 아니다
			page="login";
			model.addAttribute("msg","로그인이 필요한 서비스입니다.");
		}else {
			ArrayList<MemberDTO>list = service.list();  //서버의 list를 배열로 담음
			logger.info("list 갯수:"+list.size());
			model.addAttribute("list",list);   
		}
		return page;
	}
	
	@RequestMapping(value = "/logout")  //로그아웃은 로그인이라는 속성을 세션에서 지운다.
	public String logout(HttpSession session) { //세션 가져오기
		session.removeAttribute("loginId"); //"loginId"라는 속성을 세션에서 지운다.
		return "login";    //그리고나서 login으로 이동
	}
	
	@RequestMapping(value = "/delete")
	public String delete(Model model, HttpServletRequest request) {
		
		String id=request.getParameter("id");
		logger.info("삭제 요청:"+id);
		service.delete(id);
		return "redirect:/list"; // 요청을 "main"으로 하게되면 하얀화면만 나타난다.
	}
	
	@RequestMapping (value = "/detail")
	public String detail(Model model, @RequestParam String id) { //메시지를 전해주기위해 model쓰고 파라메터를 받기위해 request를 쓴다. 
		logger.info("상세보기 할 아이디: "+id);
		MemberDTO info=	service.detail(id);
		logger.info("pw:"+info.getPw());
		logger.info("email:"+info.getEmail());
		model.addAttribute("info",info);
		return "detail"; 
	}
		
	@RequestMapping(value = "/update")
	public String update(Model model, HttpServletRequest request) {
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		logger.info(id+"/"+pw+"/"+name+"/"+email);
		service.update(id,pw,name,email);
		return "redirect:/detail?id="+id;
	}	
}
