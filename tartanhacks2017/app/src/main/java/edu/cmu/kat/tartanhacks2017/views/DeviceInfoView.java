package edu.cmu.kat.tartanhacks2017.views;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.fitbit.api.models.Device;

import edu.cmu.kat.tartanhacks2017.R;
import edu.cmu.kat.tartanhacks2017.databinding.LayoutInfoBinding;

/**
 * Created by kat on 2/10/17.
 */

public class DeviceInfoView extends LinearLayout {

    private LayoutInfoBinding binding;

    public DeviceInfoView(Context context) {
        super(context);
        init();
    }

    public DeviceInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DeviceInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DeviceInfoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        binding = DataBindingUtil.inflate(((Activity) getContext()).getLayoutInflater(), R.layout.layout_info, this, true);
        binding.setTitleText(R.string.devices);
        binding.setInfoText(getContext().getString(R.string.loading));
    }

    /**
     * Sets info about each device linked.
     * @param devices array of devices linked for this user
     */
    public void bindDevices(Device[] devices) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Device device : devices) {
            stringBuilder.append("<b>FITBIT ");
            stringBuilder.append(device.getDeviceVersion().toUpperCase());
            stringBuilder.append("&trade;</b><br>");

            stringBuilder.append("<b>&nbsp;&nbsp;Type: </b>");
            stringBuilder.append(device.getType().toLowerCase());
            stringBuilder.append("<br>");

            stringBuilder.append("<b>&nbsp;&nbsp;Last Sync: </b>");
            stringBuilder.append(device.getLastSyncTime());
            stringBuilder.append("<br>");

            stringBuilder.append("<b>&nbsp;&nbsp;Battery Level: </b>");
            stringBuilder.append(device.getBattery());
            stringBuilder.append("<br><br>");
        }

        if (devices.length < 1) {
            stringBuilder.append("<p>Whoops! Looks like you don't have any devices connected.</p>");
        }

        StringBuilder title = new StringBuilder("<h1>Your connected devices</h1>");
        binding.setInfoText(Html.fromHtml(stringBuilder.toString()));
    }
}
