package arthur.dy.lee.biz.service;

import arthur.dy.lee.biz.model.DataSource;
import arthur.dy.lee.biz.model.UserBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Override
    public UserBean getUser(String username) {
        // 没有此用户直接返回null
        if (StringUtils.isEmpty(DataSource.getData(username).getUsername())) {
            return null;
        }
        return DataSource.getData(username);
    }
}
