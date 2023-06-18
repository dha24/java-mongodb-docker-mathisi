package com.automorfosi.mathisi.repositories;

import com.automorfosi.mathisi.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByEmail(String email);

    Page<User> findAllByEnabledTrue(Pageable pageable);


}
