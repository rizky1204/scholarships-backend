package system.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.Constans;
import system.domain.Scholarships;
import system.exception.Exception;
import system.repository.ScholarshipRepository;
import system.vo.ScholarshipsCreateVO;
import system.vo.ScholarshipsListVO;
import system.vo.ScholarshipsUpdateVO;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ScholarshipsService {

    @Autowired
    ScholarshipRepository scholarshipRepository;

    @Transactional
    public Boolean createScholarships(ScholarshipsCreateVO vo){
        if(vo.getCountryName() == null) throw new Exception("Country Name Can't be null");
        if(vo.getEducationLevel() == null) throw new Exception("Education Can't be null");
        Scholarships model = new Scholarships();
        model.setCountryName(vo.getCountryName());
        model.setEducationLevel(vo.getEducationLevel());
        model.setDescription(vo.getDesc());
        model.setStatus(Constans.STATUS.OPEN);
        scholarshipRepository.save(model);

        return Boolean.TRUE;
    }

    @Transactional
    public Boolean updateCountry(ScholarshipsUpdateVO vo , String secureId){
        Scholarships isExist = scholarshipRepository.findBySecureId(secureId);
        if(isExist == null) throw new Exception("Scholarships not found");
        if(vo.getCountryName() == null) throw new Exception("Country Name Can't be null");
        if(vo.getEducationLevel() == null) throw new Exception("Education Can't be null");
        Scholarships model =  new Scholarships();
        model.setCountryName(vo.getCountryName());
        model.setEducationLevel(vo.getEducationLevel());
        model.setDescription(vo.getDesc());
        model.setStatus(vo.getStatus());
        scholarshipRepository.save(model);
        return Boolean.TRUE;
    }

    @Transactional
    public Boolean deleteCountry(String secureId){
        Scholarships isExist = scholarshipRepository.findBySecureId(secureId);
        if(isExist == null) throw new Exception("Scholarships not found");

        scholarshipRepository.delete(isExist);
        return Boolean.TRUE;
    }

    public List<ScholarshipsCreateVO> listCountry(){
        List<Scholarships> scholarshipsList = scholarshipRepository.findAll();
        ScholarshipsListVO listVO = new ScholarshipsListVO();
        List<ScholarshipsCreateVO> vo = new ArrayList<>();
        for(Scholarships scholarships : scholarshipsList){
            ScholarshipsCreateVO vos = new ScholarshipsCreateVO();
            vos.setCountryName(scholarships.getCountryName());
            vos.setEducationLevel(scholarships.getEducationLevel());
            vos.setDesc(scholarships.getDescription());
            vos.setSecureID(scholarships.getSecureId());
            vos.setStatus(scholarships.getStatus());
            vo.add(vos);
        }
        listVO.setCountryList(vo);
        return vo;
    }
}
