package com.home.fileManagement.servie.impl;

import com.home.fileManagement.dao.UserRepository;
import com.home.fileManagement.module.db.User;
import com.home.fileManagement.module.req.UserReq;
import com.home.fileManagement.module.res.UserRes;
import com.home.fileManagement.servie.UserServie;
import com.home.fileManagement.util.LocalBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author LX
 * @since 2021/3/24 11:23
 */
@Service
@Slf4j
public class UserServiceImpl implements UserServie {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRes addOrUpdate(UserReq req) {
        UserRes res = new UserRes();
        User user;
        Date now = new Date();
        //新增
        if(StringUtils.hasText(req.getId())){
            user = new User();
            BeanUtils.copyProperties(req, user);
            user.setId(UUID.randomUUID().toString())
                    .setDelete(false)
                    .setCreateTime(now)
                    .setUpdateTime(now);
        }else {
            //修改
            user = userRepository.findById(req.getId()).get();
            BeanUtils.copyProperties(req, user, LocalBeanUtil.getNullPropertyNames(req));
        }
        User save = userRepository.save(user);
        BeanUtils.copyProperties(save, res);
        return res;
    }

    @Override
    public boolean delete(String id) {
        try{
            User user = userRepository.findById(id).get();
            user.setDelete(true)
                    .setUpdateTime(new Date());
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserRes detail(String id) {
        UserRes res = new UserRes();
        User user = userRepository.findById(id).get();
        BeanUtils.copyProperties(user, res);
        return res;
    }

    @Override
    public Page<UserRes> list(String userName, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Order.desc("createTime")));
        List<UserRes> resList = new ArrayList<>();
        if(!StringUtils.hasText(userName)){
            userRepository.findAll(pageable).stream().forEach(e->{
                UserRes res = new UserRes();
                BeanUtils.copyProperties(e, res);
                resList.add(res);
            });
        }else{
            userRepository.findAllByUserNameLike("%"+userName+"%",pageable).stream().forEach(e->{
                UserRes res = new UserRes();
                BeanUtils.copyProperties(e, res);
                resList.add(res);
            });
        }
        return new PageImpl<>(resList);
    }


}
