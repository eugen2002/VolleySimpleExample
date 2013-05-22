package ua.volleysimple;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ClassVolley {
	private static RequestQueue requestQueue;

	private ClassVolley() {} 

	static void init(Context context) {
		requestQueue = Volley.newRequestQueue(context);
	}

	public static RequestQueue getRequestQueue() {
	    if (requestQueue != null) {
	        return requestQueue;
	    } else {
	        throw new IllegalStateException("Not initialized");
	    }
	}
}
