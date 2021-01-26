package com.wtcode;

import com.wtcode.crowd.util.CrowdUtil;
import org.junit.Test;

/**
 * @author wtcode
 * @date 2021/1/26 - 12:11
 */
public class StringTest {
    @Test
    public void testMd5(){
        String source = "123123123";
        String encoded = CrowdUtil.md5(source);
        System.out.println(encoded);
    }
}
