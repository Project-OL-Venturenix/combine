package com.vtxlab.projectol.backend_oscar.service.user;

import com.vtxlab.projectol.backend_oscar.entity.user.User;

public interface UserService {
  User findByUsername(String userName);
}
