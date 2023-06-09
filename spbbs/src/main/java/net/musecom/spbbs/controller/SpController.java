package net.musecom.spbbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.musecom.spbbs.command.SpCommand;
import net.musecom.spbbs.command.SpDeleteCommand;
import net.musecom.spbbs.command.SpDetailCommand;
import net.musecom.spbbs.command.SpListCommand;
import net.musecom.spbbs.command.SpReplyCommand;
import net.musecom.spbbs.command.SpReplyokCommand;
import net.musecom.spbbs.command.SpUpdateCommand;
import net.musecom.spbbs.command.SpUpdateokCommand;
import net.musecom.spbbs.command.SpWriteCommand;

@Controller
public class SpController {
	
	//��� command�� ���� �ִ� �������̽� Ÿ���� ����
	SpCommand command;
  
	//�۸�Ϻ���
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()����");
		
		command = new SpListCommand();
		command.execute(model);
		
	    return "list";	
	}
	
	//�Խñ� ����
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
		System.out.println("detail()");
		
		model.addAttribute("request", request);
		command = new SpDetailCommand();
		command.execute(model);
		
		return "detail";
	}
	
	//�Խñ� �ۼ�â
	@RequestMapping("/write")
	public String wirte(Model model) {
		System.out.println("wirte()");
		
		return "write";
	}
	
	//�Խñ� �ۼ��ϱ�
	@RequestMapping(value="/writeok", method=RequestMethod.POST)
	public String writeok(HttpServletRequest request, Model model) {
		System.out.println("wirteok");
		
		model.addAttribute("request", request);
		command = new SpWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	//����Է�â
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");

		model.addAttribute("request", request);
		command = new SpReplyCommand();
		command.execute(model);
		
		return "reply";
	}
	
	//��۾���
	@RequestMapping(value="/replyok", method=RequestMethod.POST)
	public String replyok(HttpServletRequest request, Model model) {
		System.out.println("replyok()");
		
		model.addAttribute("request", request);
		command = new SpReplyokCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	//�����ϱ�â
	@RequestMapping("/update")
	public String modify(HttpServletRequest request, Model model ) {
		System.out.println("update()");
		
		model.addAttribute("request", request);
		command = new SpUpdateCommand();
		command.execute(model);
		
		return "update";
	}
	
	//�����ϱ�
	@RequestMapping(value="/updateok", method=RequestMethod.POST)
	public String updateok(HttpServletRequest request, Model model) {
		System.out.println("updateok()");
		
		model.addAttribute("request", request);
		command = new SpUpdateokCommand();
		command.execute(model);
		
		return "redirect:list";
	}

	//�ۻ���
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new SpDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}
