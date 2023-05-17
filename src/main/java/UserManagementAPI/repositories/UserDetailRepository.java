package UserManagementAPI.repositories;

import UserManagementAPI.model.User;
import UserManagementAPI.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    @Transactional
    void deleteByUser(User user);
}
