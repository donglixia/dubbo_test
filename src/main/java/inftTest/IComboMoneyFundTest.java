package inftTest;

import bean.FastJsonDiff;
import bean.TestResult;
import bean.TestUtils;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gffunds.service.inter.query.IHoldsInfoQuery;
import com.gffunds.service.inter.query.IWorkDayQuery;
import utils.DubboCallbackUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author ztt
 * @date 2018/11/29 15:03
 */
public class IComboMoneyFundTest {

    public static TestResult test(Properties properties,String exceptResult){
        String methodName = properties.getProperty("methodName");
        String interfaceStr = properties.getProperty("interface");//xxx
        String url = properties.getProperty("dubbo.url");
        String version = properties.getProperty("dubbo.version");
        List<Object> a=null;
        TestResult testResult =null;
        Object invoke = DubboCallbackUtil.invoke(interfaceStr, methodName, a, url, version);
        testResult = TestUtils.compareResult(exceptResult, invoke);
        if(testResult!=null){
            testResult.setTransferMethod(url);
        }
        return testResult;


//        ApplicationConfig applicationConfig =  new ApplicationConfig();
//        applicationConfig.setName("test");
////        String netno = "6686";
////        String tradeAcco = "00227100006158000";
////        String fundCode = "270046";
////        String shareType = "A";
////        BigDecimal requestShare = new BigDecimal("10026.09");
//        //读取properties，配置文件
//        String url = properties.getProperty("dubbo.url");
//
//        String version = properties.getProperty("dubbo.version");
//        String interfaceStr = properties.getProperty("interface");//xxx.class
//        //String jsonParam= properties.getProperty("jsonParam");//xxx.class
//        //1.读取参数
//        String methodName = properties.getProperty("methodName");
//        String anInterface = properties.getProperty("interface");
//
//
//        ReferenceConfig reference = new ReferenceConfig();
//        IHoldsInfoQuery  demoService= (IHoldsInfoQuery)reference.get();
//        reference.setApplication(applicationConfig);
//        reference.setInterface(interfaceStr);
//        reference.setUrl(url+"?version="+version);
//        TestResult testResult =null;
//        if(methodName.equals("queryNetInfoForHolds")){
//            Map<String, String> result = demoService.queryNetInfoForHolds();
//            testResult = TestUtils.compareResult(exceptResult, result);
//        } else{
//            testResult= TestUtils.compareResult(exceptResult, null);
//        }
//        testResult.setTransferMethod(url);
//        return testResult;
//
        //final IComboMoneyFund demoService = reference.get();
//        demoService.redeemByTradeaccoExceptWallet(netno, tradeAcco,
//                fundCode, shareType, requestShare, null, null, isForceDeal.equals("1") ? "1" :
//                        "0");
    }
    public static String test01(){
        return "{" +
                "\"person\": \"ztt\"," +
                "\"detail\": {" +
                "\"username\": \"tom\"," +
                "\"age\": 19" +
                "}" +
                "}";
    }
}
