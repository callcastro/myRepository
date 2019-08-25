package cn.itcast.web.controller.system;

import cn.itcast.domain.User;
import cn.itcast.service.system.systemService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.util.calendar.BaseCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected HttpSession session;
    @Reference
    private systemService systemService;
    @Reference
    private User user;

    //用户列表分页
    @RequestMapping("/list")
    public String list(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "5") int PageSize) {
        /*org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        subject.checkPermission("用户管理");*/
        //1.调用service查询用户列表

        PageInfo<User> pageInfo =
                systemService.findByPage(pageNum,PageSize);
        //2.将用户列表保存到request域中
        request.setAttribute("pageInfo",pageInfo);
        //3.跳转到对象的页面
        return "user/user-list";
    }

    @RequestMapping("/findAll")
    public String findAll(){
        systemService.findAll();
        return "user/base";
    }
}
