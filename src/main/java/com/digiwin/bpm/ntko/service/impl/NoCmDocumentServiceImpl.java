package com.digiwin.bpm.ntko.service.impl;

import com.digiwin.bpm.ntko.entity.NoCmDocumentEntity;
import com.digiwin.bpm.ntko.service.NoCmDocumentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author：zhupeng
 * @Date：2020/8/19 00:19
 * @Desc：TODO
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class NoCmDocumentServiceImpl extends BaseCurdServiceImpl<NoCmDocumentEntity> implements NoCmDocumentService {
}
