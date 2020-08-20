package com.digiwin.bpm.ntko.service.impl;

import com.digiwin.bpm.ntko.entity.NoCmDocumentEntity;
import com.digiwin.bpm.ntko.service.AttachmentService;
import com.digiwin.bpm.ntko.service.NoCmDocumentService;
import com.digiwin.bpm.ntko.util.NtkoUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @author：zhupeng
 * @Date：2020/8/19 09:52
 * @Desc：附件服务，上传、下载
 */

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final NoCmDocumentService noCmDocumentService;

    public AttachmentServiceImpl(NoCmDocumentService noCmDocumentService) {
        this.noCmDocumentService = noCmDocumentService;
    }

    /**
     * 下载附件
     * @param fileId
     * @param response
     * @param request
     */
    @Override
    public void downloadFile(String fileId, HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", fileId);
        List<NoCmDocumentEntity> noCmDocumentEntities = this.noCmDocumentService.getByMap(map);
        if (!noCmDocumentEntities.isEmpty()) {
            NoCmDocumentEntity entity = noCmDocumentEntities.get(0);
            String physicalName = entity.getPhysicalName();
            String filaPath = NtkoUtil.resolvingPath(physicalName);
            String fileName = entity.getPhysicalName() + "." + entity.getExtentionName();
            filaPath += fileName;
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            java.io.BufferedInputStream bis = null;
            java.io.BufferedOutputStream bos = null;
            // 下载文件
            try {
                long fileLength = new File(filaPath).length();
                response.setContentType("application/octet-stream");
                response.setHeader("Content-disposition", "attachment; filename=" + fileName);
                response.setHeader("Content-Length", String.valueOf(fileLength));
                bis = new BufferedInputStream(new FileInputStream(filaPath));
                bos = new BufferedOutputStream(response.getOutputStream());
                byte[] buff = new byte[2048];
                int bytesRead;
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bos != null) {
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 上传附件
     * @param file
     * @param fileId
     * @param request
     */
    @Override
    public void uploadFile(MultipartFile file, String fileId, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", fileId);
        List<NoCmDocumentEntity> noCmDocumentEntities = this.noCmDocumentService.getByMap(map);
        if (!noCmDocumentEntities.isEmpty()) {
            NoCmDocumentEntity entity = noCmDocumentEntities.get(0);
            String physicalName = entity.getPhysicalName();
            String filaPath = NtkoUtil.resolvingPath(physicalName);
            String fileName = entity.getPhysicalName() + "." + entity.getExtentionName();
            try {
                request.setCharacterEncoding("utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            File targetFile = new File(filaPath, fileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //替换文件
            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
