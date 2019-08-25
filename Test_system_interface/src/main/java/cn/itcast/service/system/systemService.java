package cn.itcast.service.system;

import cn.itcast.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface systemService {
    //根据id查询全部
    List<cn.itcast.domain.User> findAll();

    PageInfo<User> findByPage( int pageNum, int pageSize);
}
