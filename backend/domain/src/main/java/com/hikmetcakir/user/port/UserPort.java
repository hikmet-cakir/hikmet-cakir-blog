package com.hikmetcakir.user.port;

import com.hikmetcakir.user.model.User;
import com.hikmetcakir.user.usecase.DeleteUser;
import com.hikmetcakir.user.usecase.QueryUser;
import com.hikmetcakir.user.usecase.UpdateUser;
import com.hikmetcakir.user.usecase.UploadUser;

import java.util.List;

public interface UserPort {

    List<User> query(QueryUser queryUser);

    void delete(DeleteUser deleteUser);

    User upload(UploadUser uploadUser);

    void update(UpdateUser updateUser);
}
