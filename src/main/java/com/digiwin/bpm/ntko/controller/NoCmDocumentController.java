package com.digiwin.bpm.ntko.controller;

import com.digiwin.bpm.ntko.entity.NoCmDocumentEntity;
import com.digiwin.bpm.ntko.service.NoCmDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：zhupeng
 * @Date：2020/8/19 00:28
 * @Desc：TODO
 */
@RestController
@RequestMapping("/api/demo")
public class NoCmDocumentController {

    @Autowired
    private NoCmDocumentService service;


    @GetMapping(path = "/{id}")
    public NoCmDocumentEntity get(@PathVariable String id) {
        NoCmDocumentEntity noc = service.getById("1604bf0ce6ca10048933a060bcfcf38b");
        System.out.println(noc);
        return noc;
    }


}
