package edu.cmu.kat.tartanhacks2017.views;

import edu.cmu.kat.tartanhacks2017.R;
import edu.cmu.kat.tartanhacks2017.databinding.LayoutInfoBinding;

import com.fitbit.api.models.Activities;
import com.fitbit.api.models.Total_;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by kat on 2/10/17.
 */

public class MainMenuActivityView extends LinearLayout {

    private LayoutInfoBinding binding;

    public MainMenuActivityView(Context context) {
        super(context);
        init();
    }

    public MainMenuActivityView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MainMenuActivityView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MainMenuActivityView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        binding = DataBindingUtil.inflate(((Activity) getContext()).getLayoutInflater(), R.layout.layout_info, this, true);
        binding.setTitleText(R.string.activity_info);
        binding.setInfoText(getContext().getString(R.string.no_data));
    }

    private String formatNumber(Number number) {
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(number);
    }

    public void bindActivityData(Activities activities) {
        StringBuilder stringBuilder = new StringBuilder();

        Total_ lifetimeTotal = activities.getLifetime().getTotal();
        stringBuilder.append("<b>Total Steps:</b> ");
        stringBuilder.append(formatNumber(lifetimeTotal.getSteps()));
        stringBuilder.append("<br />");

        stringBuilder.append("<b>Total Calories Out:</b> ");
        stringBuilder.append(formatNumber(lifetimeTotal.getCaloriesOut()));
        stringBuilder.append("<br />");

        stringBuilder.append("<b>Total Floors Climbed:</b> ");
        stringBuilder.append("0");
        //stringBuilder.append(formatNumber(lifetimeTotal.getFloors()));
        stringBuilder.append("<br />");

        stringBuilder.append("<b>Total Distance Traveled:</b> ");
        stringBuilder.append(formatNumber(lifetimeTotal.getDistance()));

        binding.setInfoText(Html.fromHtml(stringBuilder.toString()));
    }
}
