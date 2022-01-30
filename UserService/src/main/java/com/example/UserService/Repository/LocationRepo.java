package com.example.UserService.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserService.Pojo.UserLocation;



@Repository
public interface LocationRepo  extends JpaRepository<UserLocation,Long>
{
	

}
