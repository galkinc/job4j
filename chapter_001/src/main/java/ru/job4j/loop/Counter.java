package ru.job4j.loop;

public class Counter {

    /**
     *
     * Return's sum of even numbers
     * eg. From 1 to 10 return sum of even numbers equal 30 (2 + 4 + 6 + 8 + 10).
     *
     * @param start
     * @param finish
     * @return Sum of even numbers from start to finish.
     */
    public int add(int start, int finish) {

        int sum = 0;

        // Check that start < finish,
        // if not change place start = finish, finish = prev. start
        if (start > finish) {
            int tmp = start;
            start = finish;
            finish = tmp;
        }

        // Summarize all even numbers
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
