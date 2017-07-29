package estudos.dcbmobile.com.exbutterknife;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ricardoogliari on 7/12/16.
 */

public class FragmentInicial extends Fragment {
    //@BindView(R.id.btnComprar)
    //Button button1;
    //@BindView(R.id.btnVender)
    //Button button2;

    @BindViews({ R.id.edtCartaoCredito, R.id.edtValidade })
    List<EditText> viewsCompra;
    @BindViews({ R.id.edtAgencia, R.id.edtContaBancaria})
    List<EditText> viewsVenda;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicial, container,
                false);
        unbinder = ButterKnife.bind(this, view);

        ButterKnife.apply(viewsCompra, DISABLE);
        ButterKnife.apply(viewsVenda, ENABLED, false);

        return view;
    }

    static final ButterKnife.Action<View> DISABLE =
            new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            view.setEnabled(false);
        }
    };
    static final ButterKnife.Setter<View, Boolean> ENABLED =
            new ButterKnife.Setter<View, Boolean>() {
        @Override public void set(View view, Boolean value, int index) {
            view.setEnabled(value);
        }
    };

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /*
    @OnItemSelected(R.id.list_view)
    void onItemSelected(int position) {

    }
     */

    @OnClick(R.id.btnComprar)
    public void comprar() {
        ButterKnife.apply(viewsCompra, ENABLED, true);
        ButterKnife.apply(viewsVenda, ENABLED, false);
    }

    @OnClick(R.id.btnVender)
    public void vender() {
        ButterKnife.apply(viewsCompra, ENABLED, false);
        ButterKnife.apply(viewsVenda, ENABLED, true);
    }

    /*
    @OnClick({ R.id.door1, R.id.door2, R.id.door3 })
    public void pickDoor(View door) {
      if (door.hasPrizeBehind()) {
        Toast.makeText(this, "You win!", LENGTH_SHORT).show();
      } else {
        Toast.makeText(this, "Try again", LENGTH_SHORT).show();
      }
    }
     */



}
