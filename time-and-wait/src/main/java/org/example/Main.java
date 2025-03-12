package org.example;
import java.util.Arrays;

public class Main {
    public static void print_array(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //calculates the wait times in an array of process burst times, assuming the order of processes as given
    public static int[] wait_times(int[] burst_times) {
        int time_passed = 0;
        int[] wait_times = new int[burst_times.length];

        for (int i = 0; i < burst_times.length; i++) {
            if (i==0) {
                wait_times[i] = 0;
            } else {
                time_passed += burst_times[i-1];
                wait_times[i] = time_passed;
            }
        }
        return wait_times;
    }

    /*public static int[] turnaround_times(int[] burst_times) {
        int time_passed = 0;
        int[] t_times = new int[burst_times.length]; //just shorthand


    }*/

    public static void main(String[] args) {
        int[] burst_times = {2, 1, 8, 4, 5};

        //computing times for FCFS
        int[] wait_times_fcfs = wait_times(burst_times);
        //int[] turnaround_times_fcfs = turnaround_times(burst_times);
        print_array(wait_times_fcfs);
        //print_array(turnaround_times_fcfs);

        //sort tasks for SJF
        Arrays.sort(burst_times);
        int[] wait_times_sjf = wait_times(burst_times);
        print_array(wait_times_sjf);
    }
}