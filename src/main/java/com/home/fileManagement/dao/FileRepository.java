package com.home.fileManagement.dao;

import com.home.fileManagement.module.db.FileResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author LX
 * @since 2021/3/25 10:26
 */
@Repository
public interface FileRepository extends JpaRepository<FileResource,String>, JpaSpecificationExecutor<FileResource> {

}
