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

    PC("1","ddfff"),

    APP("2","dvve");

    private String label;
    private String desc;

    ClientSource(String label,String desc) {
        this.label = label;
        this.desc = desc;
    }

    public static  ClientSource valueOfType(String v) {
        for (ClientSource value : values()) {
            if (value.label.equals(v)) return value;
        }
        return null;
    }

    public String getLabel() {
        return label;
    }


    public static void main(String[] args) {
        ClientSource pc = ClientSource.valueOfType("1");
        System.out.println(pc);
    }
}
