package com.icbc.service.impl;

import com.icbc.entity.User;
import com.icbc.mapper.UserMapper;
import com.icbc.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kingvern
 * @since 2020-08-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
