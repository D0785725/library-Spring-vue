package bin.javaproject.librarysystemtest.user;

import bin.javaproject.librarysystemtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User registerUser(User user) {
        // 檢查手機號碼是否已被註冊
        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number already registered.");
        }
        // 密碼加密處理
        user.setPassword(encryptPassword(user.getPassword()));

        return userRepository.save(user);
    }

    private String encryptPassword(String password) {
        // 加密密碼邏輯
        return password; // 實際上應使用安全的加密方式
    }



}
