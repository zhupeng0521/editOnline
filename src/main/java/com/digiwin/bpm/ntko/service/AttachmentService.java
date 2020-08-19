package com.digiwin.bpm.ntko.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  *@author：zhupeng
  *@Date：2020/8/19 09:52
  *@Desc：TODO
  */

public interface AttachmentService {

    String downloadFile(String fileId, HttpServletResponse response, HttpServletRequest request);

    void uploadFile(MultipartFile file, String fileId, HttpServletRequest request);
}
