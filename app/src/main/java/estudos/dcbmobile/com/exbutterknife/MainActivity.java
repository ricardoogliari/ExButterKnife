package estudos.dcbmobile.com.exbutterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edtNome)
    EditText edtNome;
    @BindView(R.id.edtSenha)
    EditText edtSenha;
    @BindView(R.id.edtConfirmSenha)
    EditText edtConfirmarSenha;

    @BindString(R.string.message_error) String messageError;
    //@BindDrawable(R.drawable.graphic) Drawable graphic;
    //@BindColor(R.color.red) int red;
    //@BindDimen(R.dimen.spacer) Float spacer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
    }

    public void entrar(View view){
        if (edtNome.getText().toString().equals("abc") && edtSenha.getText().toString().equals("abc")){
            getFragmentManager().beginTransaction().add(R.id.frame, new FragmentInicial()).commitAllowingStateLoss();
        } else {
            Toast.makeText(this, "teste " + messageError, Toast.LENGTH_LONG).show();
        }
    }
}

// https://www.sitepoint.com/tidying-code-with-android-butterknife/
// http://jakewharton.github.io/butterknife/
// https://github.com/JakeWharton/butterknife#download
