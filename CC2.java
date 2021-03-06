import java.util.*;

class CC2{
    static Scanner sc = new Scanner(System.in);
    static void fillArray(int[] arr){
        System.out.println("Enter the elements: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
    }
    static int trappedWater(int[] arr){
        int startingPoss = 0;
        int startingSize = 0;
        int finishPoss, finishSize;
        int tWater = 0;
        int counter = 0;
        int between = 0;
        boolean greaterThanOne = false;
        boolean match = false;
        for(int i = 0; i < arr.length; i++){
            if(counter > 0 && greaterThanOne){
                if(arr[i] < startingSize){
                    between += arr[i];
                }
                if(arr[i] >= startingSize){
                    match = true; 
                    finishPoss = i;
                    finishSize = arr[i];
                    tWater += ((((finishPoss-1) - startingPoss)*startingSize)- between);
                    between = 0;
                    counter = 0;
                }
                if(i == arr.length-1 && match == false){
                    i = startingPoss+1;
                    if(startingPoss+1 == arr.length){ break;}
                    counter = 0;
                    between = 0;
                }
            }
            
            if(counter > 0 && !greaterThanOne && arr[i] > 0){
                finishPoss = i;
                finishSize = arr[i];
                tWater += (finishPoss-1) - startingPoss;
                counter = 0;
            }

            if(arr[i] != 0 && counter == 0){
                match = false;
                startingPoss = i;
                startingSize = arr[i];
                counter++;
                if(startingSize > 1){
                    greaterThanOne = true;
                }
            }
        }
        return tWater;
    }
    public static void main(String args[]){
        int arrSize;
        arrSize = sc.nextInt();
        int array[] = new int[arrSize];
        fillArray(array);
        System.out.println(trappedWater(array));
    }
}
