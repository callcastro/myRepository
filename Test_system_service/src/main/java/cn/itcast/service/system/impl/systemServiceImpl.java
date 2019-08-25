package cn.itcast.service.system.impl;

import cn.itcast.dao.user.userDao;
import cn.itcast.domain.User;
import cn.itcast.service.system.systemService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class systemServiceImpl implements systemService {
    @Autowired
    private userDao userDao;



    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public PageInfo<User> findByPage( int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userDao.findAll();
        return new  PageInfo<>(list);
    }
}
