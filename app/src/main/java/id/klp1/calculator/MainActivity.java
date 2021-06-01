package id.klp1.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView prevCalcu;
    private EditText curDisplay;
    private Button buttonsatuan;
    private Button buttoncurrency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prevCalcu = findViewById(R.id.previousCal);
        curDisplay = findViewById(R.id.curEditText);

        buttonsatuan = findViewById(R.id.buttonSatuan);
        buttonsatuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSatuan();
            }
        });
        buttoncurrency = findViewById(R.id.buttonCurr);
        buttoncurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCurr();
            }
        });

    }

    public void openCurr() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void openSatuan() {
        Intent intent = new Intent(this, MenuSatuanActivity.class);
        startActivity(intent);
    }


    private void updateText(String strToAdd) {
        String oldStr = curDisplay.getText().toString();
        int curPos = curDisplay.getSelectionStart();
        String leftStr = oldStr.substring(0, curPos);
        String rightStr = oldStr.substring(curPos);
        curDisplay.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        curDisplay.setSelection(curPos + strToAdd.length());
    }

    public void nolPush(View view) {
        updateText(getResources().getString(R.string.nolText));
    }

    public void satuPush(View view) {
        updateText(getResources().getString(R.string.satuText));
    }

    public void duaPush(View view) {
        updateText(getResources().getString(R.string.duaText));
    }

    public void tigaPush(View view) {
        updateText(getResources().getString(R.string.tigaText));
    }

    public void empatPush(View view) {
        updateText(getResources().getString(R.string.empatText));
    }

    public void limaPush(View view) {
        updateText(getResources().getString(R.string.limaText));
    }

    public void enamPush(View view) {
        updateText(getResources().getString(R.string.enamText));
    }

    public void tujuhPush(View view) {
        updateText(getResources().getString(R.string.tujuhText));
    }

    public void delapanPush(View view) { updateText(getResources().getString(R.string.delapanText)); }

    public void sembilanPush(View view) { updateText(getResources().getString(R.string.sembilanText)); }

    public void tambahPush(View view) {
        updateText(getResources().getString(R.string.tambahText));
    }

    public void bagiPush(View view) {
        updateText(getResources().getString(R.string.bagiText));
    }

    public void kurangPush(View view) {
        updateText(getResources().getString(R.string.kurangText));
    }

    public void kaliPush(View view) {
        updateText(getResources().getString(R.string.kaliText));
    }

    public void bukaPush(View view) { updateText(getResources().getString(R.string.kurungbukaText)); }

    public void tutupPush(View view) { updateText(getResources().getString(R.string.kurungtutupText)); }

    public void titikPush(View view) {
        updateText(getResources().getString(R.string.titikText));
    }

    public void clearPush(View view) {
        curDisplay.setText("");
    }

    public void equalPush(View view) {
        String userExp = curDisplay.getText().toString();
        userExp = userExp.replaceAll(getResources().getString(R.string.bagiText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.kaliText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        curDisplay.setText(result);
        curDisplay.setSelection(result.length());
    }

    public void deletePush(View view) {
        int cursorPos = curDisplay.getSelectionStart();
        int textLen = curDisplay.getText().length();

        if(cursorPos !=0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) curDisplay.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            curDisplay.setText(selection);
            curDisplay.setSelection(cursorPos-1);
        }
    }
}