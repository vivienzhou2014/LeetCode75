public class ContainerWithMostWater11 {
    public static int maxArea(int[] height) {
        //start from the most left and most right column
        int maxArea = 0, left = 0, right = height.length - 1;
        while(left < right){
            //if bigger area is found, use it in maxArea
            maxArea = Math.max(Math.min(height[left], height[right]) * (right - left), maxArea);
            //the shorter column moves to seek for possible bigger area
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
