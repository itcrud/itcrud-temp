package com.itcrud.temp.vo;

import com.itcrud.temp.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 11:00
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListTestVO extends BaseVO {
    private Long id;
    private String userName;
    private String phone;
}
