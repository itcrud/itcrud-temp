package com.itcrud.temp.test;

import com.itcrud.temp.dto.ListTestReqDTO;
import com.itcrud.temp.vo.ListTestVO;

import java.util.List;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 12:38
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
public interface TestService {
    List<ListTestVO> listTest(ListTestReqDTO reqDTO);
}
