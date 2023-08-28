public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //In the method we use the position of 1 to calculate max flower we can plant(count)
        int count =0;
        //use prev to mark location of 1
        int prev = -1;
        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {
            if(flowerbed[i] == 1){
                //if this is the first 1 we found
                if(prev < 0){
                    count += i / 2;
                }else{
                    //if not ,we deduct two 0s beside each 1 then calculate count
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        //now we need to deal with 0s after the last 1
        if(prev < 0){
            //this means no 1 in flowerbed at all
            count = (m + 1) / 2;
        }else{
            //then we see how many flowers we can plant after the last 1
            count += (m - prev - 1) / 2;
        }
        return count >= n;










        //This would not work because it is causing indexOutOfBound error
        //1. check for the flowerbed, how many flowers can be planted(nCan)
        //1.1 how to check: rules: only three 0s between 1s can plant one flower
        //1.2 the first 0 found needs to get check if second and third are both 0
        //    if so, plant in second 0 and check from the third 0
        //    if not, check from the fourth place
        //corner case: when first/last number is 0, they just require the number beside them are 0 to plant
        //2. if n <= nCan, true, if not, false
/*        int i = 0;
        int count = 0;
        while(i < flowerbed.length){
            if(flowerbed[0]+flowerbed[1] == 0){
                count++;
                i++;
            }
            if(flowerbed[flowerbed.length-1]+flowerbed[flowerbed.length-2] == 0){
                count++;
            }
            if(flowerbed[i] != 0){
                i++;
            }else if(flowerbed[i] == 0){
                *//*if(flowerbed[i+1] == 0 && flowerbed[i+2] == 0){
                    count++;
                }*//*
                count += (flowerbed[i+1]==0 && flowerbed[ i+2]==0) ? 1 : 0;
                i += 2;
            }
        }*/
        //return count >= n;
    }
}
