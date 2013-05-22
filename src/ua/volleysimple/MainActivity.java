package ua.volleysimple;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {

	private TextView		tvResult;
	private final String	BASE_URL	= "http://apitest.yalantis.com";
	private final String	LOG_TAG		= getClass().getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvResult = (TextView) findViewById(R.id.tv_result);

		Button btnJsonRequest = (Button) findViewById(R.id.btnRequest);
		btnJsonRequest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				String url = BASE_URL + "/test/";
				RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

				JsonObjectRequest request = new JsonObjectRequest(Method.GET, url, null,
						successListener(), errorListener());

				requestQueue.add(request);
			}
		});
	}

	private Response.Listener<JSONObject> successListener() {
		return new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				Log.d(LOG_TAG, response.toString());
				tvResult.setText(response.toString());
			}
		};
	}

	private Response.ErrorListener errorListener() {
		return new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				tvResult.setText(error.getMessage());
			}
		};
	}
}