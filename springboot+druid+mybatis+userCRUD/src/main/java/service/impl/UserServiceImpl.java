package service.impl;

import com.demo.pojo.User;
import com.demo.pojo.UserExample;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserService userService;
    @Override
    public int countByExample(UserExample example) {
        return userService.countByExample(example);
    }

    @Override
    public int deleteByExample(UserExample example) {
        return userService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userService.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userService.insertSelective(record);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return userService.selectByExample(example);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(User record, UserExample example) {
        return userService.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(User record, UserExample example) {
        return userService.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userService.updateByPrimaryKey(record);
    }
}
