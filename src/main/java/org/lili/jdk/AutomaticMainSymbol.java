package org.lili.jdk;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * 自动化上币的主链币
 *
 * @author lili
 * @date 2020/9/7 12:20
 */
public enum AutomaticMainSymbol {
    /**
     * EOS
     */
    EOS("EOS"),

    /**
     * TRX
     */
    TRX("TRX"),

    /**
     * ETH
     */
    ETH("ETH");

    private String configSymbol;

    AutomaticMainSymbol(String configSymbol) {
        this.configSymbol = configSymbol;
    }

    public String mainSymbol() {
        return configSymbol;
    }


    public static List<String> listConfigSymbol() {
        return ImmutableList.of(EOS.mainSymbol(), TRX.mainSymbol(), ETH.mainSymbol());
    }

}
