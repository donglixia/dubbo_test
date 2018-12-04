package bean;

import java.util.Iterator;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
/**
 * @author ztt
 * @date 2018/11/29 16:52
 */
public class FastJsonDiff {
    public static StringBuffer sb=new StringBuffer();
    @SuppressWarnings("unchecked")
    public static void compareJson(JSONObject json1, JSONObject json2, String key) {
        Iterator<String> i = json1.keySet().iterator();
        while (i.hasNext()) {
            key = i.next();
            compareJson(json1.get(key), json2.get(key), key);
        }
    }

    public static void compareJson(Object json1, Object json2, String key) {
        if (json1 instanceof JSONObject) {
            compareJson((JSONObject) json1, (JSONObject) json2, key);
        } else if (json1 instanceof JSONArray) {
            compareJson((JSONArray) json1, (JSONArray) json2, key);
        } else if (json1 instanceof String) {
            try {
                String json1ToStr = json1.toString();
                String json2ToStr = json2.toString();
                compareJson(json1ToStr, json2ToStr, key);
            } catch (Exception e) {
                sb.append("ת�������쳣 key:" + key+";");
                e.printStackTrace();
            }

        } else {
            compareJson(json1.toString(), json2.toString(), key);
        }
    }

    public static void compareJson(String str1, String str2, String key) {
        if (!str1.equals(str2)) {
            sb.append("��һ��key:"+key+ ",json1:"+ str1 +",json2:"+str2+";");
        }
    }

    public static void compareJson(JSONArray json1, JSONArray json2, String key) {
        if (json1 != null && json2 != null) {
            Iterator i1 = json1.iterator();
            Iterator i2 = json2.iterator();
            while (i1.hasNext()) {
                compareJson(i1.next(), i2.next(), key);
            }
        } else {
            if (json1 == null && json2 == null) {
                sb.append("��һ�£�key:" + key + "  ��json1��json2�о�������;");
                System.err.println("��һ�£�key:" + key + "  ��json1��json2�о�������;");
            } else if (json1 == null) {
                sb.append("��һ�£�key:" + key + "  ��json1�в�����;");
            } else if (json2 == null) {
                sb.append("��һ�£�key:" + key + "  ��json2�в�����;");
            } else {
                sb.append("��һ�£�key:" + key + "  δ֪ԭ��;");
            }

        }
    }

//    private final static String st1 = "{\"username\":\"tom\",\"age\":18,\"address\":[{\"province\":\"�Ϻ���\"},{\"city\":\"�Ϻ���\"},{\"disrtict\":\"������\"}]}";
//    private final static String st2 = "{username:\"tom\",age:19}";
//    private final static String st3 = "{username:\"tom\",age:19}";
//
//    public static void main(String[] args) {
//        System.out.println(st1);
//        JSONObject jsonObject1 = JSONObject.parseObject(st2);
//        JSONObject jsonObject2 = JSONObject.parseObject(st3);
//        compareJson(jsonObject1, jsonObject2, null);
//        System.out.println(sb.length());
//    }
}
