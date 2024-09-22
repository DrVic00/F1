package com.vehiclebase.F1.Service;

import com.vehiclebase.F1.Entity.Users;
import com.vehiclebase.F1.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepo;

    public Users saveDetails(Users users){
        return usersRepo.save(users);
    }

    public Users fetchDetails(int id_user) { return usersRepo.findById(id_user).orElse(null);}
}
