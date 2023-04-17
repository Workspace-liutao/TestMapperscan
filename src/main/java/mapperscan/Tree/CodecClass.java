package mapperscan.Tree;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CodecClass {
    public static void main(String[] args) {
        CodecClass codecClass = new CodecClass();
        List<String> strs = new ArrayList<String>();
        strs.add("hello");
        strs.add("words");
        String encode = codecClass.encode(strs);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        HashMap  hashMap= new HashMap();
        concurrentHashMap.put("","");
        hashMap.put("","");
        List<String> list = codecClass.decode(encode);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }

    // Encodes string length to bytes string
    public String intToString(String s) {
        int x = s.length();
        char[] bytes = new char[4];
        for (int i = 3; i > -1; --i) {
            bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
        }
        return new String(bytes);
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(intToString(s));
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes bytes string to integer
    public int stringToInt(String bytesStr) {
        int result = 0;
        for (char b : bytesStr.toCharArray())
            result = (result << 8) + (int) b;
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0, n = s.length();
        List<String> output = new ArrayList();
        while (i < n) {
            int length = stringToInt(s.substring(i, i + 4));
            i += 4;
            output.add(s.substring(i, i + length));
            i += length;
        }
        return output;
    }
}
