public class ContainerWithMostWater_11 {
    /*You are given an integer array height of length n.
     There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     Find two lines that together with the x-axis form a container, such that the container contains the most water.
     Return the maximum amount of water a container can store.
     */
    public static void main(String[] params) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int s = maxArea(height);
        System.out.println(s);
    }
    public static int maxArea(int[] height) {
        int max=0;
        int index_l = 0;
        int index_r=height.length-1;

        while (index_l<index_r){
            max = Math.max(Math.min(height[index_l],height[index_r])*(index_r-index_l), max);
            if (height[index_l]<height[index_r]) index_l++;
            else  if (height[index_l]>height[index_r]) index_r--;
            else {
                index_l++;
                index_r--;
            }
        }
        return max;
    }
}

