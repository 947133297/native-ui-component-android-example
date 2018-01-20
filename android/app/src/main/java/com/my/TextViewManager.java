package com.my;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.Map;

import static java.security.AccessController.getContext;


public class TextViewManager extends SimpleViewManager<TextView> {

    private static final String REACT_CLASS = "RCTTextView";
    private static final String MY_EVENT_NAME = "event_name_to_js";

    // JS通过这里返回的name值来获取当前子类
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    // 视图都是在这个方法中创建的
    @Override
    protected TextView createViewInstance(final ThemedReactContext reactContext) {
        final TextView tv = new TextView(reactContext);
        tv.setBackgroundColor(Color.RED);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("clickclick","接收到点击事件");

                // 将事件传递给JS
                WritableMap event = Arguments.createMap();
                event.putString("message", "myEventData");
//              ReactContext reactContext = (ReactContext)getContext();
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(tv.getId(), MY_EVENT_NAME, event);
            }
        });
        return tv;
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put(
                        MY_EVENT_NAME,
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onChange")))
                .build();
    }

    @ReactProp(name = "title")
    public void setTitle(TextView view, @Nullable String text) {
        view.setText(text);
    }
}