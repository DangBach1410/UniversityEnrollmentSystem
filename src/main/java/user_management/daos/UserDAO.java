package user_management.daos;

import user_management.models.User;
import java.util.List;

public interface UserDAO {
    User findByEmail(String email);
    boolean save(User user);
    List<User> searchByNameOrEmail(String keyword);
    boolean updatePassword(String email, String newPassword);
    boolean deleteByEmail(String email);
    List<User> findAll();
}