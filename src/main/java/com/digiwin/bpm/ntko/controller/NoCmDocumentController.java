package com.digiwin.bpm.ntko.controller;

import com.digiwin.bpm.ntko.entity.NoCmDocumentEntity;
import com.digiwin.bpm.ntko.service.AttachmentService;
import com.digiwin.bpm.ntko.service.NoCmDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：zhupeng
 * @Date：2020/8/19 00:28
 * @Desc：TODO
 */
@RestController
@RequestMapping("/api/attach")
public class NoCmDocumentController {

    @Autowired
    private NoCmDocumentService service;

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping(path = "/OID/{OID}")
    public NoCmDocumentEntity getByOID(@PathVariable String OID) {
        NoCmDocumentEntity noc = service.getById(OID);
        System.out.println(noc);
        return noc;
    }

    /**
     * 根据文件id获取文件名称
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/id/{id:.+}")
    public String getById(@PathVariable String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<NoCmDocumentEntity> noCmDocumentEntities = this.service.getByMap(map);
        System.out.println(noCmDocumentEntities);
        return noCmDocumentEntities.get(0).getLogicalName();
    }

    /**
     * 下载
     *
     * @param id
     * @param response
     * @param request
     */
    @GetMapping(path = "/down/{id:.+}")
    public void download(@PathVariable String id, HttpServletResponse response, HttpServletRequest request) {
        attachmentService.downloadFile(id, response, request);
    }

    /**
     * 上传
     *
     * @param file
     * @param id
     * @param request
     * @return
     */
    @PostMapping("/upload/{id:.+}")
    public void upload(@RequestParam(value = "fileUplaod", required = false) MultipartFile file, @PathVariable String id, HttpServletRequest request) {
        attachmentService.uploadFile(file, id, request);
    }
}
