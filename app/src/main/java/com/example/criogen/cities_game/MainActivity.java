package com.example.criogen.cities_game;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Update();
    }
    public String[] cities={"Адыгейск","Архангельск", "Астрахань",
            "Белогорск","Благовещенск", "Белорецк",
            "Великий Новгород","Великий Устюг","Верхнеуральск",
            "Гагарин","Гатчина","Геленджик",
            "Данилов","Дедовск","Дивногорск",
            "Ейск","Елец","Еманжелинск",
            "Железноводск","Железногорск","Жуков",
            "Заволжье","Заинск","Закаменск",
            "Иваново","Ипатово","Иркутск",
            "Казань","Калач","Калининград",
            "Люберцы","Липецк","Луза",
            "Магадан","Майкоп","Махачкала",
            "Нальчик","Нарьян-Мар","Нефтекамск",
            "Омск","Орёл","Оренбург",
            "Пенза","Пермь","Петрозаводск",
            "Ростов-на-Дону","Рязань","Рыбинск",
            "Салехард","Саратов","Севастополь",
            "Тамбов","Тверь","Тихорецк",
            "Улан-Удэ","Ульяновск","Уфа",
            "Фрязино","Фокино","Фурманов",
            "Хабаровск","Ханты-Мансийск","Холмск",
            "Цивильск", "Цимлянск",
            "Чебоксары","Челябинск","Черкесск",
            "Шадринск","Шахты","Шиханы",
            "Элиста","Эртиль","Электроугли",
            "Южно-Сахалинск","Южноуральск","Юхнов",
            "Якутск","Ялта","Ярославль"
    };

    public String[] citiesCopy;
    public String result;
    public char lastChar='-';
    public void Update()
    {
        citiesCopy=cities;
    }
    public void onClick(View view) {
        TextView CityOut=findViewById(R.id.CityOut);
        EditText CityIn= findViewById(R.id.CityIn);
        String name = CityIn.getText().toString();  //строка из поля ввода
        char[] charArray = name.toCharArray();
        int pos = name.length()-1;                  //позиция на последнюю букву
        lastChar=charArray[pos];

        if (lastChar=='й') lastChar= 'и';
        if (lastChar =='ы' || lastChar =='ъ' || lastChar =='ь')
        {
            pos--;
            lastChar=charArray[pos];
        }
        Search(lastChar);
        CityOut.setText(result);

    }
    public void Search (char gotChar)
    {
        Button reset=findViewById(R.id.buttonReset);
        Button button=findViewById(R.id.button2);
        result="";
        int index=0;
        char checkLetter=String.valueOf(gotChar).toUpperCase().charAt(0);
        for (String check:citiesCopy)
        {
            char firstLetter=check.charAt(0);
            if (firstLetter == checkLetter)
            {
               result=check;
               break;
            }
            index++;
        }
        if (result!="")
        {
           citiesCopy[index]="-";
        }
        else
        {
            result="Город не найден. Я проиграл.";
            button.setClickable(false);
            button.setTextColor(Color.GRAY);
            reset.setVisibility(View.VISIBLE);
        }
    }
    public  void onReset(View view)
    {
        Button button=findViewById(R.id.button2);
        button.setClickable(true);
        button.setTextColor(Color.BLACK);
        TextView textView=findViewById(R.id.CityOut);
        textView.setText("Введите город");
        Update();
    }

}
