package com.home.fileManagement.dao;

import com.home.fileManagement.module.db.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author LX
 * @since 2021/3/25 10:21
 */
@Repository
public interface UserRepository extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

    Page<User> findAllByUserNameLike(String userName, Pageable pageable);

}
