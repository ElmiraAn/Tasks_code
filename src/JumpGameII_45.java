import java.util.List;

public class JumpGameII_45 {
    public static void main(String[] params) {
        int[] nums = new int[]{2, 3, 1, 1, 4, 5};

        //int [] nums = new int[]{10,1,2,7,6,1,5};
        //int target =8; //[[2,2,2,2],[2,3,3],[3,5]]
        int res = jump(nums);

        System.out.println(res);
    }

    public static int jump(int[] nums) {
        int l=0, r= nums[0];
        int times=1;
        int next=0;
        while (r<nums.length-1){
            times++;

            for (int i =l; i<=r;i++){
                next = Math.max(next,i+nums[i]);
            }
            l=r;
            r=next;
        }
        return times;
    }

}

