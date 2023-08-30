public class ProductOfArrayExeptSelf238 {
    public static int[] productExceptSelf(int[] nums) {
        //basic idea is to use preProduct and postProduct
        //result[i] = preProduct[i] * postProduct[i+1]
        /*int n = nums.length;
        int[] preProduct = new int[n + 1];
        preProduct[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            preProduct[i] = preProduct[i - 1] * nums[i - 1];
        }
        for(int num:preProduct){
            System.out.print(num+" ");
        }
        int[] postProduct = new int[n + 1];
        postProduct[n] = 1;
        for (int i = n - 1; i >= 0 ; i--) {
            postProduct[i] = postProduct[i + 1] * nums[i];
        }
        for(int num:postProduct){
            System.out.print(num+" ");
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = preProduct[i] * postProduct[i + 1];
        }
        return result;*/
        //to save memory, we use result to store preproduct and variable to store post Product
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int post = 1;
        for(int i = n - 1; i >= 0; i--){
            result[i] = result[i] * post;
            post = post * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums ={1,2,3,4};
        for(int num : productExceptSelf(nums)){
            System.out.print(num+" ");
        }
    }
}
