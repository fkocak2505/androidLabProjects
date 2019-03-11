package tr.gov.saglik.dynamiccomponentcreatedev;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String json = "{\n" +
            "  \"componentArr\":[\n" +
            "    {\n" +
            "      \"valueType\":\"string\",\n" +
            "      \"componentType\":\"text\",\n" +
            "      \"isCompulsory\":null,\n" +
            "      \"textColor\": \"#000000\",\n" +
            "      \"hintText\":null,\n" +
            "      \"id\":2\n" +
            "    },\n" +
            "    {\n" +
            "      \"valueType\":\"string\",\n" +
            "      \"componentType\":\"text\",\n" +
            "      \"isCompulsory\":null,\n" +
            "      \"textColor\": \"#000000\",\n" +
            "      \"hintText\":null,\n" +
            "      \"id\":3\n" +
            "    },\n" +
            "    {\n" +
            "      \"valueType\":\"string\",\n" +
            "      \"componentType\":\"input\",\n" +
            "      \"isCompulsory\":true,\n" +
            "      \"textColor\": \"#FF0000\",\n" +
            "      \"hintText\":\"Fatih\",\n" +
            "      \"id\":4\n" +
            "    },\n" +
            "    {\n" +
            "      \"valueType\":null,\n" +
            "      \"componentType\":\"button\",\n" +
            "      \"isCompulsory\":false,\n" +
            "      \"textColor\": \"#FFFF00\",\n" +
            "      \"hintText\":null,\n" +
            "      \"id\":5\n" +
            "    },\n" +
            "    {\n" +
            "      \"valueType\":\"number\",\n" +
            "      \"componentType\":\"input\",\n" +
            "      \"isCompulsory\":false,\n" +
            "      \"textColor\": \"#FFFF00\",\n" +
            "      \"hintText\":\"123\",\n" +
            "      \"id\":6\n" +
            "    }\n" +
            "    ]\n" +
            "}";

    Gson gson = new Gson();
    ConstraintLayout constraintLayout;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        constraintLayout = new ConstraintLayout(this);
        constraintLayout.setId(1);
        ConstraintSet constraintSet = new ConstraintSet();


        ComponentModel componentModel = gson.fromJson(json, ComponentModel.class);
        List<ComponentArr> listOfComponentData = componentModel.getComponentArr();

        CreateDynamicScreen createDynamicScreen = new CreateDynamicScreen(this, listOfComponentData);
        if(createDynamicScreen.createComponent())
            Toast.makeText(this, "Ekran oluşturuldu", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Beklenmedik bir Component Tipi geldi.", Toast.LENGTH_SHORT).show();


        /*for (ComponentArr componentItem : listOfComponentData) {
            String valType = componentItem.getValueType();
            String compType = componentItem.getComponentType();

            boolean isRoot = componentItem.getId() == 1;

            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(600,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT);


            switch (compType) {
                case "text":
                    textView = new TextView(this);
                    textView.setId(componentItem.getId());
                    textView.setText("Fatih Koçak");
                    textView.setTextColor(Color.parseColor(componentItem.getTextColor()));
                    textView.setTextSize(16);
                    constraintLayout.addView(textView, params);
                    constraintSet.clone(constraintLayout);
                    if (componentItem.getId() == 2)
                        constraintSet.connect(textView.getId(), ConstraintSet.TOP, componentItem.getId() - 1, ConstraintSet.TOP, 8);
                    else
                        constraintSet.connect(textView.getId(), ConstraintSet.TOP, componentItem.getId() - 1, ConstraintSet.BOTTOM, 64);
                    constraintSet.connect(textView.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 60);
                    constraintSet.applyTo(constraintLayout);
                    break;
                case "input":
                    editText = new EditText(this);
                    editText.setId(componentItem.getId());
                    if (componentItem.getHintText() != null)
                        editText.setHint(componentItem.getHintText());
                    editText.setBackgroundResource(R.drawable.edt_input);
                    constraintLayout.addView(editText, params);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(editText.getId(), ConstraintSet.TOP, componentItem.getId() - 1, ConstraintSet.BOTTOM, 32);
                    constraintSet.connect(editText.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 60);
                    constraintSet.applyTo(constraintLayout);
                    break;
                case "button":
                    button = new Button(this);
                    button.setId(componentItem.getId());
                    button.setText("Awfawf");
                    constraintLayout.addView(button, params);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(button.getId(), ConstraintSet.TOP, componentItem.getId() - 1, ConstraintSet.BOTTOM, 32);
                    constraintSet.connect(button.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 60);
                    constraintSet.applyTo(constraintLayout);
                    break;

            }
        }

        setContentView(constraintLayout); */



        /*TextView textView = new TextView(this);
        textView.setId(2);
        textView.setText("Fatih Koçak");
        textView.setTextColor(Color.parseColor("#000000"));
        constraintLayout.addView(textView, params);
        constraintSet.clone(constraintLayout);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, 1, ConstraintSet.TOP, 160);
        constraintSet.connect(textView.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 60);
        constraintSet.applyTo(constraintLayout);

        TextView textView2 = new TextView(this);
        textView2.setId(3);
        textView2.setText("Fatih Koçakkkkkkk");
        textView2.setTextColor(Color.parseColor("#FF0000"));
        constraintLayout.addView(textView2, params2);
        constraintSet.clone(constraintLayout);
        constraintSet.connect(textView2.getId(), ConstraintSet.TOP, 2, ConstraintSet.BOTTOM, 16);
        constraintSet.connect(textView2.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 60);
        constraintSet.applyTo(constraintLayout);

        EditText editText = new EditText(this);
        editText.setId(4);
        editText.setHint("Kocak Deneme");
        editText.setBackgroundResource(R.drawable.edt_input);
        constraintLayout.addView(editText, params3);
        constraintSet.clone(constraintLayout);
        constraintSet.connect(editText.getId(), ConstraintSet.TOP, 3, ConstraintSet.BOTTOM, 16);
        constraintSet.connect(editText.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 60);
        constraintSet.applyTo(constraintLayout);

        EditText editText1 = new EditText(this);
        editText1.setId(5);
        editText1.setHint("Kocak Deneme12312");
        editText1.setBackgroundResource(R.drawable.edt_error_input);
        constraintLayout.addView(editText1, params4);
        constraintSet.clone(constraintLayout);
        constraintSet.connect(editText1.getId(), ConstraintSet.TOP, 4, ConstraintSet.BOTTOM, 16);
        constraintSet.connect(editText1.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 60);
        constraintSet.applyTo(constraintLayout);*/

          /*Button button = new Button(this);
        button.setId(Ids.ID_ONE);
        button.setText("Deneme");
        constraintLayout.addView(button, params);
        constraintSet.clone(constraintLayout);
        constraintSet.connect(button.getId(), ConstraintSet.TOP, constraintLayout.getId(), ConstraintSet.TOP, 160);
        constraintSet.connect(button.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 60);
        constraintSet.applyTo(constraintLayout);

        TextView textViev = new TextView(this);
        textViev.setId(Ids.ID_THREE);
        textViev.setText("Fatih Koçak");
        constraintLayout.addView(textViev, params1);
        constraintSet.clone(constraintLayout);
        constraintSet.connect(textViev.getId(), ConstraintSet.TOP, button.getId(), ConstraintSet.BOTTOM, 32);
        constraintSet.connect(textViev.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 60);
        constraintSet.applyTo(constraintLayout);*/

        //setContentView(constraintLayout);
    }
}
