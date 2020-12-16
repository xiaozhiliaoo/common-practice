package org.lili.jdk.enumtest;

import org.junit.Assert;

/**
 * 钱包返回码:http://docs.hicoin.vip/zh/latest/API-WaaS-V2/api_note.html#id3
 *
 * @author lili
 * @date 2020/4/25 23:18
 */
public enum WalletResponseCode {

    SUCCESS("0", "成功"),
    SYSTEM_ERROR("100001", "系统错误"),
    ILLEGAL_REQUEST_PARAM("100004", "请求参数不合法"),
    SIGN_FAIL("100005", "签名校验失败"),
    ILLEGAL_IP("100007", "非法IP"),
    ILLEGAL_APPID("100015", "商户ID无效"),
    USER_FROZEN("110004", "用户被冻结不可提现"),
    MOBILE_REGISTERED("110023", "手机号已注册"),
    WITHDRAW_ADDR_ERROR("110055", "提现地址错误"),
    USER_NOT_EXIST("110065", "请求用户用户不存在"),
    WITHDRAW_LESS_THAN_MIN("110078", "提现或转账金额小于最小转出金额"),
    WITHDRAW_MORE_THAN_MAX("110087", "提现或转账金额大于最大转出金额"),
    REPEATE_REQUEST("110088", "请勿重复提交请求"),
    MOBILE_ERROR("110089", "注册手机号不正确"),
    USER_REGISTER_FAIL("110101", "用户注册失败"),
    SYMBOL_NOT_SUPPORT("120202", "币种不支持"),
    WITHDRAW_NOT_ENOUGH("120402", "提现或转账余额不足"),
    WITHDRAW_FEE_NOT_ENOUGH("120403", "提现手续费余额不足"),
    WITHDRAW_FEE_TOO_SMALL("120404", "提现或转账金额太小, 小于等于手续费"),
    WITHDRAW_CANNOT_TO_SELF("3040006", "不能给自己转账"),

    UNKNOW_STATUS(String.valueOf(Integer.MIN_VALUE), "未知状态，业务层自定义，非第三方状态");


    private String code;
    private String message;

    WalletResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code获取WalletResponseCode枚举
     *
     * @param code code码
     * @return 枚举类型
     */
    public static WalletResponseCode ofCode(String code) {
        for (WalletResponseCode walletResponseCode : values()) {
            if (walletResponseCode.getCode().equals(code)) {
                return walletResponseCode;
            }
        }
        return WalletResponseCode.UNKNOW_STATUS;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        WalletResponseCode walletResponseCode = ofCode("120403");
        System.out.println(walletResponseCode);
        System.out.println(walletResponseCode == WITHDRAW_FEE_NOT_ENOUGH);
        System.out.println(walletResponseCode == WITHDRAW_CANNOT_TO_SELF);
        Assert.assertEquals(walletResponseCode, WITHDRAW_FEE_NOT_ENOUGH);
        Assert.assertNotEquals(walletResponseCode, WITHDRAW_CANNOT_TO_SELF);
        System.out.println("getByCode.............");
        getByCode(WITHDRAW_FEE_NOT_ENOUGH);
        getByCode(WITHDRAW_CANNOT_TO_SELF);
        getByCode(MOBILE_ERROR);
        getByCode(WITHDRAW_FEE_NOT_ENOUGH);
        getByCode(ILLEGAL_REQUEST_PARAM);
    }


    public static void getByCode(WalletResponseCode walletResponseCode) {
        switch (walletResponseCode) {
            case WITHDRAW_CANNOT_TO_SELF:
            case MOBILE_ERROR:
                System.out.println(walletResponseCode);
                break;
            case WITHDRAW_FEE_NOT_ENOUGH:
                System.out.println(walletResponseCode);
                break;
            default:
                System.out.println("OK-DEFAULT");
                break;
        }
    }
}
