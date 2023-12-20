package com.msaggik.ninthlessonmendeleevtable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    // поля
    private List<Element> elements; // контейнер (коллекция) для элементов периодической системы Менделеева

    private EditText minIn, maxIn;
    private Button button;
    private TextView output;

    private float minYear, maxYear; // буферные поля

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // инициализация коллекции
        elements = initialDate(elements);

        // связь полей представления с разметкой по id
        minIn = findViewById(R.id.minIn);
        maxIn = findViewById(R.id.maxIn);
        button = findViewById(R.id.button);
        output = findViewById(R.id.output);

        // обработаем нажатие кнопки
        button.setOnClickListener(listener);
    }

    // создадим слушатель кнопки и с помощью анонимного класса переопределим метод onClick(View view)
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String minValue = minIn.getText().toString();
            String maxValue = maxIn.getText().toString();

            // условие заполнения обоих полей
            if (minValue.length() > 0 && maxValue.length() > 0) {

                //очищаем TextView
                output.setText(null);

                // считывание введённых параметров
                minYear = Float.parseFloat(minValue);
                maxYear = Float.parseFloat(maxValue);

                // создание потока из коллекции
                Stream<Element> stream = elements.stream();

                // задание фильтрации и вывод результата на экран смартфона
                stream.filter(s -> s.getOpeningYear() >= minYear && s.getOpeningYear() <= maxYear)
                        .forEach(a -> output.append(a.getSymbol() + " (" + a.getMass() + ") открыт в " + a.getOpeningYear() + " году" + "\n"));
            } else {
                output.setText("Нужно заполнить оба поля");
            }
        }
    };

    // метод заполнения
    private List<Element> initialDate(List<Element> eList) {
        eList = new ArrayList<>(); // создание коллекции "гибкого массива"
        eList.add(new Element("Водород", "H", 1, 1.00794f, 1766));
        eList.add(new Element("Гелий", "He", 2, 4.002602f, 1895));
        eList.add(new Element("Литий", "Li", 3, 6.941f, 1817));
        eList.add(new Element("Бериллий", "Be", 4, 9.012182f, 1797));
        eList.add(new Element("Бор", "B", 5, 10.811f, 1808));
        eList.add(new Element("Углерод", "C", 6, 12.0107f, -1));
        eList.add(new Element("Азот", "N", 7, 14.0067f, 1772));
        eList.add(new Element("Кислород", "O", 8, 15.9994f, 1774));
        eList.add(new Element("Фтор", "F", 9, 18.9984032f, 1886));
        eList.add(new Element("Неон", "Ne", 10, 20.1797f, 1898));
        return eList;
    }
}