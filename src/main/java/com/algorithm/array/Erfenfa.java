/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 *
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 */

/**
 * 解法笔记：
 * 凝结一句话就是要比较过程要覆盖数组中的所有元素，不能遗漏，特别是边界条件的遗漏
 * 如果选择left <= right,那么初始右侧边界条件就是right = nums.length - 1;
 * 此后更新右侧边界条件直接是right = middle - 1;因为右侧是闭区间，可以覆盖所有元素
 * 但是如果是开区间，那么right = middle;这样才能覆盖左侧的所有元素
 */

package com.algorithm.array;

public class Erfenfa {
    public static void main(String[] args) {
        Erfenfa erfenfa = new Erfenfa();

        int[] nums = {-1,0,3,5,9,12};
        System.out.println(erfenfa.search(nums, 9));


    }

    /**
     * 左闭右闭区间
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1; // 右侧边界需要比较，所以是nums.length - 1;

        while(left <=  right){
            int middle = left + (right - left)/2;
            if(nums[middle] < target){
                left = middle + 1;
            }else if(nums[middle] > target){
                right = middle - 1;
            }else{
                return middle;
            }
        }

        return -1;
    }

    /**
     * 左闭右开区间
     * @param nums
     * @param target
     * @return
     */
    public int search01(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 右边界不用比较，所以是索引+1，即nums.length
        while (left < right) {

            int middle = left + (right - left) / 2;//防止溢出
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle; //左闭右开，下一区间不会比较右区间，不能right = middle - 1;这样会漏掉右区间的数字比较
            } else {
                return middle;
            }
        }
        return -1;
    }

}
