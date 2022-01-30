package com.example.UserService.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.example.UserService.Dto.UserDto;
import com.example.UserService.Dto.UserLocationDto;
import com.example.UserService.Pojo.User;
import com.example.UserService.Service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "UserController", description = "REST Apis related Search User!!!!")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Search User By UserId  ", response = UserDto.class)

	@GetMapping("getuser/{userId}")
	private UserDto findUser(@ApiParam(value = "UserId as input", required = true, defaultValue = "1") @PathVariable( value="userId") Long userId)
	{
		
		
	return  userService.FindUser(userId);
	
	
	 
	}
	@ApiOperation(value = "Search uselocation By UseId  ", response = UserLocationDto.class)

	@GetMapping("getuserlocation/{userId}")
	private UserLocationDto findUserLocation (@ApiParam(value = "UserId as input", required = true, defaultValue = "1") @PathVariable( value="userId") Long userId)
	{
		
		
	return  userService.FindUserLocation(userId);
	
	
	 
	}
	
}
