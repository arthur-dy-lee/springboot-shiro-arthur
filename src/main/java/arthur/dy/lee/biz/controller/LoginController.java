package arthur.dy.lee.biz.controller;

import arthur.dy.lee.biz.model.UserBean;
import arthur.dy.lee.biz.service.UserService;
import arthur.dy.lee.util.JwtUtil;
import arthur.dy.lee.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/sys")
public class LoginController {


    private UserService userService;

    @Value("${arthur.shiro.excludeUrls}")
    private String excludeUrls;


    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 访问地址： http://localhost:8080/arthur-boot/sys/login?password=111&username=arthur
     * 要用postman，因为发的是post请求。
     */

    @PostMapping("/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        UserBean user = userService.getUser(username);
        if (StringUtils.isEmpty(password) || !user.getPassword().equals(password)) {
            return new Result(201, "Login fail", null);
        }
        return new Result(200, "Login success", JwtUtil.sign(username, password));

    }


}
