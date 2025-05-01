package org.prefix_sum;


//Считаем количество перекладываний для каждой позиции с 1 и в итоге получаем сумму всех шагов
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
     public int[] minOperations(String boxes) {
         int size = boxes.length();
         int[] result = new int[size];

         for (int i = 0; i < size; ++i) {
             if (boxes.charAt(i) == '1') {
                 for (int j = 0; j < size; ++j) {
                     result[j] = result[j] + Math.abs(i - j);
                 }
             }
         }
         return result;
     }

}
