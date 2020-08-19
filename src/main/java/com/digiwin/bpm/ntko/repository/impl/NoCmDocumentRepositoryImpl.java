package com.digiwin.bpm.ntko.repository.impl;

import com.digiwin.bpm.ntko.entity.NoCmDocumentEntity;
import com.digiwin.bpm.ntko.repository.NoCmDocumentRepository;
import org.springframework.stereotype.Repository;

/**
 * @author：zhupeng
 * @Date：2020/8/18 23:36
 * @Desc：TODO
 */
@Repository
public class NoCmDocumentRepositoryImpl extends BaseCurdRepositoryImpl<NoCmDocumentEntity> implements NoCmDocumentRepository {

    @Override
    public NoCmDocumentEntity getById(String id) {
        return super.getById(id);
    }

//    public static void main(String[] args) {
//
//        NoCmDocumentEntity noc =this.getById("1604bf0ce6ca10048933a060bcfcf38b");
////        NoCmDocumentEntity noc =  noCmDocumentRepository.getNoCmDocById("017e1de4e6ca10048933a060bcfcf38b.docx");
//        System.out.println(noc);
//    }
}
