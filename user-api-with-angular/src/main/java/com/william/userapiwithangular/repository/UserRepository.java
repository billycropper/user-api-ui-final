package com.william.userapiwithangular.repository;

import com.william.userapiwithangular.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface UserRepository extends CrudRepository<User, Long> {
}
