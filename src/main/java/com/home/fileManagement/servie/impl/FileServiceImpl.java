package com.home.fileManagement.servie.impl;

import com.home.fileManagement.dao.FileRepository;
import com.home.fileManagement.module.common.Pagination;
import com.home.fileManagement.module.db.FileResource;
import com.home.fileManagement.module.db.User;
import com.home.fileManagement.module.req.FileResourceReq;
import com.home.fileManagement.module.res.FileResourceRes;
import com.home.fileManagement.servie.FileOperateService;
import com.home.fileManagement.servie.FileService;
import com.home.fileManagement.util.LocalBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author LX
 * @since 2021/3/24 11:23
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileOperateService fileOperateService;

    private String basePath = "G:\\家用文件服务";

    @Override
    public boolean add(User user, MultipartFile[] files) {
        try{
            File fileDir = new File(basePath+"\\"+user.getUserName());
            if(!fileDir.exists()) {
                fileDir.mkdirs();
            }
            for(int i=0;i<files.length;i++){
                uploadAndAdd(user, files[i]);
            }
        }catch (Exception e){
            log.error("上传文件失败，用户名:{}", user.getUserName());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadAndAdd(User user, MultipartFile file) {
        //上传文件
        String path = basePath+"\\"+user.getUserName()+"\\"+ file.getOriginalFilename();
        fileOperateService.uploadFile(file,path);
        //插入资源记录
        Date now = new Date();
        FileResource fileResource = new FileResource();
        fileResource.setId(UUID.randomUUID().toString())
                .setUrl(path)
                .setDelete(false)
                .setCreateTime(now)
                .setUpdateTime(now);
        fileRepository.save(fileResource);
    }

    @Override
    public FileResourceRes update(FileResourceReq req) {
        FileResourceRes res = new FileResourceRes();
        Date now = new Date();
        FileResource fileResource = fileRepository.findById(req.getId()).get();
        BeanUtils.copyProperties(req, fileResource, LocalBeanUtil.getNullPropertyNames(req));
        fileResource.setUpdateTime(now);
        fileRepository.save(fileResource);
        BeanUtils.copyProperties(fileResource, res);
        return res;
    }

    @Override
    public boolean delete(String id) {
        try{
            FileResource fileResource = fileRepository.findById(id).get();
            fileResource.setDelete(true)
                    .setUpdateTime(new Date());
            fileRepository.save(fileResource);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public FileResourceRes detail(String id) {
        FileResourceRes res = new FileResourceRes();
        FileResource fileResource = fileRepository.findById(id).get();
        BeanUtils.copyProperties(fileResource, res);
        return res;
    }

    @Override
    public Pagination<FileResourceRes> list(String userId, String type, String fileName, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page-1, pageSize, Sort.by(Sort.Order.desc("createTime")));
        List<FileResourceRes> resList = new ArrayList<>();
        Page<FileResource> fileResourcePage = fileRepository.findAll(new Specification<FileResource>() {
            @Override
            public Predicate toPredicate(Root<FileResource> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("isDelete"), false)));
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("userId"), userId)));
                if (StringUtils.hasText(type)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("type"), type)));
                }
                if (StringUtils.hasText(fileName)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("fileName"), "%" + fileName + "%")));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        log.debug("fileResourcePage:{}", fileResourcePage);
        fileResourcePage.stream().forEach(e->{
            FileResourceRes res = new FileResourceRes();
            BeanUtils.copyProperties(e, res);
            resList.add(res);
        });
        return new Pagination<>(page, pageSize, resList, fileResourcePage.getTotalElements(), fileResourcePage.getTotalPages());
    }

}
