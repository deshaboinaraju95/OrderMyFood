package com.example.RestaurantsService.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestaurantsService.Pojo.Location;
@Repository
public interface LocationRepo  extends JpaRepository<Location, Long> {
	
	

}
