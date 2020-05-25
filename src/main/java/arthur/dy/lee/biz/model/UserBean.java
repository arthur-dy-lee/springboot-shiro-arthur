package arthur.dy.lee.biz.model;

import lombok.Data;

import java.util.List;

@Data
public class UserBean {
    private String username;

    private String password;

    private List<String> role;

    private List<String> permission;

}
