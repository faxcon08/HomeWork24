import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;

public class Main {

    public static <T> void findMinMax(Stream <? extends T> stream, Comparator<? super T> comparator, BiConsumer <? super T,? super T> minMaxConsumer) {
        List<T> list;
        list=stream.sorted(comparator).collect(Collectors.toList());
        T min=null;
        T max=null;
        if (list.size()!=0){
            if(list.size()==1)
                min = max = list.get(0);
            else{
                min= list.get(0);
                max = list.get(list.size() - 1);
            }
        }
        minMaxConsumer.accept(min,max);
    }

    public static void evenNumberCount(List<Integer>list) {

        System.out.println(list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        Consumer<String> printTask = (x)->
        {String separator = " ====================== ";System.out.println(separator+x+separator);};

        Integer[] integerMass = {5,7,1,3};
        Double[] doubleMass = {7.1, 2.3, 5.7, 1.1};
        Stream <Integer> stream = Arrays.stream(integerMass);
        Comparator<Integer> integerComparator = new Comparator <Integer>(){
            @Override
            public int compare(Integer a1, Integer a2) {
                if(a1>a2)
                    return 1;
                if(a1<a2)
                    return -1;
                return 0;
            }
        };
        Comparator<Double> doubleComparator = new Comparator <Double>(){
            @Override
            public int compare(Double a1, Double a2) {
                if(a1>a2)
                    return 1;
                if(a1<a2)
                    return -1;
                return 0;
            }
        };
        BiConsumer<Integer,Integer> biConsumer = (x,y) ->{System.out.println("Min: "+x +" Max:"+y);};
        BiConsumer<Double,Double> doubleDoubleBiConsumer = (x,y)->System.out.println("Min: "+x+" Max: "+y);
        printTask.accept("First Task 1.1;");

        System.out.println(Arrays.asList(integerMass));
        findMinMax(stream,integerComparator,biConsumer);
        System.out.println();
        System.out.println(Arrays.asList(doubleMass));
        findMinMax(Arrays.stream(doubleMass),doubleComparator,doubleDoubleBiConsumer);

        printTask.accept(("Second Task 1.2;"));

        Integer[] mass2={3,4,1,5,8};

       evenNumberCount(Arrays.asList(mass2));
    }// main
}// Main