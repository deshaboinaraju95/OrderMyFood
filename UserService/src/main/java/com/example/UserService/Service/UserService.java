package com.example.UserService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserService.Dto.UserDto;
import com.example.UserService.Dto.UserLocationDto;
import com.example.UserService.Pojo.User;
import com.example.UserService.Repository.UserRepo;

@Service
public class UserService {
	@Autowired 
	private UserRepo userRepo;
	

	public UserDto FindUser(Long userId) {
		 User findUser = userRepo.findById(userId).get();
		 
		 UserDto userDto= new UserDto();
		 userDto.setUserId(findUser.getUserId());
		 userDto.setUserName(findUser.getUserName());
		 userDto.setEmilId(findUser.getEmilId());
		 userDto.setMobileNumber(findUser.getMobileNumber());
		 return userDto;
	}

	public UserLocationDto FindUserLocation(Long userId) {
		
		
		return userRepo.getUserLocation(userId);
		
		
	}

}
