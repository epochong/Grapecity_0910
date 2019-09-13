import java.util.*;

/**
 * @author epochong
 * @date 2019/9/10 14:56
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class Main {

    public static void maxCount(String str) {
        class Vocab {
            public Vocab(String word,int times) {
                this.times = times;
                this.word = word;
            }
            String word;
            int times;
        }
        class AscCompartor implements Comparator<Vocab> {

            @Override
            public int compare(Vocab o1, Vocab o2) {
                if (o1.times - o2.times > 0) {
                    return 1;
                } else if (o1.times - o2.times < 0) {
                    return -1;
                }
                return o1.word.compareTo(o2.word);
            }
        }
        HashMap<String,Integer> map = new HashMap <>();
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                map.put(strings[i],map.get(strings[i]) + 1);
            } else {
                map.put(strings[i],1);
            }
        }
        TreeSet<Vocab> set = new TreeSet <>(new AscCompartor());
        for (String key :
             map.keySet()) {
            set.add(new Vocab(key,map.get(key)));
        }
        System.out.println(set.last().word + ":" + set.last().times);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        maxCount(s);
    }
}
