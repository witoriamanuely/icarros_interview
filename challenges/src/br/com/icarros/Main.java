package br.com.icarros;

import br.com.icarros.util.ConstantsUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static  void fuzzingBuzzing(){
        int start = 1, end = 100;
        List<Integer> numbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
        numbers.forEach(number  -> {
            if (number % 3 == 0 && number % 5 == 0){
                System.out.println(ConstantsUtil.FIZZ_BUZZ);
            }else if (number % 3 == 0){
                System.out.println(ConstantsUtil.FIZZ);
            }else if (number % 5 == 0){
                System.out.println(ConstantsUtil.BUZZ);
            }else{
                System.out.println(number);
            }
        });
    }

    public static long angryBirds(String[] stars ){
        char star = '*';
        long total;
        List<String> starsList = Arrays.stream(stars).collect(Collectors.toList());
        total = starsList.stream().mapToLong(s -> s.chars().filter(st -> st == star).count()).sum();
        return total;
    }

    public static int creepyHours(String[] hours){
        int contFinal = 0;

        for (int i = 0; i < hours.length; i++){
            if((hours[i].charAt(0) == hours[i].charAt(1)) && (hours[i].charAt(3) == hours[i].charAt(4))){ // AA:BB - AA:AA
                contFinal ++;
            } else if((hours[i].charAt(1) == hours[i].charAt(3)) && (hours[i].charAt(0) == hours[i].charAt(4))){ // AB:BA
                contFinal ++;
            } else if(hours[i].charAt(0) == hours[i].charAt(3) && (hours[i].charAt(1) == hours[i].charAt(4))){ // AB: AB
                contFinal ++;
            }
        }

        return contFinal;
    }
    protected static int returnIndexKthLargest(int[] arr){
        int maxPoint = 0, indexMaxPoint = 0;
        for (int i = 0; i < arr.length; i++){
            if (maxPoint < arr[i]){
                maxPoint = arr[i];
                indexMaxPoint = i;
            }
        }
        return indexMaxPoint;
    }
    public static int theChampions(int[] wins, int[] ties){
        int indexMaxPointWin = returnIndexKthLargest(wins);
        int indexMaxPointTie = returnIndexKthLargest(ties);

        if ((wins[indexMaxPointWin]*ConstantsUtil.WINS_POINTS) >= ties[indexMaxPointTie]){
            return (wins[indexMaxPointWin] * ConstantsUtil.WINS_POINTS) + (ties[indexMaxPointWin] * ConstantsUtil.TIES_POINTS);
        }
        return (wins[indexMaxPointTie] * ConstantsUtil.WINS_POINTS) + (ties[indexMaxPointTie] * ConstantsUtil.TIES_POINTS);
    }


    public static void main(String[] args) {

        String[] stars = {"***","--*", "*--", "-*-", "---"};
        String[] hours = {"11:00", "00:00", "13:31", "12:12" ,"12:69"};
        int[] wins = {1,0,3};
        int[] ties = {2,2,0};


        fuzzingBuzzing(); // Q1
        creepyHours(hours); // Q2
        angryBirds(stars); // Q3
        theChampions(wins,ties); //Q4

    }

}
