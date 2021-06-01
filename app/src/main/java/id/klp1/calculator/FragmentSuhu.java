package id.klp1.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FragmentSuhu extends Fragment {
    EditText editTxtNilai;
    Button btnKonversi;
    TextView txtHasil;
    Spinner spinnerSatuan, spinnerKonversi;

    public FragmentSuhu() {
        // Required empty public constructor
    }

    public static FragmentSuhu newInstance() {

        Bundle args = new Bundle();

        FragmentSuhu fragment = new FragmentSuhu();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_suhu, container, false);
        spinnerSatuan = view.findViewById(R.id.spinnerSatuan);
        spinnerKonversi = view.findViewById(R.id.spinnerKonversi);
        editTxtNilai = view.findViewById(R.id.editTxtNilai);
        txtHasil = view.findViewById(R.id.txtHasil);
        btnKonversi = view.findViewById(R.id.btnKonvert);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.satuanArraySuhu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSatuan.setAdapter(adapter);
        spinnerKonversi.setAdapter(adapter);

        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konversi();
            }
        });
        return view;
    }

    public void konversi() {
        String input = editTxtNilai.getText() + "";
        if (input.isEmpty()) {
            Toast.makeText(getActivity().getApplicationContext(), "Masukan nilai", Toast.LENGTH_SHORT).show();
        } else {
            txtHasil.setText(getHasil(Double.parseDouble(input)));
        }
    }

    public String getHasil(double input) {
        double hasil = 0.0;
        String satuan = String.valueOf(spinnerSatuan.getSelectedItemPosition());
        String konversi = String.valueOf(spinnerKonversi.getSelectedItemPosition());
        if (satuan.equals("0")) {
            if (konversi.equals("0")) {
                hasil = input;
            } else if (konversi.equals("1")) {
                hasil = 0.8 * input;
            } else if (konversi.equals("2")) {
                hasil = (1.8 * input) + 32;
            } else if (konversi.equals("3")) {
                hasil = input + 273;
            }
        } else if (satuan.equals("1")) {
            if (konversi.equals("0")) {
                hasil = 1.25 * input;
            } else if (konversi.equals("1")) {
                hasil = input;
            } else if (konversi.equals("2")) {
                hasil = (2.25 * input) + 32;
            } else if (konversi.equals("3")) {
                hasil = (1.25 * input) + 273;
            }
        } else if (satuan.equals("2")) {
            if (konversi.equals("0")) {
                hasil = 0.55555 * (input - 32);
            } else if (konversi.equals("1")) {
                hasil = 0.44444 * (input - 32);
            } else if (konversi.equals("2")) {
                hasil = input;
            } else if (konversi.equals("3")) {
                hasil = (0.55555 * (input - 32)) + 273;
            }
        } else if (satuan.equals("3")) {
            if (konversi.equals("0")) {
                hasil = input - 273;
            } else if (konversi.equals("1")) {
                hasil = 0.8 * (input - 273);
            } else if (konversi.equals("2")) {
                hasil = (1.8 * (input - 273)) + 32;
            } else if (konversi.equals("3")) {
                hasil = input;
            }

        }
        return Double.toString(hasil);
    }
}