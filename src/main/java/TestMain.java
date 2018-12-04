import bean.TestResult;
import bean.TestUtils;
import com.alibaba.fastjson.JSON;
import inftTest.IComboMoneyFundTest;

import java.io.BufferedReader;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/**
 * @author ztt
 * @date 2018/11/29 10:03
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        String currPath = TestUtils.getCurrPath();
        Properties properties=TestUtils.loadProperties(currPath);
        String exceptResult = TestUtils.loadExpect(currPath);
        TestResult test = IComboMoneyFundTest.test(properties,exceptResult);
        TestUtils.resultFile(currPath,test);
    }
}
