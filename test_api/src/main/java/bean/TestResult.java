package bean;

/**
 * @author ztt
 * @date 2018/11/29 18:56
 */
public class TestResult {
    /**
     * 测试结果
     */
    private boolean resultFlag;
    /**
     * 对比差异
     */
    private String diffMsg;
    /**
     * 服务返回数据
     */
    private String serviceReturn;
    private String transferMethod;

    public String getTransferMethod() {
        return transferMethod;
    }

    public void setTransferMethod(String transferMethod) {
        this.transferMethod = transferMethod;
    }

    public boolean isResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(boolean resultFlag) {
        this.resultFlag = resultFlag;
    }

    public String getDiffMsg() {
        return diffMsg;
    }

    public void setDiffMsg(String diffMsg) {
        this.diffMsg = diffMsg;
    }

    public String getServiceReturn() {
        return serviceReturn;
    }

    public void setServiceReturn(String serviceReturn) {
        this.serviceReturn = serviceReturn;
    }

    @Override
    public String toString() {
        return "TestResult{/n" +
                "【调用接口方法:transferMethod=" + transferMethod  +"】," +
                "【与预期结果对比结果:resultFlag=" + resultFlag  +"】,"+
                "【与预期结果对比差异处:diffMsg='" + diffMsg + '\'' +"】,"+
                "【服务返回的数据结果:serviceReturn='" + serviceReturn + '\'' +
                "}】";
    }
}
