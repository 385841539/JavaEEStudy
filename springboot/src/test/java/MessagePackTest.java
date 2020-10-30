import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.template.Templates;
import org.msgpack.type.Value;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MessagePackTest {


    private Gson gson;

    @Test
    public void testSimpleConvert() {


        MessagePack msgpack = new MessagePack();
        byte[] raw = new byte[0];
        try {
            raw = msgpack.write(new int[]{1, 2, 3});

            Value v = msgpack.read(raw);

            int[] array = msgpack.convert(v, new int[3]);
            assertArrayEquals(new int[]{1, 2, 3}, array);

            Value v2 = msgpack.unconvert(array);
            assertEquals(v, v2);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testSimpleConvertJson() throws IOException {

        gson = new Gson();
//        String userInfo = "{\"pId\":9527,\"pName\":\"华安\",\"isMarry\":true}";

        String userInfo = "{\"code\":0,\n" +
                "\n" +
                "\"data\":[\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"username\":\"小王\"\n" +
                "\n" +
                "},{\n" +
                "\n" +
                "\"username\":\"小张\"\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "}";

//        JSONObject s = JSONObject.parseObject(userInfo);

//        System.out.println("======" + s);

        MessagePack messagePack = new MessagePack();

        byte[] raw = messagePack.write(userInfo);


        String dst1 = messagePack.read(raw, Templates.TString);

        JSONObject s = JSONObject.parseObject(dst1);

        TestBean testBean = gson.fromJson(s.toJSONString(), TestBean.class);


        System.out.println("======" + s.toJSONString());

        System.out.println(dst1);//输出：{"pId":9527,"pName":"华安","isMarry":true}

    }


}
