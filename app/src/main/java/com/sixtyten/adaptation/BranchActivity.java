package com.sixtyten.adaptation;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BranchActivity extends AppCompatActivity {

    private String[] mGroupsArray = new String[] { "Отраслевой инжиниринг по материаловедению",
                                                   "Организационно административная адаптация",
                                                   "Социально психологическая адаптация"};

    private String[] mWinterMonthsArray = new String[] { "Cопровождение материаловедческих программ",
                                                         "Обзор конструкционных материалов",
                                                         "Изучение функции головной материаловедческой организации",
                                                         "Разработка и контроль технологий изготовления материалов и ответственного оборудования" };
    private String[] mSpringMonthsArray = new String[] { "Ознакомиться с Трудовым кодексом РФ",
                                                         "Ознакомиться с Уставом компании",
                                                         "Внутренние рабочие нормативные акты" };
    private String[] mSummerMonthsArray = new String[] { "Знакомство с командой",
                                                         "Тимбилдинг" };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        Map<String, String> map;
        // коллекция для групп
        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();
        // заполняем коллекцию групп из массива с названиями групп

        for (String group : mGroupsArray) {
            // заполняем список атрибутов для каждой группы
            map = new HashMap<>();
            map.put("groupName", group); // время года
            groupDataList.add(map);
        }

        // список атрибутов групп для чтения
        String groupFrom[] = new String[] { "groupName" };
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int groupTo[] = new int[] { android.R.id.text1 };

        // создаем общую коллекцию для коллекций элементов
        ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();

        // в итоге получится сhildDataList = ArrayList<сhildDataItemList>

        // создаем коллекцию элементов для первой группы
        ArrayList<Map<String, String>> сhildDataItemList = new ArrayList<>();
        // заполняем список атрибутов для каждого элемента
        for (String month : mWinterMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month); // название месяца
            сhildDataItemList.add(map);
        }
        // добавляем в коллекцию коллекций
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для второй группы
        сhildDataItemList = new ArrayList<>();
        for (String month : mSpringMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для третьей группы
        сhildDataItemList = new ArrayList<>();
        for (String month : mSummerMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        // список атрибутов элементов для чтения
        String childFrom[] = new String[] { "monthName" };
        // список ID view-элементов, в которые будет помещены атрибуты
        // элементов
        int childTo[] = new int[] { android.R.id.text1 };

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groupDataList,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, сhildDataList, android.R.layout.simple_list_item_1,
                childFrom, childTo);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expListView);
        expandableListView.setAdapter(adapter);
    }
}
