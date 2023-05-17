package UserManagementAPI.services;

import UserManagementAPI.model.UserDetail;

public interface UserDetailService {
    UserDetail createUserDetail(Long userId, UserDetail userDetail);
    UserDetail updateUserDetail(Long userId, UserDetail userDetail);
    void deleteUserDetail(Long userId);
    UserDetail getUserDetailByUserId(Long userId);
}
