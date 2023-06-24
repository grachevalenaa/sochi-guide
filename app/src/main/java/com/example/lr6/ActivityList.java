package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    ArrayList<Point> points;

    ArrayList<Point> allPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        User user = getUser();
        ListView listView = findViewById(R.id.listview);

        ((TextView) findViewById(R.id.textView1)).setText("Здравствуйте, " + user.getName() + "!\nВы можете ознакомиться с достопримечтаельностями города Сочи");
        points = createList();  // явно заполняем достопримечательностями список
        allPoints = new ArrayList<>(points);

        SightAdapter sightAdapter = new SightAdapter(this, points, user);
        listView.setClickable(true);
        listView.setAdapter(sightAdapter);

        LinearLayout filterBar = findViewById(R.id.filter);
        Button buttonHistorical = filterBar.findViewById(R.id.historical);
        Button buttonAll = filterBar.findViewById(R.id.all);
        Button buttonEntertainment = filterBar.findViewById(R.id.entertainment);
        Button buttonSporty = filterBar.findViewById(R.id.sporty);

        buttonAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sightAdapter.setPoints(filterList(TypeOfSight.ALL));
            }
        });

        buttonHistorical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sightAdapter.setPoints(filterList(TypeOfSight.HISTORICAL));
            }
        });

        buttonEntertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sightAdapter.setPoints(filterList(TypeOfSight.ENTERTAINMENT));
            }
        });

        buttonSporty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sightAdapter.setPoints(filterList(TypeOfSight.SPORTY));
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityList.this, ActivityMap.class);
                intent.putExtra("data", points.get(position));
                startActivity(intent);
            }
        });
    }

    private User getUser() {
        Bundle extras = getIntent().getExtras();
        User user = extras.getParcelable("user");
        return user;
    }

    private ArrayList<Point> createList() {
        points = new ArrayList<>();
        String info1 = "Парк «Дендрарий» по праву считается одним из знаковых мест города Сочи, его часто называют «зеленым сердцем курорта», что совершенно оправдано. На площади в 46,4 га собраны деревья и кустарники, привезенные из самых разных уголков планеты. На сегодняшний день в живой коллекции парка более 1800 видов и форм, в том числе 66 из них — дубы, 74 — сосны, 54 — пальмы и огромное количество редких экзотов.";
        String info2 = "«Ривьера» — парк, площадью 14 ГА в центральном районе Сочи, который считается одним из самых попсовых мест для отдыха. Здесь есть развлечения, которые подойдут и взрослым и детям. В парке много растений, поэтому гости Сочи часто путают «Ривьеру» и сочинский дендрарий.";
        String info3 = "Олимпийский парк (Олимпийская деревня) — общественная зона и одна из достопримечательностей Большого Сочи, главный комплексный объект Зимних Олимпийских игр 2014 года и одно из мест проведения в России Чемпионата мира по футболу 2018. Расположен в городском округе посёлка городского типа федеральной территории «Сириус», в Имеретинской низменности, на берегу Чёрного моря. ";
        String info4 = "«Музей истории города-курорта Сочи» - музей истории города-курорта Сочи (до 1980 года - \"Краеведческий\") создан в июле 1920 г. на основе коллекций Кавказского горного клуба и является одним из старейших учреждений культуры города.";
        String info5 = "Океанариум Sochi Discovery World Aquarium — один из самых больших океанариумов России, открытый в Адлерском микрорайоне города Сочи 26 декабря 2009 года. В двухэтажном здании Адлерского океанариума площадью 6 тысяч кв.м живут около 4 тысяч различных рыб более двухсот видов. Живут рыбки и другие водоплавающие в 30 больших и маленьких аквариумах, наполняют которые более 5 млн литров воды.";
        String info6 = "Сочи Парк — первый тематический парк страны и один из наиболее мощных магнитов, притягивающих в Сочи туристов со всего мира. На протяжении восьми лет он подтверждает звание лучшего в стране и СНГ открытого развлекательного парка с количеством посетителей свыше миллиона человек в год, а в 2016 году вошел в топ-25 лучших парков Европы.";
        String info7 = "«Роза Хутор» — круглогодичный горный курорт, расположенный на берегах реки Мзымта и горных склонах к югу от неё в Адлерском районе Сочи.";
        String info8 = "Скайпарк (SkyPark) — первый и пока единственный в России парк приключений на высоте. Подобные площадки существуют также в Австралии, Сингапуре, Китае, Франции, Германии. Идейным вдохновителем и основателем выступил экстремал Алан Хаккет, более известный как Эй Джей Хаккет. Комплекс расположен в 17 км от железнодорожного вокзала Адлера по направлению к Красной Поляне.";
        points.add(new Point(new com.yandex.mapkit.geometry.Point(43.572013, 39.742429), info1, "Сочинский Дендрарий", "бесплатно", "круглосуточно", TypeOfSight.HISTORICAL));
        points.add(new Point(new com.yandex.mapkit.geometry.Point(43.591395, 39.715875), info2, "Парк Ривьера", "бесплатно", "круглосуточно", TypeOfSight.ENTERTAINMENT));
        points.add(new Point(new com.yandex.mapkit.geometry.Point(43.402, 39.955), info3, "Олимпийский парк", "бесплатно", "круглосуточно", TypeOfSight.SPORTY));
        points.add(new Point(new com.yandex.mapkit.geometry.Point(43.590273, 39.723423), info4, "Музей истории города-курорта Сочи", "бесплатно", "круглосуточно", TypeOfSight.HISTORICAL));
        points.add(new Point(new com.yandex.mapkit.geometry.Point(43.4718422, 39.8971298), info5, "Sochi Discovery World Aquarium", "бесплатно", "круглосуточно", TypeOfSight.ENTERTAINMENT));
        points.add(new Point(new com.yandex.mapkit.geometry.Point(43.4045792, 39.9640923), info6, "Сочи Парк", "бесплатно", "круглосуточно", TypeOfSight.ENTERTAINMENT));
        points.add(new Point(new com.yandex.mapkit.geometry.Point(43.6769142, 40.2809639), info7, "Роза Хутор", "бесплатно", "круглосуточно", TypeOfSight.HISTORICAL));
        points.add(new Point(new com.yandex.mapkit.geometry.Point(43.524870, 39.997230), info8, "Скайпарк Сочи", "бесплатно", "круглосуточно", TypeOfSight.SPORTY));
        return points;
    }

    private ArrayList<Point> filterList(TypeOfSight typeOfSight) {

        points.clear();

        if (typeOfSight.equals(TypeOfSight.ALL)) {
            points.addAll(allPoints);
        }


        for (Point point : allPoints) {
            if (point.typeOfSight.equals(typeOfSight)) {
                points.add(point);
            }
        }

        return points;
    }
}