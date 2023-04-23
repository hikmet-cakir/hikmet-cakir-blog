package com.hikmetcakir.user.port;

import com.hikmetcakir.user.model.User;
import com.hikmetcakir.user.usecase.QueryUser;

import java.util.List;

public interface UserPort {

    List<User> query(QueryUser queryUser);
}
