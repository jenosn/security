package com.jenson.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.jenson.security.dto.UserDto;
import com.jenson.security.dto.UserDto.UserDtoDetailView;
import com.jenson.security.dto.UserDto.UserDtoSimpleView;

@RestController
public class UserController {
	
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	@JsonView(UserDtoSimpleView.class)
	public List<UserDto> query(@RequestParam String userName) {
		System.out.println(userName);
		List<UserDto> userList=new ArrayList<UserDto>();
		userList.add(new UserDto());
		userList.add(new UserDto());
		userList.add(new UserDto());
		return userList;
		
	}
	
	@RequestMapping(value="/user/{id:\\d+}",method=RequestMethod.GET)
	@JsonView(UserDtoDetailView.class)
	public UserDto getInfo(@PathVariable String id) {
		
		UserDto userDto=new UserDto();
		userDto.setUserName("Tom");
		return userDto;
	}
	
	/**
	 *   @Valid  ������֤
	 *   BindingResult ��������쳣�������쳣��Ϣ���뷽�����@Valid ����ʹ��
	 * @param user
	 * @return
	 */
	@PostMapping("/user")
	public UserDto createSuccess(@Valid @RequestBody UserDto user,BindingResult error) {
		if(error.hasErrors()) {
			error.getAllErrors().stream().forEach( errors -> 
			System.out.println(errors.getDefaultMessage()));
		}
		
		System.out.println(user.getUserName());
		System.out.println(user.getDate());
		user.setId("1");
		return user;
	}

}
