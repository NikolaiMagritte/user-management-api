package UserManagementAPI.services;

import UserManagementAPI.model.User;
import UserManagementAPI.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPhotoServiceImpl implements UserPhotoService {
    private final UserRepository userRepository;

    @Override
    public byte[] getUserPhoto(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getPhoto();
    }

    @Override
    public void updateUserPhoto(Long userId, byte[] photo) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPhoto(photo);
        userRepository.save(user);
    }

    @Override
    public void deleteUserPhoto(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPhoto(null);
        userRepository.save(user);
    }
}
