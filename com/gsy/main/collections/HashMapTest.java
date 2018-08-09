package gsy.main.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author gongshiyun
 * @Description hashmap 遍历方式练习,以及遍历性能测试
 * 输出:
 * Map 初始化1000000条数据时间: 1040014952
 * 遍历方式1:通过 keySet 进行循环遍历: 52262563
 * 遍历方式2:通过 Map.entrySet 使用 iterator 遍历 key 和 value: 40783708
 * 遍历方式3:通过 Map.entrySet 遍历 key 和 value: 34407489
 * 遍历方式4: 通过 map.keySet().iterator() 遍历: 32135582
 *
 * Map 初始化100000条数据时间: 35574972
 * 遍历方式1:通过 keySet 进行循环遍历: 13408674
 * 遍历方式2:通过 Map.entrySet 使用 iterator 遍历 key 和 value: 6436631
 * 遍历方式3:通过 Map.entrySet 遍历 key 和 value: 3298929
 * 遍历方式4: 通过 map.keySet().iterator() 遍历: 4588371
 *
 * Map 初始化1000条数据时间: 1227517
 * 遍历方式1:通过 keySet 进行循环遍历: 712118
 * 遍历方式2:通过 Map.entrySet 使用 iterator 遍历 key 和 value: 259776
 * 遍历方式3:通过 Map.entrySet 遍历 key 和 value: 154431
 * 遍历方式4: 通过 map.keySet().iterator() 遍历: 138950
 *
 * @date 2018/8/3
 */
public class HashMapTest {

    public static void main(String[] args) {
        long t1, t2, t3, t4, t5, t6, init, initEnd;
        final int MAP_INIT_NUM = 1000000;
        // 指定初始值,赋值100000值所需时间21855171
        // 不指定初始值,赋值100000所需时间39124238
        Map<String, String> map = new HashMap<>(MAP_INIT_NUM);

        init = System.nanoTime();

        for (int i = 0; i < MAP_INIT_NUM; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }

        initEnd = System.nanoTime();

        t1 = System.nanoTime();
        /**
         * 遍历方式1:通过 keySet 进行循环遍历
         */
        System.out.println("遍历方式1:通过 keySet 进行循环遍历:");
        for (String key : map.keySet()) {
            //System.out.println("Key: " + key + " Value: " + map.get(key));
            map.get(key);
        }
        //map.keySet().forEach(k -> map.get(k)); //使用forEach耗费时间更多

        t2 = System.nanoTime();

        /**
         * 遍历方式2:通过 Map.entrySet 使用 iterator 遍历 key 和 value
         */
        System.out.println("遍历方式2:通过 Map.entrySet 使用 iterator 遍历 key 和 value :");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            //System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
            entry.getValue();
        }

        t3 = System.nanoTime();

        /**
         * 遍历方式3:通过 Map.entrySet 遍历 key 和 value
         */
        System.out.println("遍历方式3:通过 Map.entrySet 遍历 key 和 value :");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
            entry.getValue();
        }
        //map.entrySet().forEach(k -> k.getValue());

        t4 = System.nanoTime();
        /**
         * 遍历方式4: 通过 map.keySet().iterator() 遍历
         */
        System.out.println("遍历方式4: 通过 map.keySet().iterator() 遍历 :");
        Iterator keyIt = map.keySet().iterator();
        while (keyIt.hasNext()) {
            Object key = keyIt.next();
            map.get(key);
        }

        t5 = System.nanoTime();

        System.out.println("Map 初始化" + MAP_INIT_NUM + "条数据时间: " + (initEnd - init));
        System.out.println("遍历方式1:通过 keySet 进行循环遍历: " + (t2 - t1));
        System.out.println("遍历方式2:通过 Map.entrySet 使用 iterator 遍历 key 和 value: " + (t3 - t2));
        System.out.println("遍历方式3:通过 Map.entrySet 遍历 key 和 value: " + (t4 - t3));
        System.out.println("遍历方式4: 通过 map.keySet().iterator() 遍历: " + (t5 - t4));

    }
}
