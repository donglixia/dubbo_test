package bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author ztt
 * @date 2018/11/29 18:22
 */
public class TestUtils {
    public static TestResult compareResult(String exceptResult, Object result){
        TestResult testResult =new TestResult();
        JSONObject exceptResultObj = JSON.parseObject(exceptResult);
        if(result==null){
            return null;
        }
        JSONObject resultObj=(JSONObject)JSON.toJSON(result);
        FastJsonDiff.compareJson(exceptResultObj,resultObj,null);
        if(FastJsonDiff.sb.length()==0){
            testResult.setResultFlag(true);
        }else{
            testResult.setResultFlag(false);
            testResult.setDiffMsg(FastJsonDiff.sb.toString());
        }
        testResult.setServiceReturn(result.toString());
        return testResult;
    }
    /**
     * Ԥ���ļ�
     * @param currPath
     * @return
     */
    public static String loadExpect(String currPath){
        currPath = currPath + File.separator + "expect.txt";
        File file = new File(currPath);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(filecontent);
    }
    /**
     * �����ļ�
     * @param currPath
     * @throws Exception
     */
    public static Properties loadProperties(String currPath) throws Exception {
        Properties properties=null;
        currPath = currPath + File.separator + "input.txt";
        properties = new Properties();
        // ʹ��InPutStream����ȡproperties�ļ�
        BufferedReader bufferedReader = new BufferedReader(new FileReader(currPath));
        properties.load(bufferedReader);
        return properties;
    }
    /**
     * ����ļ�
     * @param currPath
     * @param test
     */
    public static void resultFile(String currPath,TestResult test) {
        if(test==null){
            return;
        }
        currPath = currPath + File.separator + "outPut.txt";
        FileWriter fw = null;
        try {
            //����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
            File f = new File(currPath);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pw.println("====����������ʱ��:"+sdf.format(new Date())+test);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ����·��
     * @return
     * @throws Exception
     */
    public static String getCurrPath()throws Exception{
        File directory = new File("");// ����Ϊ��
        String courseFile = directory.getCanonicalPath()+File.separator+"data";
        File f=new File(courseFile);
        if(!f.exists()){
            f.mkdirs();
        }
        System.out.println(courseFile);
        return  courseFile;
    }
}
