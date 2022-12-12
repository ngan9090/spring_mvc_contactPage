package org.alicoder.spring.contactmanagement.repository;


import org.alicoder.spring.contactmanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findByFirstNameLike(String firstName);

    List<Users> findByEmail(String email);

    List<Users> findByLastNameLike(String lastName);

    boolean existsByEmailAndPassword(String email, String password);
}
