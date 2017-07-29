package estudos.dcbmobile.com.exbutterknife;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edtNome) public EditText edtNome;
    @BindView(R.id.edtSenha) public EditText edtSenha;

    @BindString(R.string.message_error) String messageError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
    }

    public void entrar(View view){
        if (edtNome.getText().toString().equals("a") &&
                edtSenha.getText().toString().equals("a")){
            FragmentManager fragMgr = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragMgr.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.add(
                    R.id.frame, new FragmentInicial());
            fragmentTransaction.commitAllowingStateLoss();
        } else {
            Toast.makeText(this, messageError, Toast.LENGTH_LONG).show();
        }
    }
}
