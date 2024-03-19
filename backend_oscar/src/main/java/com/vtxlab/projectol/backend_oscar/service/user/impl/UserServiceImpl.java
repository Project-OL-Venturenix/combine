package com.vtxlab.projectol.backend_oscar.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.projectol.backend_oscar.entity.user.User;
import com.vtxlab.projectol.backend_oscar.repository.user.UserRepository;
import com.vtxlab.projectol.backend_oscar.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User findByUsername(String userName) {
    return userRepository.findByUserName(userName)//
        .orElseThrow(() -> new RuntimeException("Error: User is not found."));
  }
}