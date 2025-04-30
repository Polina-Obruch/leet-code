package org.TopInterview;

//Удаление дубликатов, если их больше какого-то заданного количества
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {

            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                ++j;
                count = 1;
            } else if (count <= 1) {
                nums[j] = nums[i];
                ++count;
                ++j;
            }
        }
        return j;
    }

    public int removeDuplicates_VariantTwo(int[] nums) {
        int idx = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[idx-2]){
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}
