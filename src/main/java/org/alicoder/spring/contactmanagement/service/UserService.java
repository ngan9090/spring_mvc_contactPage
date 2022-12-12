package org.alicoder.spring.contactmanagement.service;

import org.alicoder.spring.contactmanagement.model.Users;
import org.alicoder.spring.contactmanagement.payload.UserPayload;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {

    void save(UserPayload payload) throws NoSuchAlgorithmException;

    List<Users> listUser();

    void delete(int id);

    Users edit(Users users) throws NoSuchAlgorithmException;

    Users edit(int id);
}
