package edu.cmu.kat.tartanhacks2017.views;

import com.fitbit.api.models.User;
import edu.cmu.kat.tartanhacks2017.R;
import edu.cmu.kat.tartanhacks2017.databinding.LayoutInfoBinding;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;


/**
 * Created by kat on 2/10/17.
 */

public class ProfileInfoView extends LinearLayout {

    private LayoutInfoBinding binding;

    public ProfileInfoView(Context context) {
        super(context);
        init();
    }

    public ProfileInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProfileInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ProfileInfoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        binding = DataBindingUtil.inflate(((Activity) getContext()).getLayoutInflater(), R.layout.layout_info, this, true);
        binding.setTitleText(R.string.user_info);
        binding.setInfoText(getContext().getString(R.string.loading));
    }

    /**
     * Adds a string constructed from the user response data to the binding.
     *
     * @param user the user whose info should be displayed
     */
    public void bindProfileInfo(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        // EDIT THIS TO GET AT USER INFOS
        try {
            JSONObject jsonObject = new JSONObject(new Gson().toJson(user));

            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jsonObject.get(key);
                if (!(value instanceof JSONObject)
                        && !(value instanceof JSONArray)) {
                    stringBuilder.append("<b>");
                    stringBuilder.append(key);
                    stringBuilder.append(":</b>&nbsp;");
                    stringBuilder.append(value.toString());
                    stringBuilder.append("<br>");
                }
            }

            binding.setInfoText(Html.fromHtml(stringBuilder.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
