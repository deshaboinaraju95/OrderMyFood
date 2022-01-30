package com.example.UserService.Repository;

import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.UserService.Dto.UserLocationDto;
import com.example.UserService.Pojo.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	
	@Query("SELECT DISTINCT new com.example.UserService.Dto.UserLocationDto(l.locationId, l.latitude,l.logitude, l.address,l.city, l.state, l.zipcode) from User u  INNER JOIN u.userLocation as l  where u.userId = ?1 ") 

	UserLocationDto getUserLocation(Long userId);

}
