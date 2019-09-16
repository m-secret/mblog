package club.msecret.mblog.mapper;

import club.msecret.mblog.entity.User;

public interface UserMapper {
    User findUserByTel(Long tel);

}
