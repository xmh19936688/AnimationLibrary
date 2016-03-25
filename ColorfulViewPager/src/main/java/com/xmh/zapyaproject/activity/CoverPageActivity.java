package com.xmh.colorfulviewpager.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xmh.colorfulviewpager.R;
import com.xmh.colorfulviewpager.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CoverPageActivity extends BaseActivity {

	@Bind(R.id.vp_views)ViewPager vpViews;

	PagerAdapter adapter=new PagerAdapter() {
		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = LayoutInflater.from(CoverPageActivity.this).inflate(R.layout.layout_page,container,false);
			Button btn= (Button) view.findViewById(R.id.btn_index);
			btn.setText("page:"+position);
			container.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
			return view;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view==object;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cover_page);
		ButterKnife.bind(this);

		initPager();
	}

	private void initPager() {
		vpViews.setAdapter(adapter);
		vpViews.setOffscreenPageLimit(adapter.getCount());
		vpViews.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				int color1=0xffFF8080;
				int color2=0xff8080FF;
				int color3=0xff80ff80;
				int color=0;
				if(position==0){
					int red = (int) (Color.red(color1) * (1 - positionOffset) + Color.red(color2) * (positionOffset));
					int green= (int) (Color.green(color1) * (1 - positionOffset) + Color.green(color2) * (positionOffset));
					int blue = (int) (Color.blue(color1) * (1 - positionOffset) + Color.blue(color2) * (positionOffset));

					color= Color.rgb(red,green,blue);
					Log.e("xmh-color","color1:"+color1+",color:"+color);

				}else if(position==1){
					int red = (int) (Color.red(color2) * (1 - positionOffset) + Color.red(color3) * (positionOffset));
					int green= (int) (Color.green(color2) * (1 - positionOffset) + Color.green(color3) * (positionOffset));
					int blue = (int) (Color.blue(color2) * (1 - positionOffset) + Color.blue(color3) * (positionOffset));

					color= Color.rgb(red,green,blue);
					Log.e("xmh-color","color2:"+color2+",color:"+color);

				}else if(position==2){
					int red = (int) (Color.red(color3) * (1 - positionOffset) + Color.red(color1) * (positionOffset));
					int green= (int) (Color.green(color3) * (1 - positionOffset) + Color.green(color1) * (positionOffset));
					int blue = (int) (Color.blue(color3) * (1 - positionOffset) + Color.blue(color1) * (positionOffset));

					color= Color.rgb(red,green,blue);
					Log.e("xmh-color","color3:"+color3+",color:"+color);
				}
				vpViews.setBackgroundColor(color);
			}

			@Override
			public void onPageSelected(int position) {}

			@Override
			public void onPageScrollStateChanged(int state) {}
		});
	}

}