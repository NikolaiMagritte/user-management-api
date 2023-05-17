package UserManagementAPI.services;

import UserManagementAPI.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();
}
