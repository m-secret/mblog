package club.msecret.mblog.service.Impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import club.msecret.mblog.entity.User;
import club.msecret.mblog.mapper.UserMapper;
import club.msecret.mblog.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Map loginCheck(Long tel) {
        Map<String, String> result = new HashMap<>();
        User user = userMapper.findUserByTel(tel);
        if (user == null) {
            result.put("code", "-1");
            result.put("message", "无此会员信息");
        } else {
            result.put("code", "0");
            result.put("message", user.getPassword());
            result.put("uname", user.getUname());
        }
        return result;
    }
}
