package user_management.services;

import user_management.models.User;
import java.util.List;
import user_management.daos.UserDAO;
import user_management.daos.UserDAOImpl;
import jakarta.validation.*;
import user_management.utils.PasswordUtil;
import java.util.Set;

public class UserService {

    private final UserDAO userDAO;
    private final Validator validator;

    public UserService() {
        this.userDAO = new UserDAOImpl();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public boolean register(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<User> v : violations) {
                System.out.println(v.getPropertyPath() + ": " + v.getMessage());
            }
            return false;
        }

        if (userDAO.findByEmail(user.getEmail()) != null) {
            System.out.println("Email đã tồn tại!");
            return false;
        }

        user.setPassword(PasswordUtil.hash(user.getPassword()));
        return userDAO.save(user);
    }

    public User login(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user == null) return null;

        String hashedInput = PasswordUtil.hash(password);
        return hashedInput.equals(user.getPassword()) ? user : null;
    }

    public boolean changePassword(String email, String oldPass, String newPass) {
        User user = userDAO.findByEmail(email);
        if (user == null) return false;

        if (!PasswordUtil.hash(oldPass).equals(user.getPassword())) {
            System.out.println("Mật khẩu cũ không đúng");
            return false;
        }

        String hashedNew = PasswordUtil.hash(newPass);
        return userDAO.updatePassword(email, hashedNew);
    }

    public List<User> searchUser(String keyword) {
        return userDAO.searchByNameOrEmail(keyword);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public boolean deleteUser(String email) {
        return userDAO.deleteByEmail(email);
    }
}

