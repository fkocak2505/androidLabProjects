package com.example.fkocak.animatedcarddeneme;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ExampleDataset {

    private List<ECCardDataCustom> dataset;

    public ExampleDataset() {
        dataset = new ArrayList<>(5);

        CardData item5 = new CardData();
        item5.setMainBackgroundResource(R.mipmap.attractions);
        item5.setHeadBackgroundResource(R.mipmap.attractions_head);
        item5.setHeadTitle("Attractions");
        item5.setPersonMessage("Usus de bassus buxum, desiderium index!");
        item5.setPersonName("Marjorie Ellis");
        item5.setPersonPictureResource(R.mipmap.marjorie_ellis);
        item5.setListItems(prepareCommentsArray());
        dataset.add(item5);

        CardData item4 = new CardData();
        item4.setMainBackgroundResource(R.mipmap.city_scape);
        item4.setHeadBackgroundResource(R.mipmap.city_scape_head);
        item4.setHeadTitle("City Scape");
        item4.setPersonMessage("Solems manducare, tanquam neuter verpa.");
        item4.setPersonName("Mattew Jordan");
        item4.setPersonPictureResource(R.mipmap.mattew_jordan);
        item4.setListItems(prepareCommentsArray());
        dataset.add(item4);

        CardData item3 = new CardData();
        item3.setMainBackgroundResource(R.mipmap.cuisine);
        item3.setHeadBackgroundResource(R.mipmap.cuisine_head);
        item3.setHeadTitle("Cuisine");
        item3.setPersonMessage("Magnum lacteas ducunt ad orexis.");
        item3.setPersonName("Ross Rodriguez");
        item3.setPersonPictureResource(R.mipmap.ross_rodriguez);
        item3.setListItems(prepareCommentsArray());
        dataset.add(item3);

        CardData item2 = new CardData();
        item2.setMainBackgroundResource(R.mipmap.nature);
        item2.setHeadBackgroundResource(R.mipmap.nature_head);
        item2.setHeadTitle("Nature");
        item2.setPersonName("Tina Caldwell");
        item2.setPersonMessage("Nunquam perdere clabulare.");
        item2.setListItems(prepareCommentsArray());
        item2.setPersonPictureResource(R.mipmap.tina_caldwell);
        dataset.add(item2);

        CardData item1 = new CardData();
        item1.setMainBackgroundResource(R.mipmap.night_life);
        item1.setHeadBackgroundResource(R.mipmap.night_life_head);
        item1.setHeadTitle("Night Life");
        item1.setPersonMessage("Cur adelphis studere?");
        item1.setPersonName("Wallace Sutton");
        item1.setPersonPictureResource(R.mipmap.wallace_sutton);
        item1.setListItems(prepareCommentsArray());
        dataset.add(item1);

    }

    public List<ECCardDataCustom> getDataset() {
        Collections.shuffle(dataset);
        return dataset;
    }

    private List<Comment> prepareCommentsArray() {
        Random random = new Random();
        List<Comment> comments = new ArrayList<>();
        comments.addAll(Arrays.asList(
                new Comment(R.mipmap.aaron_bradley, "Aaron Bradley", "When the sensor experiments for deep space, all mermaids accelerate mysterious, vital moons.", "jan 12, 2014"),
                new Comment(R.mipmap.barry_allen, "Barry Allen", "It is a cold powerdrain, sir.", "jun 1, 2015"),
                new Comment(R.mipmap.bella_holmes, "Bella Holmes", "Particle of a calm shield, control the alignment!", "sep 21, 1937"),
                new Comment(R.mipmap.caroline_shaw, "Caroline Shaw", "The human kahless quickly promises the phenomenan.", "may 23, 1967"),
                new Comment(R.mipmap.connor_graham, "Connor Graham", "Ionic cannon at the infinity room was the sensor of voyage, imitated to a dead pathway.", "sep 1, 1972"),
                new Comment(R.mipmap.deann_hunt, "Deann Hunt", "Vital particles, to the port.", "aug 13, 1995"),
                new Comment(R.mipmap.ella_cole, "Ella Cole", "Stars fly with hypnosis at the boldly infinity room!", "nov 18, 1952"),
                new Comment(R.mipmap.jayden_shaw, "Jayden Shaw", "Hypnosis, definition, and powerdrain.", "apr 1, 2013"),
                new Comment(R.mipmap.jerry_carrol, "Jerry Carrol", "When the queen experiments for nowhere, all particles control reliable, cold captains.", "nov 14, 1964"),
                new Comment(R.mipmap.lena_lucas, "Lena Lukas", "When the c-beam experiments for astral city, all cosmonauts acquire remarkable, virtual lieutenant commanders.", "may 4, 1965"),
                new Comment(R.mipmap.leonrd_kim, "Leonard Kim", "Starships walk with love at the cold parallel universe!", "jul 3, 1974"),
                new Comment(R.mipmap.marc_baker, "Mark Baker", "Friendship at the bridge that is when quirky green people yell.", "dec 24, 1989")));
        Collections.shuffle(comments);
        return comments.subList(0, 6 + random.nextInt(5));
    }
}
