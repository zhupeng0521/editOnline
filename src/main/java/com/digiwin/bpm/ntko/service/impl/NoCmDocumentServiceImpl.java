package com.digiwin.bpm.ntko.service.impl;

import com.digiwin.bpm.ntko.entity.NoCmDocumentEntity;
import com.digiwin.bpm.ntko.repository.BaseRepository;
import com.digiwin.bpm.ntko.repository.NoCmDocumentRepository;
import com.digiwin.bpm.ntko.repository.impl.BaseRepositoryImpl;
import com.digiwin.bpm.ntko.service.BaseService;
import com.digiwin.bpm.ntko.service.NoCmDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author：zhupeng
 * @Date：2020/8/19 00:19
 * @Desc：TODO
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class NoCmDocumentServiceImpl extends BaseServiceImpl<NoCmDocumentEntity> implements NoCmDocumentService {
//    private final NoCmDocumentRepository noCmDocumentRepository;
//
//    public NoCmDocumentServiceImpl(NoCmDocumentRepository noCmDocumentRepository) {
//        this.noCmDocumentRepository = noCmDocumentRepository;
//    }

}
