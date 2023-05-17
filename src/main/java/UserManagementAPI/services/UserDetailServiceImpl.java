package UserManagementAPI.services;

import UserManagementAPI.model.User;
import UserManagementAPI.model.UserDetail;
import UserManagementAPI.repositories.UserDetailRepository;
import UserManagementAPI.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailService{
    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;

    @Override
    public UserDetail createUserDetail(Long userId, UserDetail userDetail) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userDetail.setUser(user);
        return userDetailRepository.save(userDetail);
    }

    @Override
    public UserDetail updateUserDetail(Long userId, UserDetail userDetail) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDetail existingUserDetail = user.getUserDetail();
        existingUserDetail.setAddress(userDetail.getAddress());
        existingUserDetail.setCity(userDetail.getCity());
        existingUserDetail.setCountry(userDetail.getCountry());
        existingUserDetail.setHobbies(userDetail.getHobbies());
        return userDetailRepository.save(existingUserDetail);
    }

    @Override
    public void deleteUserDetail(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userDetailRepository.deleteByUser(user);
    }

    @Override
    public UserDetail getUserDetailByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getUserDetail();
    }
}
