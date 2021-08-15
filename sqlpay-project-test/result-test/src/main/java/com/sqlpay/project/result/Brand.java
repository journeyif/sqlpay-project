package com.sqlpay.project.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiangy
 * @date 2021 - 08 - 15 - 16:19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    private String name;

    private String logo;

}
