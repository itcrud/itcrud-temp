package com.itcrud.temp.controller;

import com.itcrud.temp.dto.ListTestReqDTO;
import com.itcrud.temp.test.TestService;
import com.itcrud.temp.vo.ListTestVO;
import com.itcurd.temp.constant.Constants;
import com.itcurd.temp.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 11:03
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@Controller
@RequestMapping(Constants.REQUEST_PREFIX + "test")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 查询列表测试（POST）
     */
    @RequestMapping(value = "/listPost", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO<List<ListTestVO>> listTestPost(@RequestBody ListTestReqDTO reqDTO) {
        List<ListTestVO> list = testService.listTest(reqDTO);
        return ResponseVO.successResp(list);
    }

    /**
     * 查询列表测试（GET）
     */
    @RequestMapping(value = "/listGet", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO<List<ListTestVO>> listTestGet(@RequestParam(name = "keyWord") String keyWord,
                                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        ListTestReqDTO reqDTO = new ListTestReqDTO();
        reqDTO.setKeyWord(keyWord);
        reqDTO.setPageNo(pageNo);
        reqDTO.setPageSize(pageSize);
        List<ListTestVO> list = testService.listTest(reqDTO);
        return ResponseVO.successResp(list);
    }
}
