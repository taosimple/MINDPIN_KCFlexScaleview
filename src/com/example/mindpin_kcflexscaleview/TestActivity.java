package com.example.mindpin_kcflexscaleview;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.example.mindpin_kcflexscaleview.R;


public class TestActivity extends Activity {
	boolean boo = false;
	float tX, tY;
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_test);
	final View root = findViewById(R.id.root);
	//api > 10 开启硬件加速
	if (Build.VERSION.SDK_INT > 10) {
	root.setLayerType(View.LAYER_TYPE_HARDWARE, null);
	}
	
	root.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {
					Log.i("onClick", "---onClick----" + v.getWidth() + "   /   " + v.getHeight());
	
						if (boo) {
						root.startAnimation(getBigScaleAnim(tX, tY));
					} else {
						root.startAnimation(getSmallScaleAnim(tX, tY));
					}
					boo = !boo;
					}
				});
	        
			//获取点击坐标
				root.setOnTouchListener(new OnTouchListener() {
	
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						tX = event.getX();
						tY = event.getY();
						Log.i("onTouch", "tX = " + tX + " tY = " + tY);
						return false;
					}
				});
		
			}
		
		/**
			 * 左上角textview点击事件
			 * @param v
			 */
			public void doClick(View v) {
				Log.i("doClick", "doClick--view = " + v);
			}
		
			/**
			 * 
			 * @param cX 缩放中心x坐标
			 * @param cY 绽放中心y坐标
			 * @return
			 */
			private Animation getBigScaleAnim(float cX, float cY) {
				ScaleAnimation scale = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, cX,
						cY);
				//设置加速器
				scale.setInterpolator(new AccelerateInterpolator());
				//动画时长
				scale.setDuration(600);
				//
				scale.setFillAfter(true);
				return scale;
			}
		
			/**
			 * 
			 * @param cX 缩放中心x坐标
			 * @param cY 绽放中心y坐标
			 * @return
			 */
			private Animation getSmallScaleAnim(float cX, float cY) {
				ScaleAnimation scale = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, cX,
						cY);
				// scale.setInterpolator(new LinearInterpolator());
				scale.setDuration(600);
				scale.setFillAfter(true);
				return scale;
			}
		
			
		}
