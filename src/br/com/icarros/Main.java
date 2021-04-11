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
            }else if (number % 3 == 0){
                System.out.println(ConstantsUtil.FIZZ);
            }else if (number % 5 == 0){
                System.out.println(ConstantsUtil.BUZZ);
            }else{
                System.out.println(number);
            }
        });
    }

    public static void angryBirds(String[] stars ){
        char star = '*';
        List<String> starsList = Arrays.stream(stars).collect(Collectors.toList());
        starsList.forEach(s -> {
            System.out.println(s.chars().filter(st -> st == star).count());
        });
    }

    public static int creepyHours(String[] hours){
        String[] a;
        int contAux = 0, contFinal = 0;
        for (int i = 0; i < hours.length; i++){
            if(hours[i].charAt(0) == hours[i].charAt(1)){ // 00 xx
                contAux ++;
            }
            if (hours[i].charAt(3) == hours[i].charAt(4)){ // xx 00
                contAux ++;
            }
            if(hours[i].charAt(1) == hours[i].charAt(3)){  // x0 0x
                contAux ++;
            }
            if(hours[i].charAt(1) == hours[i].charAt(4)){  // x0 x0
                contAux ++;
            }
            if(hours[i].charAt(0) == hours[i].charAt(3)){  // 0x 0x
                contAux ++;
            }
            if (hours[i].charAt(0) == hours[i].charAt(4)){ //  0x x0
                contAux ++;
            }

            if (contAux % 2 ==  0){
                contFinal ++;
            }
            contAux = 0;
        }
        return contFinal;
    }
    public static void main(String[] args) {
        String[] stars = {"---","--*"};
        String[] hours = {"11:00", "10:00", "13:31"};
        fuzzingBuzzing();
        creepyHours(hours);
        angryBirds(stars);
    }

}
