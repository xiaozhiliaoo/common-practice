package org.lili.jdk;

public class CompanyUtils {

    public static void remove(){
        threadCompanyId.remove();
    }


    private static ThreadLocal<Integer> threadCompanyId = new InheritableThreadLocal<>();


    public static void setCompanyId(Integer companyId) {
        if (companyId == null) {

            return;
        }
        CompanyUtils.threadCompanyId.set(companyId);
    }

    /**
     * 设置商户id
     *
     * @param companyId
     */
    public static void setCompanyId(String companyId) {
        CompanyUtils.threadCompanyId.set(Integer.valueOf(companyId));
    }

    /**
     * 获取商户id
     *
     * @return
     */
    public static Integer getCompanyId() {
        Integer companyId = threadCompanyId.get();
        //这里的逻辑最好被注释掉,但是要先弄清楚谁在用
        if (companyId == null) {
            CompanyUtils.setCompanyId(1);
        }
        return threadCompanyId.get();
    }
}
