package com.itcrud.temp.test.impl;

import com.itcrud.temp.bo.TestBO;
import com.itcrud.temp.mapper.TestMapper;
import com.itcrud.temp.dto.ListTestReqDTO;
import com.itcrud.temp.test.TestService;
import com.itcrud.temp.vo.ListTestVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 12:41
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<ListTestVO> listTest(ListTestReqDTO reqDTO) {
        List<ListTestVO> listResp = Lists.newArrayList();
        listResp.add(ListTestVO.builder()
                .id(1L).phone("16611221122").userName("Joker").build());
        listResp.add(ListTestVO.builder()
                .id(2L).phone("16611224455").userName("itcrud").build());
        List<TestBO> testBOS = testMapper.findAll();
        log.info("BOS--->{}", testBOS);
        return listResp;
    }
}
