package bean;

/**
 * @author ztt
 * @date 2018/11/29 18:56
 */
public class TestResult {
    /**
     * ���Խ��
     */
    private boolean resultFlag;
    /**
     * �ԱȲ���
     */
    private String diffMsg;
    /**
     * ���񷵻�����
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
                "�����ýӿڷ���:transferMethod=" + transferMethod  +"��," +
                "����Ԥ�ڽ���ԱȽ��:resultFlag=" + resultFlag  +"��,"+
                "����Ԥ�ڽ���ԱȲ��촦:diffMsg='" + diffMsg + '\'' +"��,"+
                "�����񷵻ص����ݽ��:serviceReturn='" + serviceReturn + '\'' +
                "}��";
    }
}
