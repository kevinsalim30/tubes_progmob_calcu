package id.klp1.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;

import id.klp1.calculator.API.apiBuild;
import id.klp1.calculator.API.apiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyActivity8 extends AppCompatActivity {

    Button button;
    EditText currencyToBeConverted;
    EditText currencyConverted;
    TextView convertToDropdown;
    TextView convertFromDropdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency2);

        currencyConverted = (EditText) findViewById(R.id.currency_converted);
        currencyToBeConverted = (EditText) findViewById(R.id.currency_to_be_converted);
        convertToDropdown = (TextView) findViewById(R.id.to);
        convertFromDropdown = (TextView) findViewById(R.id.from);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiInterface retrofitInterface = apiBuild.getRetrofitInstance().create(apiInterface.class);
                Call<JsonObject> call = retrofitInterface.getExchangeCurrency(convertFromDropdown.getText().toString());
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Log.d("response", String.valueOf(response.body()));
                        JsonObject res = response.body();
                        JsonObject rates = res.getAsJsonObject("rates");
                        double currency = Double.valueOf(currencyToBeConverted.getText().toString());
                        double multiplier = Double.valueOf(rates.get(convertToDropdown.getText().toString()).toString());
                        double result = currency * multiplier;
                        currencyConverted.setText(String.valueOf(result));
                    }
                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                    }
                });
            }
        });
    }
}