import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        List<String> list = new ArrayList<>();
        list.add("ciao");
        list.add("ora");
        list.add("fiume");
        list.add("montagna");
        list.add("ahah");
        list.add("come");
        Stream<String> stream = list.stream();
        list.stream().filter(e -> e.contains("e")).map(e -> e + "stream?").forEach(e -> System.out.println(e));
        list.stream().filter(e -> e.contains("a")).map(e -> e + " altro esempio").forEach(e -> System.out.println(e));

    }


}