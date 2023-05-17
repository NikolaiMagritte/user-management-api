package UserManagementAPI.services;

public interface UserPhotoService {
    byte[] getUserPhoto(Long userId);
    void updateUserPhoto(Long userId, byte[] photo);
    void deleteUserPhoto(Long userId);
}
