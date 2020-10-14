package Day09.Homework;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

public class MapQuestion4 {
    public static void main(String[] args) {
        LinkedHashMap<String, String[]> qinHuangDaoShi = new LinkedHashMap<>();
        String[] qinHuangDao = {"海港区", "山海关区", "北戴河区", "昌黎县"};
        qinHuangDaoShi.put("秦皇岛市", qinHuangDao);

        LinkedHashMap<String, String[]> tangShanShi = new LinkedHashMap<>();
        String[] tangShan = {"路北区", "路南区", "古冶区", "开平区"};
        tangShanShi.put("唐山市", tangShan);

        LinkedHashMap<String, LinkedHashMap<String, String[]>> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("秦皇岛市", qinHuangDaoShi);
        linkedHashMap.put("唐山市", tangShanShi);

        linkedHashMap.forEach(new BiConsumer<String, LinkedHashMap<String, String[]>>() {
            @Override
            public void accept(String s, LinkedHashMap<String, String[]> stringLinkedHashMap) {
                System.out.print(s + ": " + Arrays.toString(stringLinkedHashMap.get(s)));
                System.out.println();
            }
        });
    }
}
