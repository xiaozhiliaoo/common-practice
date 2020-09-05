package org.lili.jdk;

/**
 * 客户端来源
 *
 * @author lili
 * @date 2020/9/3 14:14
 * @see
 * @since
 */
public enum ClientSource {

    PC("PC"),

    APP("APP");

    private String label;

    ClientSource(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
