package arthur.dy.lee.biz.controller;

import arthur.dy.lee.biz.service.UserService;
import arthur.dy.lee.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class ShiroTestController {


    private UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/article")
    public Result article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new Result(200, "You are already logged in", null);
        } else {
            return new Result(200, "You are guest", null);
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public Result requireAuth() {
        return new Result(200, "You are authenticated", null);
    }

    /**
     * http://localhost:8080/arthur-boot/test/require_role
     * 在postman中发get请求时，在header中，key:Authorization,value为登陆时返回的token值。
     *
     * @return
     */
    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public Result requireRole() {
        return new Result(200, "You are visiting require_role", null);
    }

    @GetMapping("/require_role2")
    @RequiresAuthentication
    public Result requireRole2() {
        return new Result(200, "You are visiting require_role", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public Result requirePermission() {
        return new Result(200, "You are visiting permission require edit,view", null);
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result unauthorized() {
        return new Result(401, "Unauthorized", null);
    }

    @GetMapping("/white_list_auth1")
    @RequiresAuthentication
    public Result whiteListAuth1() {
        return new Result(200, "白名单不鉴权", null);
    }

    @GetMapping("/white_list_auth2")
    @RequiresAuthentication
    public Result whiteListAuth2() {
        return new Result(200, "白名单不鉴权2", null);
    }

    @GetMapping("/white_list_auth3")
    public Result whiteListAuth3() {
        return new Result(200, "白名单不鉴权3", null);
    }
}
