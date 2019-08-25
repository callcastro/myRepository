package cn.itcast.dao.user;

import cn.itcast.domain.User;


import java.util.List;

public interface  userDao {
     //根据企业id查询全部
     List<User> findAll();
}
