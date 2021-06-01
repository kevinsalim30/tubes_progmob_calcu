package id.klp1.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

import java.util.Arrays;

public class FragmentBerat extends Fragment {
    EditText editTxtNilai;
    Button btnKonversi;
    TextView txtHasil;
    Spinner spinnerSatuan, spinnerKonversi;

    public FragmentBerat() {
        // Required empty public constructor
    }

    public static FragmentBerat newInstance() {
        Bundle args = new Bundle();
        FragmentBerat fragment = new FragmentBerat();
        fragment.setArguments(args);
        return fragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_fragment_berat, container, false);

        spinnerSatuan = (Spinner) view.findViewById(R.id.spinnerSatuan);
        spinnerKonversi = view.findViewById(R.id.spinnerKonversi);
        editTxtNilai = view.findViewById(R.id.editTxtNilai);
        txtHasil = view.findViewById(R.id.txtHasil);
        btnKonversi = view.findViewById(R.id.btnKonvert);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.satuanArrayBerat, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSatuan.setAdapter(adapter);
        spinnerSatuan.setSelection(3);
        spinnerKonversi.setAdapter(adapter);
        spinnerKonversi.setSelection(3);

        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konversi(view);
            }
        });
        return view;
    }


    public void konversi(View view) {
        String satuanAwal = spinnerSatuan.getSelectedItem().toString();
        String satuanKonversi = spinnerKonversi.getSelectedItem().toString();
        String input = editTxtNilai.getText() + "";
        if (input.isEmpty()) {
            Toast.makeText(this.getActivity(), "Masukan nilai", Toast.LENGTH_SHORT).show();
        } else {
            double nilai = Double.parseDouble(input);
            String[] satuan = {"Kilogram", "Hektogram", "Dekagram", "Gram", "Desigram", "Centigram", "Miligram"};
            int indexAwal = Arrays.asList(satuan).indexOf(satuanAwal);
            int indexKonversi = Arrays.asList(satuan).indexOf(satuanKonversi);
            int selisihIndex = indexAwal - indexKonversi;
            double hasil = nilai / getRumus(selisihIndex);
            txtHasil.setText(Double.toString(hasil));
        }
    }

    public double getRumus(int selisihIndex) {
        double rumus = 1;
        if (selisihIndex > 0) {
            //jika selisih positif (naik)
            for (int i = 0; i < selisihIndex; i++) {
                rumus *= 10; // setiap selisih dikali 10
            }
        } else {
            //jika selisi negatif negatif (turun)
            for (int i = 0; i > selisihIndex; i--) {
                rumus /= 10; // setiap selisih dibagi 10
            }
        }
        return rumus;
    }
}