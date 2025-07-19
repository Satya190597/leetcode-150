class Solution56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
            return intervals;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int[][] result = new int[intervals.length][2];
        int index = 0;
        result[index] = intervals[0];
        index++;
        for(int i = 1; i < intervals.length; i++)
        {
            if(result[index-1][1]>=intervals[i][0])
                result[index-1][1] = Math.max(result[index-1][1],intervals[i][1]);
            else {
                result[index] = intervals[i];
                index++;
            }
        }
        return copyTheArray(result,index);
    }
    private int[][] copyTheArray(int[][] input,int size) {
        int[][] copyResult = new int[size][2];
        for(int i = 0; i < size; i++)
        {
            copyResult[i] = input[i];
        }
        return copyResult;
    }
}