/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 *
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 */

package com.algorithm.array;

public class Erfenfa {
    public static void main(String[] args) {
        Erfenfa erfenfa = new Erfenfa();

        int[] nums = {-1,0,3,5,9,12};
        System.out.println(erfenfa.search(nums, 9));


    }

    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

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

}
