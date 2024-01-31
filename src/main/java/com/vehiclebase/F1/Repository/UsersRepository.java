package com.vehiclebase.F1.Repository;

import com.vehiclebase.F1.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
