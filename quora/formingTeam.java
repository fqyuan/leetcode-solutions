    public long threeSum(List<Integer> nums, int k) {
        Integer[] num = nums.toArray(new Integer[nums.size()]);
        Arrays.sort(num);
        long count = 0;
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > k / 3) break;
            int sum = k - num[i];
            int lo = i + 1, hi = num.length - 1;
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    if (num[lo] == num[hi]) {
                        count += (hi - lo + 1) * (hi - lo) / 2;
                        break;
                    }
                    int left = 1;
                    int right = 1;
                    while (num[lo] == num[lo + left]) left++;
                    while (num[hi] == num[hi - right]) right++;
                    count += left * right;
                    lo = lo + left;
                    hi = hi - right;

                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
            }

        }
        log.info("" + count);
        return count;