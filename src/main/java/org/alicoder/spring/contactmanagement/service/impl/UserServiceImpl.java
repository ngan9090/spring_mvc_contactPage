package org.alicoder.spring.contactmanagement.service.impl;

import org.alicoder.spring.contactmanagement.model.Users;
import org.alicoder.spring.contactmanagement.payload.UserPayload;
import org.alicoder.spring.contactmanagement.repository.UserRepository;
import org.alicoder.spring.contactmanagement.service.UserService;
import org.alicoder.spring.contactmanagement.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserRepository repository;

    @Override
    public void save(UserPayload payload) throws NoSuchAlgorithmException {
        Users user = new Users(payload.getFirstName(), payload.getLastName(), payload.getEmail(), MD5Util.encrypt(payload.getPassword()));
        repository.save(user);
    }

    @Override
    public List<Users> listUser() {
        return repository.findAll();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

//    @Override
//    public void edit(UserPayload payload) throws NoSuchAlgorithmException{
//        Optional<Users> userList = repository.findById(payload.getId());
//        userList.get().setFirstName(payload.getFirstName());
//        userList.get().setLastName(payload.getLastName());
//        userList.get().setEmail(payload.getEmail());
//        if(payload.getPassword() == userList.get().getPassword()){
//        userList.get().setPassword(userList.get().getPassword());
//        }else{
//            userList.get().setPassword(MD5Util.encrypt(payload.getPassword()));
//        }
//        repository.save(userList.get());
//    }

    @Override
    public Users edit(Users users) throws NoSuchAlgorithmException {
        users.setPassword(MD5Util.encrypt(users.getPassword()));
        return repository.save(users);
    }

    @Override
    public Users edit(int id){
        Optional<Users> userList = repository.findById(id);
        return
        repository.save(userList.get());
    }



}
