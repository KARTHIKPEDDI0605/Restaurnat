package com.RestaurantRegister.Restaurant.Repository;

import com.RestaurantRegister.Restaurant.Models.Entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, String> {

    @Query("SELECT COUNT(r) > 0 FROM RestaurantEntity r WHERE r.userName = :userName")
    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);
}

