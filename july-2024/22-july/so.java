class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // selection sort
        int l = heights.length;
        int temp;
        String temps;

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (heights[i] < heights[j]) {
                    temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;

                    temps = names[i];
                    names[i] = names[j];
                    names[j] = temps;
                }
            }
        }

        System.gc();

        return names;
    }
}
