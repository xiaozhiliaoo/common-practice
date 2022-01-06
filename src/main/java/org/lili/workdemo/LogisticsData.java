package org.lili.workdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lili
 * @date 2021/10/8 17:29
 */
@Data
@Builder
public class LogisticsData {

    /**
     * 配货单ID
     */
    int logisticsId;

    /**
     * 物料ID
     */
    int goodsId;

    /**
     * 物料成本
     */
    String costs;

    /**
     * 拆得成本
     */
    String splitCosts;

}
