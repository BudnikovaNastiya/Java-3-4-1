package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Afisha;
@Data
@NoArgsConstructor

public class AfishaManager {
    int amountFilmsMax =10;
    private Afisha[] items = new Afisha[0];

    public void add(Afisha item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Afisha[] tmp = new Afisha[length];


        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public int setAmountFilmsMax(int newAmountFilmsMax) {
        if (newAmountFilmsMax < 0) {
            return amountFilmsMax;
        }
        amountFilmsMax = newAmountFilmsMax;
        return amountFilmsMax;
    }

    public Afisha[] getAll() {
        int resultLength;
        if (items.length > amountFilmsMax) {
            resultLength = amountFilmsMax;
        } else {
            resultLength = items.length;
        }
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        Afisha[] result = new Afisha[amountFilmsMax];
        for (int i = 0; i < resultLength; i++) {
            int index = items.length -1 - i;
            result[i] = items[index];
        }
        return result;
    }

    public AfishaManager(int amountFilmsMax) {
        this.amountFilmsMax = amountFilmsMax;
    }
}

