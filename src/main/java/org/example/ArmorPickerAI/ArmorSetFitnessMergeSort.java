package org.example.ArmorPickerAI;

import java.util.ArrayList;

public class ArmorSetFitnessMergeSort {
    public void mergeSort(ArrayList<ArmorSetFitness> list, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(list, left, middle);
            mergeSort(list, middle + 1, right);
            merge(list, left, middle, right);
        }
    }

    void merge(ArrayList<ArmorSetFitness> list, int left, int middle, int right) {
        ArrayList<ArmorSetFitness> leftList = new ArrayList<>(list.subList(left, middle + 1));
        ArrayList<ArmorSetFitness> rightList = new ArrayList<>(list.subList(middle + 1, right + 1));

        int i = 0, j = 0;
        int k = left;

        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).getFitness() >= rightList.get(j).getFitness()) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }
        while (i < leftList.size()) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }
        while (j < rightList.size()) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}
