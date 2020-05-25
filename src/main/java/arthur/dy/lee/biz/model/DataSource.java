package arthur.dy.lee.biz.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSource {
    private static Map<String, UserBean> data = new HashMap<>();

    static {
        UserBean userBean = new UserBean();
        String userName = "user1";
        userBean.setUsername(userName);
        userBean.setPassword("1");
        List roleList = new ArrayList<>();
        roleList.add("user");
        userBean.setRole(roleList);
        List<String> permissionList = new ArrayList<>();
        permissionList.add("/test/white_list_auth3");
        data.put("user1", userBean);


        userBean = new UserBean();
        userName = "user2";
        userBean.setUsername(userName);
        userBean.setPassword("1");
        roleList = new ArrayList<>();
        roleList.add("user");
        userBean.setRole(roleList);
        permissionList = new ArrayList<>();
        permissionList.add("view");
        data.put("user2", userBean);


        userBean = new UserBean();
        userName = "admin1";
        userBean.setUsername(userName);
        userBean.setPassword("1");
        roleList = new ArrayList<>();
        roleList.add("admin");
        userBean.setRole(roleList);
        permissionList = new ArrayList<>();
        permissionList.add("view");
        permissionList.add("edit");
        data.put("admin1", userBean);


    }

    public static UserBean getData(String userName) {
        return data.get(userName);
    }
}
